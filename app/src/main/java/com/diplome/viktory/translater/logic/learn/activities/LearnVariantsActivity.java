package com.diplome.viktory.translater.logic.learn.activities;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.logic.learn.database.DataBaseWorker;
import com.diplome.viktory.translater.logic.learn.database.ExtendedRealmObject;
import com.diplome.viktory.translater.logic.learn.fragments.LearnVariantsFragment;
import com.diplome.viktory.translater.logic.learn.fragments.ResultFragment;
import com.diplome.viktory.translater.logic.learn.interfaces.QuestionInitialize;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;

public class LearnVariantsActivity extends AppCompatActivity
        implements LearnVariantsFragment.OnButtonClickListener {

    private List<ExtendedRealmObject> mRealmObjects = new ArrayList<>();
    private QuestionInitialize mQuestionInitialize;
    protected int countOfTrueAnswers;
    protected boolean isShowImage;
    protected Fragment mFragment;
    protected FragmentManager mFragmentManager = getSupportFragmentManager();
    protected Realm mRealm;
    protected int countOfFalseAnswers;
    protected int countOfObject;

    @Override
    public void onButtonPressed(View view, boolean trueFalse) {
        if (trueFalse) {
            ((Button) view).setBackgroundColor(Color.GREEN);
            countOfTrueAnswers++;
        }
        else {
            ((Button) view).setBackgroundColor(Color.RED);
            countOfFalseAnswers++;
        }

        new MyAsyncTask().execute();



    }


    @Override
    protected void onResume() {
        super.onResume();
        isShowImage = PreferenceManager.getDefaultSharedPreferences(this).
                getBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }

    protected void showResult() {
            // Отправить в него полученные результаты
            mFragment = ResultFragment.newInstance(countOfTrueAnswers, countOfFalseAnswers);
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, mFragment).commit();
    }

    private class MyAsyncTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            SystemClock.sleep(1000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (mRealmObjects.size() == 1) {
                showResult();
                return;
            } else {
                mRealmObjects.remove(mRealmObjects.size() - 1);
                replaceFragment();
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        mRealm = Realm.getDefaultInstance();
        isShowImage = PreferenceManager.getDefaultSharedPreferences(this).
                getBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE, true);

        mQuestionInitialize = new DataBaseWorker();

        initializeRealm();

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
             mFragment = new LearnVariantsFragment().newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getQuestion(this),
                    mRealmObjects.get(mRealmObjects.size() - 1).getAnswer(this),
                    countOfTrueAnswers, countOfFalseAnswers, getRemainingStrings());// И оставшиеся слова)
            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment).commit();
        }
    }



    private void initializeRealm() {
        mQuestionInitialize.QuestionInit(this, mRealm);
        mRealmObjects.addAll(mRealm.where(ExtendedRealmObject.class).findAll());
        countOfObject = mRealmObjects.size();
    }

    private List<String> getRemainingStrings() {
        return mRealmObjects.get(mRealmObjects.size()-1).getWrongAnswers(this);
    }


    private void replaceFragment() {

            mFragment = new LearnVariantsFragment().newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getQuestion(this),
                    mRealmObjects.get(mRealmObjects.size() - 1).getAnswer(this),
                    countOfTrueAnswers, countOfFalseAnswers, getRemainingStrings());
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, mFragment).commit();

    }
}
