package com.diplome.viktory.translater.logic.translater.fragments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.DirectionInteractor;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.translater.interfaces.RequestCreatedListener;
import com.diplome.viktory.translater.logic.translater.ResultObjectContext;
import com.diplome.viktory.translater.services.InternetChecker;
import com.diplome.viktory.translater.services.RequestCreater;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class TranslateFragment extends Fragment implements View.OnClickListener, RequestCreatedListener{

    private Spinner spinner1, spinner2;
    private ImageView imageViewRight, imageViewLeft;
    private EditText editTextLeft, editTextRight;
    private boolean isAutoDeterminate;
    private RequestCreater mRequestCreater;
    private String result;
    private ServiceConnection mServiceConnection;
    private boolean mBond = false;


    private String[] languages;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.translate__layout, container, false);
        spinner1 = (Spinner) view.findViewById(R.id.spinner_first);
        spinner2 = (Spinner) view.findViewById(R.id.spinner_second);
        imageViewLeft = (ImageView) view.findViewById(R.id.translate_left);
        imageViewRight = (ImageView) view.findViewById(R.id.translate_right);
        editTextLeft = (EditText) view.findViewById(R.id.edit_left);
        editTextRight = (EditText) view.findViewById(R.id.edit_right);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                RequestCreater.LocalBinder binder = (RequestCreater.LocalBinder) service;
                mRequestCreater = binder.getService();
                mRequestCreater.setTranslateFragment(TranslateFragment.this);
                mBond = true;
                Log.d(KeysInteractor.KeysField.LOG_TAG, mRequestCreater.getClass().getCanonicalName() + " : onServiceConnected ");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onServiceDisconnected ");
                mBond = false;
                mRequestCreater = null;
            }
        };


        imageViewRight.setOnClickListener(this);
        imageViewLeft.setOnClickListener(this);

        languages = getResources().getStringArray(R.array.languages);



      /*  // Подключаем свой шаблон с разными значками
        MyCustomAdapter adapter = new MyCustomAdapter(getContext(),
                R.layout.spinner_languages_item, languages);*/

        // Вызываем адапетр
        //   spinner1.setAdapter(adapter);
        spinner1.setSelection(2, true);

        // Вызываем адапетр 2
        //  spinner2.setAdapter(adapter);
        spinner2.setSelection(1, true);



        return view;
    }

    @Override
    public void onClick(View v) {
        if ((editTextLeft.getText().toString() == "") && (editTextRight.getText().toString() == ""))
            return;
        // startService(new Intent(this, RequestCreater.class));

        InternetChecker internetChecker = new InternetChecker();
        internetChecker.execute(getContext());

        try {
            if ((internetChecker.get()) && mBond) {

                switch (v.getId()) {
                    case R.id.translate_left:

                        // Пишем ахренеть какой сложный запрос

                        if (mRequestCreater != null)
                            mRequestCreater
                                    .makeResponse(false,
                                            editTextRight.getText().toString(),
                                            mRequestCreater.getLanguageMap().get(spinner2.getSelectedItemPosition()),
                                            mRequestCreater.getLanguageMap().get(spinner1.getSelectedItemPosition()), DirectionInteractor.Direction.LEFT);
                        break;
                    case R.id.translate_right:
                        // Пишем ахренеть какой сложный запрос
                        if (mRequestCreater != null)
                            mRequestCreater
                                    .makeResponse(false,
                                            editTextLeft.getText().toString(),
                                            mRequestCreater.getLanguageMap().get(spinner1.getSelectedItemPosition()),
                                            mRequestCreater.getLanguageMap().get(spinner2.getSelectedItemPosition()), DirectionInteractor.Direction.RIGHT);
                        break;
                }


            } else {
                Toast.makeText(getContext(), R.string.has_not_internet, Toast.LENGTH_SHORT).show();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mBond) {
            getContext().unbindService(mServiceConnection);
            //stopService(new Intent(this, RequestCreater.class));
            mBond = false;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        context.bindService(new Intent(getContext(), RequestCreater.class), mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onEndedResponseCreated(Response<ResultObjectContext> response, int direction) {
        StringBuilder stringBuilder = new StringBuilder();

        List<String> stringList = response.body().getText();

        for (int i = 0; i < stringList.size(); i++) {
            stringBuilder.append(stringList.get(i));
        }

        if (direction == DirectionInteractor.Direction.RIGHT)
            editTextRight.setText(stringBuilder.toString());
        else
            editTextLeft.setText(stringBuilder.toString());
    }
}
