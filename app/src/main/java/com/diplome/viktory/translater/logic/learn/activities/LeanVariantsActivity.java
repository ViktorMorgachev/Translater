package com.diplome.viktory.translater.logic.learn.activities;

import android.graphics.Color;
import android.os.Bundle;
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
import com.diplome.viktory.translater.logic.learn.database.SimpleRealmObject;
import com.diplome.viktory.translater.logic.learn.fragments.ChoiceVariantsFragment;
import com.diplome.viktory.translater.logic.learn.fragments.LearnStandartFragment;
import com.diplome.viktory.translater.logic.learn.fragments.LearnVariantsFragment;
import com.diplome.viktory.translater.logic.learn.interfaces.QuestionInitialize;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;

public class LeanVariantsActivity extends LearnActivity
        implements LearnVariantsFragment.OnButtonClickListener {

    private List<ExtendedRealmObject> mRealmObjects = new ArrayList<>();
    private QuestionInitialize mQuestionInitialize;
    private List<ExtendedRealmObject> mConstQuestionInitialize;

    @Override
    public void onButtonPressed(View view, boolean trueFalse) {
        if (trueFalse)
            ((Button) view).setBackgroundColor(Color.GREEN);
        else
            ((Button) view).setBackgroundColor(Color.GREEN);
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

    @Override
    protected void onStart() {
        super.onStart();
        mQuestionInitialize = new DataBaseWorker();
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        isShowImage = PreferenceManager.getDefaultSharedPreferences(this).
                getBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE, true);


        initilizeRealmAndCreatedFragment();
        mConstQuestionInitialize = new ArrayList<>(mRealmObjects);

        mFragment = mFragmentManager.findFragmentById(R.id.main_fragment_container);
        if (mFragment == null) {
            mFragment = new LearnVariantsFragment().newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getQuestion(this),
                    mRealmObjects.get(mRealmObjects.size() - 1).getAnswer(this),
                    countOfTrueAnswers, countOfFalseAnswers, getRemainingStrings());// И оставшиеся слова)

            mFragmentManager.beginTransaction()
                    .add(R.id.main_fragment_container, mFragment).commit();
        }
    }

    private List<String> getRemainingStrings() {


        List<String> stringList = new ArrayList<>();
        Collections.shuffle(mConstQuestionInitialize);
        mConstQuestionInitialize.remove(mRealmObjects.get(mRealmObjects.size() - 1));

        for (int i = 0; i < 3; i++) {
            stringList.add(mConstQuestionInitialize.get(i).getQuestion(this));
        }

        return stringList;


    }


    private void initilizeRealmAndCreatedFragment() {

        mRealmObjects.addAll(mRealm.where(ExtendedRealmObject.class).findAll());
        countOfObject = mRealmObjects.size();

        if (mFragment == null) {

            mFragment = new LearnVariantsFragment().newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getQuestion(this),
                    mRealmObjects.get(mRealmObjects.size() - 1).getAnswer(this),
                    countOfTrueAnswers, countOfFalseAnswers, getRemainingStrings());

            mFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, mFragment).commit();
        }
    }
}
