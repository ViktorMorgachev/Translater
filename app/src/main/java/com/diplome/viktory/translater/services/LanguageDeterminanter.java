package com.diplome.viktory.translater.services;

import android.os.AsyncTask;
import android.util.Log;

import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.translater.Translater;
import com.diplome.viktory.translater.interfaces.LanguageDeterminaterListener;

import java.io.IOException;
import java.util.Map;

public class LanguageDeterminanter extends AsyncTask<Map<String, String>, Void, String> {

    private RequestCreater mRequestCreater;
    private LanguageDeterminaterListener mLanguageDeterminaterListener;

    public LanguageDeterminanter(RequestCreater requestCreater) {
        mRequestCreater = requestCreater;
    }

    // Связали обьект к интерефейсом
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if( mRequestCreater instanceof  LanguageDeterminaterListener)
            mLanguageDeterminaterListener = mRequestCreater;
    }



    // Отправили ответ в метод класса
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onPostExecute");
        mLanguageDeterminaterListener.onStopedLanguageDaterminater(result);

    }

    @Override
    protected String doInBackground(Map<String, String>... maps) {
        try {
            return Translater.getApi().getLanguage(maps[0]).execute().body().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
