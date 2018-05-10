package com.diplome.viktory.translater.interfaces;


import com.diplome.viktory.translater.activities.translater.ResultObject;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Developer on 15.04.2018.
 */

public interface YandexTranslateApi {

    @POST("https://translate.yandex.net/api/v1.5/tr.json/translate")
    Call<ResultObject> getData(@QueryMap Map<String, String> map);

}
