package com.diplome.viktory.translater.logic.translater;

import android.app.Application;
import android.content.Context;

import com.diplome.viktory.translater.interfaces.YandexTranslateApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Developer on 15.04.2018.
 */

// Отнаследуем его от Application чтобы он был единственный в приложении
public class Translater extends Application {

    private static YandexTranslateApi yandexTranslateApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        okHttpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://translate.yandex.net")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient.build())
                .build();

        yandexTranslateApi = retrofit.create(YandexTranslateApi.class);



    }

    public static YandexTranslateApi getApi() {
        return yandexTranslateApi;

    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }

  /*  public String getOfflineAvailableLanguage(){
        try {
            String jsonText = readText(context, R.raw.yandex_languages);
            JSONObject jsonObject = new JSONObject(jsonText);

            return jsonObject.toString();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }*/
}
