package com.diplome.viktory.translater.logic.guide.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.guide.fragments.GuideFragment;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private List<String> mStringList;
    private List<Integer> mViewList;
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

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : getItem, position = " + position);
            return GuideFragment.newInstance(position, mViewList.get(position));
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
        private Map<String, List<Integer>> mLayoutsListMap;
        // Ключ - раздел языка (Английский, Кыргызский, Русский), а список соответственно названия разделов
        private Map<String, List<String>> mTitleListMap;


        public TittlesStorage(String key) {
            // В зависимости от параметров, загружается либо на руском, либо на кыргызскоом, либо на английском языке

            // Буду разделять и проводить инициализацию карт только по нужному ключу
            switch (key) {
                case LanguagesInteractor.KeysField.ENGLISH:
                     tittlesInitEnglish();
                     layoutsInitEnglish();
                    break;
                case LanguagesInteractor.KeysField.KYRGUZS:
                    tittlesInitKyrgyz();
                    layoutsInitKyrgyz();
                    break;
            }

            //layoutsInitRussian();
            // tittlesInitRussian();
        }

        private void tittlesInitEnglish() {

            mTitleListMap = new HashMap<>();

            List<String> tittles = new ArrayList<>();

            tittles.addAll(Arrays.asList(
                    GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.verbs),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.strings)));
            mTitleListMap.put(LanguagesInteractor.KeysField.ENGLISH, tittles);

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

        private void layoutsInitEnglish() {

            mLayoutsListMap = new HashMap<>();

            List<Integer> layouts = new ArrayList<>();

            layouts.addAll(Arrays.asList(R.layout.englsih_adjectives_fragment_layout,
                    R.layout.englsih_nouns_fragment_layout,
                    R.layout.englsih_verbs_fragment_layout,
                    R.layout.englsih_pronouns_fragment_layout,
                    R.layout.englsih_strings_fragment_layout));
            mLayoutsListMap.put(LanguagesInteractor.KeysField.ENGLISH, layouts);

        }

        private void layoutsInitKyrgyz() {

            mLayoutsListMap = new HashMap<>();

            List<Integer> layouts = new ArrayList<>();

            layouts.addAll(Arrays.asList(R.layout.kyrgyz_songs_fragment_layout,
                    R.layout.kyrgyz_adjectives_fragment_layout,
                    R.layout.kyrgyz_nouns_fragment_layout,
                    R.layout.kyrgyz_pronouns_fragment_layout,
                    R.layout.kyrgyz_phonetic_fragment_layout,
                    R.layout.kyrgyz_enumeration_fragment_layout));
            mLayoutsListMap.put(LanguagesInteractor.KeysField.KYRGUZS, layouts);


        }


        List<String> getTitlesMap(String key) {
            return mTitleListMap.get(key);
        }

        List<Integer> getLayotsMap(String key) {
            return mLayoutsListMap.get(key);
        }
    }

}


