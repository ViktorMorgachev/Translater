package com.diplome.viktory.translater.logic.learn.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.learn.database.DataBaseWorker;
import com.diplome.viktory.translater.logic.learn.database.SportObject;
import com.diplome.viktory.translater.logic.learn.fragments.ChoiceVariantsFragment;
import com.diplome.viktory.translater.logic.learn.fragments.LearnStandartFragment;
import com.diplome.viktory.translater.logic.learn.interfaces.SportInitialize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class LearnActivity extends AppCompatActivity implements ChoiceVariantsFragment.OnButtonClickListener, LearnStandartFragment.OnButtonClickListener {
    // For analize this Activity working is first time
    private static boolean isStarted;
    private Fragment mFragment;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private Realm mRealm;
    private SportInitialize mSportInialize;
    private List<SportObject> mSportObjects = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        isStarted = true;

        mSportInialize = new DataBaseWorker();

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null || !isStarted) {
            mFragment = new ChoiceVariantsFragment();
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment).commit();
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
        isStarted = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRealm = Realm.getDefaultInstance();
        isStarted = true;
    }

    @Override
    public void onButtonPressed(View view) {

        // Toast.makeText(this,((Button) view).getText().toString() + " нажали", Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.iv_go:
                mSportObjects.remove(mSportObjects.size()-1);
                if(mSportObjects.size() == 1)
                    return;
                if (mFragment == null || isStarted) {
                    mFragment = LearnStandartFragment.newInstance(mSportObjects.get(mSportObjects.size()-1).getLearnLanguage(),
                            mSportObjects.get(mSportObjects.size()-1).getNativeLanguage());
                    mFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment_container, mFragment).commit();
                }
                Toast.makeText(this, "Нажали на Go", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_colors:
                Toast.makeText(this, "Будем учить цвета", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sport:

                mSportInialize.SportObjectsInit(this, mRealm);
                mSportObjects.addAll(mRealm.where(SportObject.class).findAll());
                if (mFragment == null || isStarted) {

                    mFragment = LearnStandartFragment.newInstance(mSportObjects.get(mSportObjects.size()-1).getLearnLanguage(),
                            mSportObjects.get(mSportObjects.size()-1).getNativeLanguage());


                    mFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment_container, mFragment).commit();
                }
                break;
        }
    }


}
