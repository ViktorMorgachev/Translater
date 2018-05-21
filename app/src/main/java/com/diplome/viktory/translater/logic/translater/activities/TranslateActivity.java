package com.diplome.viktory.translater.logic.translater.activities;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.*;
import com.diplome.viktory.translater.logic.translater.fragments.TranslateFragment;
import com.diplome.viktory.translater.logic.translater.services.InternetChecker;
import com.diplome.viktory.translater.logic.translater.services.RequestCreater;

import java.util.concurrent.ExecutionException;

public class TranslateActivity extends AppCompatActivity implements TranslateFragment.OnButtonClickListener{

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;
    private RequestCreater mRequestCreater;
    private ServiceConnection mServiceConnection;
    private boolean mBond = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);


        if(mFragment == null){
            mFragment = new TranslateFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment)
                    .commit();


        }


        startService(new Intent(this, RequestCreater.class));


        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                RequestCreater.LocalBinder binder = (RequestCreater.LocalBinder) service;
                mRequestCreater = binder.getService();
                mRequestCreater.setFragmentListener(mFragment);
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

    }


    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, RequestCreater.class), mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mServiceConnection);
    }

    @Override
    public void onButtonPressed(View v, String textLeft, String textRight, int spiner1leftPosition, int spiner2rightPosition) {

        // startService(new Intent(this, RequestCreater.class));

        InternetChecker internetChecker = new InternetChecker();
        internetChecker.execute(this);

        try {
            if ((internetChecker.get()) && mBond) {

                switch (v.getId()) {
                    case R.id.translate_left:

                        // Пишем ахренеть какой сложный запрос

                        if (mRequestCreater != null)
                            mRequestCreater
                                    .makeResponse(false,
                                            textRight,
                                            mRequestCreater.getLanguageMap().get(spiner2rightPosition),
                                            mRequestCreater.getLanguageMap().get(spiner1leftPosition), DirectionInteractor.Direction.LEFT);
                        break;
                    case R.id.translate_right:
                        // Пишем ахренеть какой сложный запрос
                        if (mRequestCreater != null)
                            mRequestCreater
                                    .makeResponse(false,
                                            textLeft,
                                            mRequestCreater.getLanguageMap().get(spiner1leftPosition),
                                            mRequestCreater.getLanguageMap().get(spiner2rightPosition), DirectionInteractor.Direction.RIGHT);
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

