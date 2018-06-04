package com.diplome.viktory.translater.logic;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.diplome.viktory.translater.logic.about.activities.AboutActivity;
import com.diplome.viktory.translater.logic.guide.GuideSectionActivity;
import com.diplome.viktory.translater.logic.guide.activities.GuideActivity;
import com.diplome.viktory.translater.logic.learn.activities.LearnActivity;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartAboutActivityListener;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartGuideActivityListener;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartLearnActivityListener;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartSettingsActivityListener;
import com.diplome.viktory.translater.logic.settings.activities.SettingsActivity;
import com.diplome.viktory.translater.logic.translater.activities.TranslateActivity;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartTranslaterActivityListener;

public class ModuleInteractor implements
        OnStartTranslaterActivityListener, OnStartGuideActivityListener,
        OnStartLearnActivityListener, OnStartSettingsActivityListener, OnStartAboutActivityListener {

    @Override
    public  void startTranslaterActivity(Activity activity) {
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startTranslaterActivity ");
        activity.startActivity(new Intent(activity, TranslateActivity.class));
    }

    @Override
    public void startGuideActivity(Activity activity) {
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startGuideActivity ");
        activity.startActivity(new Intent(activity, GuideSectionActivity.class));
    }

    @Override
    public void startLearnActivity(Activity activity) {
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startLearnActivity ");
        activity.startActivity(new Intent(activity, LearnActivity.class));

    }

    @Override
    public void startSettingsActivity(Activity activity) {
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startSettingsActivity ");
        activity.startActivity(new Intent(activity, SettingsActivity.class));
    }

    @Override
    public void startAboutActivity(Activity activity) {
        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startAboutActivity ");
        activity.startActivity(new Intent(activity, AboutActivity.class));
    }
}
