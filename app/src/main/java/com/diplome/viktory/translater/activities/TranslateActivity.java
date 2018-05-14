package com.diplome.viktory.translater.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.activities.interactors.DirectionInteractor;
import com.diplome.viktory.translater.activities.interactors.KeysInteractor;
import com.diplome.viktory.translater.activities.services.InternetChecker;
import com.diplome.viktory.translater.interfaces.RequestCreatedListener;
import com.diplome.viktory.translater.activities.services.RequestCreater;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class TranslateActivity extends AppCompatActivity implements View.OnClickListener, RequestCreatedListener {

    private Spinner spinner1, spinner2;
    private ImageView imageViewRight, imageViewLeft;
    private EditText editTextLeft, editTextRight;
    private boolean isAutoDeterminate;
    private RequestCreater mRequestCreater;
    private String result;
    private ServiceConnection mServiceConnection;
    private boolean mBond = false;


    private String[] languages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.translate__layout);
        spinner1 = (Spinner) findViewById(R.id.spinner_first);
        spinner2 = (Spinner) findViewById(R.id.spinner_second);
        imageViewLeft = (ImageView) findViewById(R.id.translate_left);
        imageViewRight = (ImageView) findViewById(R.id.translate_right);
        editTextLeft = (EditText) findViewById(R.id.edit_left);
        editTextRight = (EditText) findViewById(R.id.edit_right);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                RequestCreater.LocalBinder binder = (RequestCreater.LocalBinder) service;
                mRequestCreater = binder.getService();
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


    }

    @Override
    protected void onStart() {
        super.onStart();
        startService(new Intent(this, RequestCreater.class));
        bindService(new Intent(this, RequestCreater.class), mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {

        if ((editTextLeft.getText().toString() == "") && (editTextRight.getText().toString() == ""))
            return;
       // startService(new Intent(this, RequestCreater.class));

        InternetChecker internetChecker = new InternetChecker();
        internetChecker.execute(getApplicationContext());

        try {
            if ((internetChecker.get()) && mBond) {

                switch (v.getId()) {
                    case R.id.translate_left:

                        // Пишем ахренеть какой сложный запрос

                        if(mRequestCreater!= null)
                        mRequestCreater
                                .makeResponse(false,
                                        editTextRight.getText().toString(),
                                        mRequestCreater.getLanguageMap().get(spinner1.getSelectedItemPosition()),
                                        mRequestCreater.getLanguageMap().get(spinner2.getSelectedItemPosition()), DirectionInteractor.Direction.LEFT);
                        break;
                    case R.id.translate_right:
                        // Пишем ахренеть какой сложный запрос
                        if(mRequestCreater != null)
                        mRequestCreater
                                .makeResponse(false,
                                        editTextRight.getText().toString(),
                                        mRequestCreater.getLanguageMap().get(spinner2.getSelectedItemPosition()),
                                        mRequestCreater.getLanguageMap().get(spinner1.getSelectedItemPosition()), DirectionInteractor.Direction.RIGHT);
                        break;
                }


            } else {
                Toast.makeText(this, R.string.has_not_internet, Toast.LENGTH_SHORT).show();
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        //stopService(new Intent(this, RequestCreater.class));
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBond) {
            unbindService(mServiceConnection);
            stopService(new Intent(this, RequestCreater.class));
            mBond = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
        stopService(new Intent(this, RequestCreater.class));

    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
        // Нужно тут указать чтобы запускать метод для открытия меню
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.app_bar_switch) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onEndedResponseCreated(Response response) {
        Toast.makeText(this, response.body().toString(), Toast.LENGTH_SHORT).show();
    }


   /* public class MyCustomAdapter extends ArrayAdapter<String> {

        public MyCustomAdapter(Context context, int textViewResourceId,
                               String[] objects) {
            super(context, textViewResourceId, objects);

        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            return getCustomView(position, convertView, parent);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.item_select_language, parent, false);
            TextView label = (TextView) row.findViewById(R.id.id_text);
            label.setText(languages[position]);

            ImageView icon = (ImageView) row.findViewById(R.id.id_image);

            icon.setImageResource(R.drawable.english_flag);

            return row;
        }
    }*/


}

