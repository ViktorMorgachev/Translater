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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<String> mStringList;
    // будет идти документ, который он должен загрузить
    private List<String> mViewList;
    private TittlesStorage mTittlesStorage;

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
        mTittlesStorage = new TittlesStorage(Key);

        mStringList = mTittlesStorage.getTitlesMap(Key);

        mViewList = mTittlesStorage.getLayotsMap(Key);

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
            return GuideFragment.newInstance(mViewList.get(position));
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mStringList.get(position);
        }

        @Override
        public int getCount() {
            return mStringList.size();
        }
    }

    public class TittlesStorage {
        // Integer для того чтобы передавать информацию во фрагмент
        private Map<String, List<String>> mLayoutsListMap;
        // Ключ - раздел языка (Английский, Кыргызский, Русский), а список соответственно названия разделов
        private Map<String, List<String>> mTitleListMap;
        private FilesFactory mFilesFactory = new FilesFactory();


        public TittlesStorage(String key) {
            // В зависимости от параметров, загружается либо на руском, либо на кыргызскоом, либо на английском языке
            // Буду разделять и проводить инициализацию карт только по нужному ключ

            if (key.equalsIgnoreCase(getResources().getString(R.string.english))) {
                mLayoutsListMap.put(LanguagesInteractor.KeysField.ENGLISH,
                        mFilesFactory.initFilesByKey(LanguagesInteractor.KeysField.ENGLISH));
                tittlesInitEnglish();
            } else if (key.equalsIgnoreCase(getResources().getString(R.string.kyrgyzs))) {
                mLayoutsListMap.put(LanguagesInteractor.KeysField.KYRGUZS,
                        mFilesFactory.initFilesByKey(LanguagesInteractor.KeysField.KYRGUZS));
                tittlesInitKyrgyz();
            } else {
                // А обьект уже сам будет анализировать по нативному языку, какие файлы инициализировать
                mLayoutsListMap.put(LanguagesInteractor.KeysField.RUSSIAN,
                        mFilesFactory.initFilesByKey(LanguagesInteractor.KeysField.RUSSIAN));
                tittlesInitRussian();
            }


        }

        private void tittlesInitEnglish() {

            mTitleListMap = new HashMap<>();

            List<String> tittles = new ArrayList<>();

            tittles.addAll(Arrays.asList(
                    GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.strings),
                    GuideActivity.this.getResources().getString(R.string.verbs_times),
                    GuideActivity.this.getResources().getString(R.string.verbs)));
            mTitleListMap.put(LanguagesInteractor.KeysField.ENGLISH, tittles);

        }

        private void tittlesInitRussian() {

            mTitleListMap = new HashMap<>();

            List<String> tittles = new ArrayList<>();

            tittles.addAll(Arrays.asList(
                    GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.enumeration),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.verbs)));
            mTitleListMap.put(LanguagesInteractor.KeysField.RUSSIAN, tittles);

        }

        private void tittlesInitKyrgyz() {
            mTitleListMap = new HashMap<>();

            List<String> tittles = new ArrayList<>();

            tittles.addAll(Arrays.asList(
                    GuideActivity.this.getResources().getString(R.string.songs),
                    GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.phonetics),
                    GuideActivity.this.getResources().getString(R.string.enumeration)));
            mTitleListMap.put(LanguagesInteractor.KeysField.KYRGUZS, tittles);

        }

        private void filesInitEnglish() {

            mLayoutsListMap = new HashMap<>();

            List<String> files = new ArrayList<>();

            files.addAll(Arrays.asList("english_adjectives", "english_nouns",
                    "english_pronouns", "english_strings", "english_verb_times",
                    "english_verbs"));
            mLayoutsListMap.put(LanguagesInteractor.KeysField.ENGLISH, files);

        }

        private void filesInitKyrgyz() {

            mLayoutsListMap = new HashMap<>();

            List<String> files = new ArrayList<>();

            files.addAll(Arrays.asList("english_songs"));
            mLayoutsListMap.put(LanguagesInteractor.KeysField.ENGLISH, files);


        }


        List<String> getTitlesMap(String key) {
            return mTitleListMap.get(key);
        }

        List<String> getLayotsMap(String key) {
            return mLayoutsListMap.get(key);
        }

        private class FilesFactory {

            SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GuideActivity.this);
            List<String> mFilesList = new ArrayList<>();

            public List<String> initFilesByKey(String key) {

                String nativeLanguage = mSharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                        LanguagesInteractor.KeysField.RUSSIAN);

                if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.ENGLISH)) {

                    Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getLocalClassName() + " : initFilesByKey -> nativeEnglishLanguage");

                    switch (key) {
                        case LanguagesInteractor.KeysField.ENGLISH:
                            mFilesList = initEnglishOnEnglish();
                            break;
                        case LanguagesInteractor.KeysField.KYRGUZS:
                            mFilesList = initKyrguzsOnEnglish();
                            break;
                        case LanguagesInteractor.KeysField.RUSSIAN:
                            mFilesList = initRussianOnEnglish();
                            break;
                    }
                } else if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.KYRGUZS)) {
                    Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getLocalClassName() + " : initFilesByKey -> nativeKyrguzsLanguage");

                    switch (key) {
                        case LanguagesInteractor.KeysField.ENGLISH:
                            mFilesList = initEnglishOnKyrguzs();
                            break;
                        case LanguagesInteractor.KeysField.KYRGUZS:
                            mFilesList = initKyrguzsOnKyrguzs();
                            break;
                        case LanguagesInteractor.KeysField.RUSSIAN:
                            mFilesList = initRussianOnKyrguzs();
                            break;
                    }

                } else {

                    switch (key) {
                        case LanguagesInteractor.KeysField.ENGLISH:
                            mFilesList = initEnglishOnRussian();
                            break;
                        case LanguagesInteractor.KeysField.KYRGUZS:
                            mFilesList = initKyrguzsOnRussian();
                            break;
                        case LanguagesInteractor.KeysField.RUSSIAN:
                            mFilesList = initRussianOnRussian();
                            break;
                    }

                }

                return mFilesList;


            }

            private List<String> initEnglishOnEnglish() {

                List<String> files = new ArrayList<>();

                files.addAll(Arrays.asList("english_adjectives_en", "english_nouns_en",
                        "english_pronouns_en", "english_strings_en", "english_verbs_time_en",
                        "english_verbs_en"));
                return files;
            }


            private List<String> initEnglishOnKyrguzs() {

                List<String> files = new ArrayList<>();

                files.addAll(Arrays.asList("english_adjectives_kg", "english_nouns_kg",
                        "english_pronouns_kg", "english_strings_kg", "english_verbs_time_kg",
                        "english_verbs_kg"));
                return  files;
            }

            private List<String> initEnglishOnRussian() {

                List<String> files = new ArrayList<>();

                files.addAll(Arrays.asList("english_adjectives_rus", "english_nouns_rus",
                        "english_pronouns_rus", "english_strings_rus", "english_verbs_time_rus",
                        "english_verbs_rus"));

                return files;
            }
        }
    }

}


