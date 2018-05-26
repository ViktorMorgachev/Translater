package com.diplome.viktory.translater.logic.settings.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.diplome.viktory.translater.MainActivity;
import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.fragments.SettingsFragments;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.Locale;

public class SettingsActivity extends AppCompatActivity implements SettingsFragments.OnButtonClickListener {

    private Fragment mFragment;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
            mFragment = new SettingsFragments();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment).commit();
        }
    }

    @Override
    public void onNativeLanguageSelected(int id) {

        switch (id) {
            case 0:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                        LanguagesInteractor.KeysField.KYRGUZS).commit();
                break;
            case 1:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                        LanguagesInteractor.KeysField.RUSSIAN).commit();
                break;
            case 2:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                        LanguagesInteractor.KeysField.ENGLISH).commit();
                break;
        }

    }

    @Override
    public void onLearnLanguageSelected(int id) {
        switch (id) {
            case 0:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_LEARN_LANGUAGE,
                        LanguagesInteractor.KeysField.KYRGUZS).commit();
                break;
            case 1:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_LEARN_LANGUAGE,
                        LanguagesInteractor.KeysField.RUSSIAN).commit();
                break;
            case 2:
                mSharedPreferences.edit().putString(KeysSettingsInteractor.KeysField.KEY_LEARN_LANGUAGE,
                        LanguagesInteractor.KeysField.ENGLISH).commit();
                break;
        }

        setDefaultLocale();
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


    }

    @Override
    public void onButtonPressed(View view) {
        // Надо тут будет пофиксить
        if (view.getId() == R.id.btn_back) {
            Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onButtonPressed ");
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    @Override
    public void onShowImageCheched(boolean isChecked) {
        mSharedPreferences.edit().putBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE,
                isChecked).commit();
    }
}
