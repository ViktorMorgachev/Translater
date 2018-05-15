package com.diplome.viktory.translater.logic;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;

import com.diplome.viktory.translater.activities.TranslateActivity;
import com.diplome.viktory.translater.interfaces.OnStartGuideActivityListener;
import com.diplome.viktory.translater.interfaces.OnStartLearnActivityListener;
import com.diplome.viktory.translater.interfaces.OnStartTranslaterActivityListener;

public class ModuleInteractor implements OnStartGuideActivityListener,
        OnStartTranslaterActivityListener, OnStartLearnActivityListener {


    @Override
    public void startGuideActivity(Activity activity) {

    }

    @Override
    public void startLearnActivity(Activity activity) {

    }

    @Override
    public void startTranslaterActivity(Activity activity) {

        activity.startActivity(new Intent(activity, TranslateActivity.class));
    }
}
