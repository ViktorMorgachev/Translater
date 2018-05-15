package com.diplome.viktory.translater.services;

import android.os.AsyncTask;
import android.util.Log;

import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.translater.ResultObjectContext;
import com.diplome.viktory.translater.logic.translater.Translater;
import com.diplome.viktory.translater.logic.translater.interfaces.DataTranslaterListener;

import java.io.IOException;
import java.util.Map;

import retrofit2.Response;

public class DataTranslater extends AsyncTask<Map<String, String>, Void, Response<ResultObjectContext> > {

    private RequestCreater mRequestCreater;
    private DataTranslaterListener mDataTranslaterListener;

    public DataTranslater(RequestCreater requestCreater) {
        mRequestCreater = requestCreater;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if( mRequestCreater instanceof  DataTranslaterListener)
            mDataTranslaterListener = mRequestCreater;
    }

    @Override
    protected Response doInBackground(Map<String, String>... maps) {
        try {
            return Translater.getApi().getData(maps[0]).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    protected void onPostExecute(Response response) {
        super.onPostExecute(response);
        Log.d(KeysInteractor.KeysField.LOG_TAG,
                getClass().getCanonicalName() + " : Response  = "  +  response.body().toString());
        mDataTranslaterListener.onStopedDataTranslater(response);
    }
}
