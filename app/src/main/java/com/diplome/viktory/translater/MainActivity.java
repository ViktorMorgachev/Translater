package com.diplome.viktory.translater;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.menu.activities.MenuActivity;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

import io.realm.Realm;

import static com.diplome.viktory.translater.interactors.KeysCommonInteractor.KeysField.LOG_TAG;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_layout);

        mButton = (Button) findViewById(R.id.btn_enter);

        mButton.setOnClickListener(this);

        setDefaultLocale();
    }


    private void initWordsDatabase(){
    }

    private void setDefaultLocale() {


        Configuration configuration = getResources().getConfiguration();



        switch (PreferenceManager.getDefaultSharedPreferences(this).getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE, LanguagesInteractor.KeysField.RUSSIAN)){
            case LanguagesInteractor.KeysField.RUSSIAN:
                configuration.locale = new Locale("ru");
                break;
            case LanguagesInteractor.KeysField.ENGLISH:
                configuration.locale = new Locale("en");
                break;
            case LanguagesInteractor.KeysField.KYRGUZS:
                configuration.locale = new Locale("de");
                break;
        }

        getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());


       // Log.d(LOG_TAG, getResources().getConfiguration().getLocales().toString());


    }


    public Bitmap getBitmapFromAssets(String fileName){

        AssetManager assetmanager = getAssets();
        InputStream is = null;
        try{

            is = assetmanager.open(fileName);
        }catch(IOException e){
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        return bitmap;
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, MenuActivity.class));
    }
}
