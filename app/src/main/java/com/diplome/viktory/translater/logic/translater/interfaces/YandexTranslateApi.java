package com.diplome.viktory.translater.logic.translater.interfaces;


import com.diplome.viktory.translater.logic.translater.data.ResultObjectContext;
import com.diplome.viktory.translater.logic.translater.data.ResultObjectLanguage;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Developer on 15.04.2018.
 */

public interface YandexTranslateApi {

    @POST("/api/v1.5/tr.json/translate")
    Call<ResultObjectContext> getData(@QueryMap Map<String, String> map);

    @POST("/api/v1.5/tr.json/detect")
    Call<ResultObjectLanguage> getLanguage(@QueryMap Map<String, String> map);
}
