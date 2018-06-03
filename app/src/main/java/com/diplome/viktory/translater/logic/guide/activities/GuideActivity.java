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
import com.diplome.viktory.translater.logic.guide.fragments.GuideSectionFragment;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;
import com.github.barteksc.pdfviewer.PDFView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuideActivity extends AppCompatActivity {

    private String mFile;
    private Fragment mFragment;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    public static String KEY_FILE = "Name of file";
    PDFView mPDFView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_fragment_layout);

        mFile = getIntent().getStringExtra(KEY_FILE);
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + ": onCreate " +
                "\nFile: " + mFile);

        mPDFView = (PDFView) findViewById(R.id.pdfView);
        mPDFView.fromAsset(mFile+".pdf").load();

    }


}


