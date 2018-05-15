package com.diplome.viktory.translater.activities;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.fragments.TranslateFragment;
import com.diplome.viktory.translater.interactors.DirectionInteractor;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.services.InternetChecker;
import com.diplome.viktory.translater.interfaces.RequestCreatedListener;
import com.diplome.viktory.translater.services.RequestCreater;
import com.diplome.viktory.translater.logic.translater.ResultObjectContext;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class TranslateActivity extends AppCompatActivity{

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Fragment mFragment;

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

