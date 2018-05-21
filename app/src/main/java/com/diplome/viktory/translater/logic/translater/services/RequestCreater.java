package com.diplome.viktory.translater.logic.translater.services;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.diplome.viktory.translater.interactors.DirectionInteractor;
import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.translater.interfaces.DataTranslaterListener;
import com.diplome.viktory.translater.logic.translater.interfaces.LanguageDeterminaterListener;
import com.diplome.viktory.translater.logic.translater.interfaces.OnRequestCreatedListener;
import com.diplome.viktory.translater.logic.translater.data.ResultObjectContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Response;

public class RequestCreater extends Service implements LanguageDeterminaterListener, DataTranslaterListener {


    private OnRequestCreatedListener mCallBack;
    private Map<String, String> mRequestMap;
    private boolean isDeterminate;
    private String lang1, lang2;
    private String text;
    private @DirectionInteractor.Direction int direction;
    public Map<Integer, String> mLanguageMap;
    private final Binder mBinder = new LocalBinder();

    public Map<Integer, String> getLanguageMap() throws NullPointerException {
        if (this.mLanguageMap != null)
            return this.mLanguageMap;
        else throw new UnsupportedOperationException();
    }

    public void setFragmentListener(Fragment fragment) { ;
        try {
            mCallBack = (OnRequestCreatedListener) fragment;
        } catch (ClassCastException e){
            throw new ClassCastException(fragment.toString()
                    + " must implement OnRequestCreatedListener");
        }
    }


    public class LocalBinder extends Binder {

        public RequestCreater getService() {
            return RequestCreater.this;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();

        mLanguageMap = new HashMap<>();
        mLanguageMap.put(0, "ky");
        mLanguageMap.put(1, "ru");
        mLanguageMap.put(2, "en");
        mLanguageMap.put(3, "fr");
        mLanguageMap.put(4, "it");
        mLanguageMap.put(5, "es");
        mLanguageMap.put(6, "de");
        mLanguageMap.put(7, "ko");


        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onCreate");


        mRequestMap = new HashMap<>();

        mRequestMap.put("key", KeysInteractor.KeysField.API_KEY_YANDEX_TRANSLATER);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onBind");
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onTaskRemoved");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onDestroy");
    }

    public void getTranslatedText(String lang1) {
        // тут делаем запрос и отправляем всё в активность
        mRequestMap.put("langs", lang1 + "-" + this.lang2);
        mRequestMap.remove("text");
        try {
            mRequestMap.put("text", URLEncoder.encode(this.text, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        new DataTranslater(this).execute(mRequestMap);

    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : unbindService");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onRebind");
    }

    public void getTranslatedText(Map<String, String> requestMap) {
        // тут делаем запрос и отправляем всё в активность
        new DataTranslater(this).execute(mRequestMap);
    }


    public void makeResponse(Boolean isDeterminate, String text, String lang1, String lang2, @DirectionInteractor.Direction int direction) {

        this.text = text;
        this.direction = direction;


        mRequestMap.put("text", this.text);

        if (isDeterminate) {
            mRequestMap.put("hint", "ky,de,ru,en");
            new LanguageDeterminanter(this).execute(mRequestMap);
        } else {
            mRequestMap.remove("hint");
            mRequestMap.put("lang", lang1 + "-" + lang2);

            Log.d(KeysInteractor.KeysField.LOG_TAG, mRequestMap.toString());
            getTranslatedText(mRequestMap);
        }

    }


    @Override
    public void onStopedLanguageDaterminater(String lang1) {

        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onStopedLanguageDaterminater ");
        getTranslatedText(lang1);
    }


    @Override
    public void onStopedDataTranslater(Response<ResultObjectContext> response) {
        Log.d(KeysInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + " : onStopedDataTranslater ");
        if (mCallBack != null)
            mCallBack.onEndedResponseCreated(response, direction);

    }
}
