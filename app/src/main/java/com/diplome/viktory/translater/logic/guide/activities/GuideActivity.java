package com.diplome.viktory.translater.logic.guide.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
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
    private TittlesStorage mTittlesStorage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_fragment_container);

        mTittlesStorage = new TittlesStorage();
        mStringList = mTittlesStorage.getMap(getIntent()
                .getStringExtra(LanguagesInteractor.KeysField.EXTRA_KEY));
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });

        Toast.makeText(this, getIntent().getStringExtra(LanguagesInteractor.KeysField.EXTRA_KEY), Toast.LENGTH_SHORT).show();
    }

    private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter{

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GuideFragment.newInstance(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  mStringList.get(position);
        }

        @Override
        public int getCount() {
            return mStringList.size();
        }
    }

     class TittlesStorage{

        // Ключ - раздел языка (Английский, Кыргызский, Русский), а список соответственно названия разделов
        private  Map<String, List<String>> mStringListMap;


        public TittlesStorage() {
           autoInitialize();
        }

        private void autoInitialize() {

            mStringListMap = new HashMap<>();

            List<String> tittles = new ArrayList<>();

            tittles.addAll(Arrays.asList(GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.verbs)));

            mStringListMap.put(LanguagesInteractor.KeysField.ENGLISH, tittles);
            tittles.clear();

            tittles.addAll(Arrays.asList(GuideActivity.this.getResources().getString(R.string.adjectives),
                    GuideActivity.this.getResources().getString(R.string.nouns),
                    GuideActivity.this.getResources().getString(R.string.pronouns),
                    GuideActivity.this.getResources().getString(R.string.verbs)));

            mStringListMap.put(LanguagesInteractor.KeysField.RUSSIAN, tittles);

        }

        List<String> getMap(String key){
            return mStringListMap.get(key);
       }
    }

}


