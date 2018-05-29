package com.diplome.viktory.translater.logic.learn.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.learn.database.DataBaseWorker;
import com.diplome.viktory.translater.logic.learn.database.SimpleRealmObject;
import com.diplome.viktory.translater.logic.learn.fragments.ChoiceVariantsFragment;
import com.diplome.viktory.translater.logic.learn.fragments.LearnStandartFragment;
import com.diplome.viktory.translater.logic.learn.fragments.ResultFragment;
import com.diplome.viktory.translater.logic.learn.interfaces.AnimalsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.ClothesInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.FruitsInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.HobbyInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.SportInitialize;
import com.diplome.viktory.translater.logic.learn.interfaces.VegetablesInitialize;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;

public class LearnActivity extends AppCompatActivity implements ChoiceVariantsFragment.OnButtonClickListener, LearnStandartFragment.OnButtonClickListener {
    // For analize this Activity working is first time
    private static boolean isStarted;
    protected Fragment mFragment;
    protected FragmentManager mFragmentManager = getSupportFragmentManager();
    protected Realm mRealm;
    private SportInitialize mSportInialize;
    private HobbyInitialize mHobbyInitialize;
    private FruitsInitialize mFruitsInitialize;
    private AnimalsInitialize mAnimalsInitialize;
    private ClothesInitialize mClothesInitialize;
    private VegetablesInitialize mVegetablesInitialize;
    protected int countOfTrueAnswers;
    protected boolean isShowImage;
    protected int countOfFalseAnswers;
    protected int countOfObject;
    private List<SimpleRealmObject> mRealmObjects = new ArrayList<>();

    @Override
    protected void onResume() {
        super.onResume();
        mRealm = Realm.getDefaultInstance();
        isShowImage = PreferenceManager.getDefaultSharedPreferences(this).
                getBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE, true);
    }




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_fragment_container);
        isStarted = true;
        isShowImage = PreferenceManager.getDefaultSharedPreferences(this).
                getBoolean(KeysSettingsInteractor.KeysField.KEY_SHOW_IMAGE, true);


        mSportInialize = new DataBaseWorker();
        mHobbyInitialize = new DataBaseWorker();
        mFruitsInitialize = new DataBaseWorker();
        mVegetablesInitialize = new DataBaseWorker();
        mAnimalsInitialize = new DataBaseWorker();
        mClothesInitialize = new DataBaseWorker();

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
        isStarted = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mRealm.close();
    }

    @Override
    public void onButtonPressed(View view, boolean trueFalse) {

        if (trueFalse)
            countOfTrueAnswers++;
        else countOfFalseAnswers++;

        switch (view.getId()) {
            case R.id.iv_go:
                if (mRealmObjects.size() == 1) {
                    showResult();
                    return;
                }
                mRealmObjects.remove(mRealmObjects.size() - 1);

                if (mFragment == null || isStarted) {
                    mFragment = LearnStandartFragment.newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getLearnLanguage(getApplicationContext()),
                            mRealmObjects.get(mRealmObjects.size() - 1).getNativeLanguage(getApplicationContext()),
                            mRealmObjects.get(mRealmObjects.size() - 1).getImage(), countOfTrueAnswers, countOfFalseAnswers);

                    mFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment_container, mFragment).commit();
                }
                break;
            case R.id.iv_show_result:
                Toast.makeText(this, mRealmObjects.get(mRealmObjects.size() - 1).getNativeLanguage(getApplicationContext()), Toast.LENGTH_LONG).show();
                if (mRealmObjects.size() == 1) {
                    showResult();
                    return;
                }
                mRealmObjects.remove(mRealmObjects.size() - 1);

                if (mFragment == null || isStarted) {
                    mFragment = LearnStandartFragment.newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getLearnLanguage(getApplicationContext()),
                            mRealmObjects.get(mRealmObjects.size() - 1).getNativeLanguage(getApplicationContext()),
                            mRealmObjects.get(mRealmObjects.size() - 1).getImage(), countOfTrueAnswers, countOfFalseAnswers);

                    mFragmentManager.beginTransaction()
                            .replace(R.id.main_fragment_container, mFragment).commit();
                }
                break;

        }
    }

    protected void showResult() {

        if (isStarted) {
            // Отправить в него полученные результаты
            mFragment = ResultFragment.newInstance(countOfTrueAnswers, countOfFalseAnswers);
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, mFragment).commit();
        }
    }


    // Обработка для выбота типа обучения
    @Override
    public void onButtonPressed(View view) {

        switch (view.getId()) {
            case R.id.btn_questions:

                //mFragmentManager.beginTransaction().attach(mFragment).commit();
                Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onButtonPressed ");
                startActivity(new Intent(this, LearnVariantsActivity.class));
                break;
            case R.id.btn_colors:
                startActivity(new Intent(this, LearnVariantsActivity.class));
                break;
            case R.id.btn_sport:
                // Обнуляем счётчики
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);

                mSportInialize.SportInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;
            case R.id.btn_hobby:
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);
                mHobbyInitialize.HobbyInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;
            case R.id.btn_vegetables:
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);
                mVegetablesInitialize.VegetableInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;
            case R.id.btn_fruits:
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);
                mFruitsInitialize.FruitsInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;
            case R.id.btn_animals:
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);
                mAnimalsInitialize.AnimalsInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;
            case R.id.btn_clothes:
                countOfTrueAnswers = (countOfFalseAnswers - countOfFalseAnswers);
                mClothesInitialize.ClosesInit(this, mRealm);
                // Инициализацию и создания фрагмента делаем в отдельной функции, дабы избежать дублирования кода
                initilizeRealmAndCreatedFragment();
                break;


        }
    }

    private void initilizeRealmAndCreatedFragment() {
        mRealmObjects.addAll(mRealm.where(SimpleRealmObject.class).findAll());
        Collections.shuffle(mRealmObjects);
        countOfObject = mRealmObjects.size();

        if (mFragment == null || isStarted) {

            mFragment = LearnStandartFragment.newInstance(mRealmObjects.get(mRealmObjects.size() - 1).getLearnLanguage(getApplicationContext()),
                    mRealmObjects.get(mRealmObjects.size() - 1).getNativeLanguage(getApplicationContext()),
                    mRealmObjects.get(mRealmObjects.size() - 1).getImage(), countOfTrueAnswers, countOfFalseAnswers);

            mFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, mFragment).commit();
        }
    }
}