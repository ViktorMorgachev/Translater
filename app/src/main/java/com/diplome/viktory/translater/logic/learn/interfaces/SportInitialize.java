package com.diplome.viktory.translater.logic.learn.interfaces;

import android.content.Context;

import io.realm.Realm;

public interface SportInitialize {

    public void SportsImagesInit(Context context);

    public void /*List<SportObject> */ SportObjectsInit(Context context, Realm realm);
}
