package com.diplome.viktory.translater.logic;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.diplome.viktory.translater.activities.TranslateActivity;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.interfaces.OnStartGuideActivityListener;
import com.diplome.viktory.translater.interfaces.OnStartLearnActivityListener;
import com.diplome.viktory.translater.interfaces.OnStartTranslaterActivityListener;

public class ModuleInteractor implements
        OnStartTranslaterActivityListener {

    @Override
    public  void startTranslaterActivity(Activity activity) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : startTranslaterActivity ");
        activity.startActivity(new Intent(activity, TranslateActivity.class));
    }
}
