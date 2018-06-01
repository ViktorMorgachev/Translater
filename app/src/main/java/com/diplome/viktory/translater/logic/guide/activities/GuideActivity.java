package com.diplome.viktory.translater.logic.guide.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.fragments.GuideFragment;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<String> mTittlesList = new ArrayList<>();
    // будет идти документ, который он должен загрузить
    private List<String> mFilesList = new ArrayList<>();
    private ContextStorage mContextStorage;
    private Map<String, String> mContextTittlesMap;

    public String getKey() {
        return Key;
    }

    private String Key;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_fragment_container);


        Key = getIntent()
                .getStringExtra(LanguagesInteractor.KeysField.EXTRA_KEY);

        if (Key.equalsIgnoreCase(LanguagesInteractor.KeysField.RUSSIAN)) {
            Key = LanguagesInteractor.KeysField.RUSSIAN;
        } else if (Key.equalsIgnoreCase(LanguagesInteractor.KeysField.ENGLISH)) {
            Key = LanguagesInteractor.KeysField.ENGLISH;
        } else {
            Key = LanguagesInteractor.KeysField.KYRGUZS;
        }


        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() +
                " : onCreate, key = " + Key);

        mContextStorage = new ContextStorage(Key);


        mContextTittlesMap = mContextStorage.getContextList();


        for(String key : mContextTittlesMap.keySet()) {
            mTittlesList.add(key);
            mFilesList.add(mContextTittlesMap.get(key));
        }


        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() +
                " : onCreate, titles.size = " + mTittlesList.size() + "\n" +
                " files.size = " + mTittlesList.size() + "\n" + mContextTittlesMap.toString());


        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);


    }

    private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // Нужно вытащить ключ и значение по индексу из карты
            Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : getItem, position = " + position);
            Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() +
                    " : onCreate, tittles = " + mTittlesList.get(position));
            return GuideFragment.newInstance(mFilesList.get(position));
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mTittlesList.get(position);
        }

        @Override
        public int getCount() {
             return mTittlesList.size();
        }
    }

    public class ContextStorage {

        SharedPreferences mSharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(GuideActivity.this);
        // Должен хранится список Файлов
        // Должен хнанится список заголовков
        private List<Map<String, String>> mMapListContext = new ArrayList<>();
        private String Key;


        public ContextStorage(String key) {
          this.Key = key;
        }


        private Map<String, String> initKyrguzsOnKyrguzs() {

            Map<String, String> files = new HashMap<>();
            files.put(getResources().getString(R.string.nouns), "kurguz_nouns_rus");
            return files;
        }

        private Map<String, String> initKyrguzsOnRussian() {


            Map<String, String> files = new HashMap<>();

            files.put(getResources().getString(R.string.nouns), "kurguz_nouns_rus");
            return files;


        }

        private Map<String, String> initKyrguzsOnEnglish() {

            Map<String, String> files = new HashMap<>();
            files.put(getResources().getString(R.string.nouns), "kurguz_nouns_en");
            return files;

        }

        private Map<String, String> initRussianOnKyrguzs() {

            Map<String, String> files = new HashMap<>();
            files.put(getResources().getString(R.string.adjectives), "russian_adjectives_kg");
            files.put(getResources().getString(R.string.enumeration), "russian_enumeration_kg");
            files.put(getResources().getString(R.string.nouns), "russian_nouns_kg");
            files.put(getResources().getString(R.string.pronouns), "russian_pronouns_kg");
            files.put(getResources().getString(R.string.verbs), "russian_verbs_kg");
            return files;

        }

        private Map<String, String> initRussianOnRussian() {

            Map<String, String> files = new HashMap<>();
            files.put(getResources().getString(R.string.adjectives), "russian_adjectives_rus");
            files.put(getResources().getString(R.string.enumeration), "russian_enumeration_rus");
            files.put(getResources().getString(R.string.nouns), "russian_nouns_rus");
            files.put(getResources().getString(R.string.pronouns), "russian_pronouns_rus");
            files.put(getResources().getString(R.string.verbs), "russian_verbs_rus");
            return files;

        }

        private Map<String, String> initRussianOnEnglish() {


            Map<String, String> files = new HashMap<>();
            files.put(getResources().getString(R.string.adjectives), "russian_adjectives_en");
            files.put(getResources().getString(R.string.enumeration), "russian_enumeration_en");
            files.put(getResources().getString(R.string.nouns), "russian_nouns_en");
            files.put(getResources().getString(R.string.pronouns), "russian_pronouns_en");
            files.put(getResources().getString(R.string.verbs), "russian_verbs_en");
            return files;
        }

        private Map<String, String> initEnglishOnEnglish() {

            Map<String, String> files = new HashMap<>();

            files.put(getResources().getString(R.string.adjectives), "english_adjectives_en");
            files.put(getResources().getString(R.string.nouns), "english_nouns_en");
            files.put(getResources().getString(R.string.pronouns), "english_pronouns_en");
            files.put(getResources().getString(R.string.strings), "english_strings_en");
            files.put(getResources().getString(R.string.verbs_times), "english_verbs_time_en");
            files.put(getResources().getString(R.string.verbs), "english_verbs_en");
            return files;
        }

        private Map<String, String> initEnglishOnKyrguzs() {

            Map<String, String> files = new HashMap<>();

            files.put(getResources().getString(R.string.adjectives), "english_adjectives_kg");
            files.put(getResources().getString(R.string.nouns), "english_nouns_kg");
            files.put(getResources().getString(R.string.pronouns), "english_pronouns_kg");
            files.put(getResources().getString(R.string.strings), "english_strings_kg");
            files.put(getResources().getString(R.string.verbs_times), "english_verbs_time_kg");
            files.put(getResources().getString(R.string.verbs), "english_verbs_kg");
            return files;
        }

        private Map<String, String> initEnglishOnRussian() {

            Map<String, String> files = new HashMap<>();

            files.put(getResources().getString(R.string.adjectives), "english_adjectives_rus");
            files.put(getResources().getString(R.string.nouns), "english_nouns_rus");
            files.put(getResources().getString(R.string.pronouns), "english_pronouns_rus");
            files.put(getResources().getString(R.string.strings), "english_strings_rus");
            files.put(getResources().getString(R.string.verbs_times), "english_verbs_time_rus");
            files.put(getResources().getString(R.string.verbs), "english_verbs_rus");
            return files;
        }


        Map<String, String> getContextList(){

            String nativeLanguage =  mSharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                    LanguagesInteractor.KeysField.RUSSIAN);

            if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.ENGLISH)) {

                Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getLocalClassName() +
                        " : getContextList -> nativeEnglishLanguage");

                switch (Key) {
                    case LanguagesInteractor.KeysField.ENGLISH:
                       return initEnglishOnEnglish();
                    case LanguagesInteractor.KeysField.KYRGUZS:
                      return initKyrguzsOnEnglish();
                    case LanguagesInteractor.KeysField.RUSSIAN:
                        return  initRussianOnEnglish();
                }
            } else if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.KYRGUZS)) {
                Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getLocalClassName() + " : getContextList -> nativeKyrguzsLanguage");
                switch (Key) {
                    case LanguagesInteractor.KeysField.ENGLISH:
                        return initEnglishOnKyrguzs();
                    case LanguagesInteractor.KeysField.KYRGUZS:
                        return initKyrguzsOnKyrguzs();
                    case LanguagesInteractor.KeysField.RUSSIAN:
                        return initRussianOnKyrguzs();
                }

            } else {
                Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getLocalClassName() + " : getContextList -> nativeRussianLanguage");
                switch (Key) {
                    case LanguagesInteractor.KeysField.ENGLISH:
                        return initEnglishOnRussian();
                    case LanguagesInteractor.KeysField.KYRGUZS:
                        return initKyrguzsOnRussian();
                    case LanguagesInteractor.KeysField.RUSSIAN:
                        return initRussianOnRussian();
                }

            }

            throw  new UnsupportedOperationException();
        }

    }

}


