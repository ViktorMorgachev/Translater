package com.diplome.viktory.translater.logic;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.diplome.viktory.translater.logic.guide.SelectLanguageActivity;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartGuideActivityListener;
import com.diplome.viktory.translater.logic.translater.activities.TranslateActivity;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.menu.interfaces.OnStartTranslaterActivityListener;

public class ModuleInteractor implements
        OnStartTranslaterActivityListener, OnStartGuideActivityListener {

    @Override
    public  void startTranslaterActivity(Activity activity) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startTranslaterActivity ");
        activity.startActivity(new Intent(activity, TranslateActivity.class));
    }

    @Override
    public void startGuideActivity(Activity activity) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startGuideActivity ");
        activity.startActivity(new Intent(activity, SelectLanguageActivity.class));
    }
}
