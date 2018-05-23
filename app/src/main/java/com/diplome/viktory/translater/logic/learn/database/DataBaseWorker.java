package com.diplome.viktory.translater.logic.learn.database;

import android.content.Context;
import android.util.Log;

import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.learn.interfaces.SportInitialize;

import io.realm.Realm;

public class DataBaseWorker implements SportInitialize{

    @Override
    public void SportsImagesInit(Context context) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void /*List<SportObject> */ SportObjectsInit(Context context, Realm realm) {
        realm.beginTransaction();
        SportObject sportObject = realm.createObject(SportObject.class);
        sportObject.setEng_name("fishing");
        sportObject.setKyrg_name("рыбалкага");
        sportObject.setRus_name("рыбалка");
        realm.commitTransaction();

        realm.beginTransaction();
        SportObject sportObject1 = realm.createObject(SportObject.class);
        sportObject1.setEng_name("chess");
        sportObject1.setKyrg_name("шахмат");
        sportObject1.setRus_name("шахматы");
        realm.commitTransaction();


        if(realm.where(SportObject.class).findAll().size() > 0)
            Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : doInBackGroung " + "realm isn't empty");

    }
}
