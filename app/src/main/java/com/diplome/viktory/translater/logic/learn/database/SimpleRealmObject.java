package com.diplome.viktory.translater.logic.learn.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.diplome.viktory.translater.interactors.KeysInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class SimpleRealmObject extends RealmObject {
    @Required
    private String kyrg_name;
    @Required
    private String rus_name;
    @Required
    private String eng_name;

    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNativeLanguage(Context context) {
        // Получаем из setup preferences данные и по ним определяем нативный и язык какой язык мы учим
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


        String nativeLanguage = sharedPreferences.getString(KeysInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                LanguagesInteractor.KeysField.RUSSIAN);

        switch (nativeLanguage){
            case LanguagesInteractor.KeysField.ENGLISH:
                return getEng_name();
            case LanguagesInteractor.KeysField.KYRGUZS:
                return getKyrg_name();
            case LanguagesInteractor.KeysField.RUSSIAN:
                return getRus_name();
        }

        return getEng_name();
    }

    public String getLearnLanguage(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        // Получаем из setup preferences данные и по ним определяем нативный и язык какой язык мы учим

        String learnLanguage = sharedPreferences.getString(KeysInteractor.KeysField.KEY_LEARN_LANGUAGE,
                LanguagesInteractor.KeysField.ENGLISH);

        switch (learnLanguage){
            case LanguagesInteractor.KeysField.ENGLISH:
                return getEng_name();
            case LanguagesInteractor.KeysField.KYRGUZS:
                return getKyrg_name();
            case LanguagesInteractor.KeysField.RUSSIAN:
                return getRus_name();
        }

        return getEng_name();

    }

    public String getKyrg_name() {
        return kyrg_name;
    }

    public void setKyrg_name(String kyrg_name) {
        this.kyrg_name = kyrg_name;
    }

    public String getRus_name() {
        return rus_name;
    }

    public void setRus_name(String rus_name) {
        this.rus_name = rus_name;
    }

    public String getEng_name() {
        return eng_name;
    }

    public void setEng_name(String eng_name) {
        this.eng_name = eng_name;
    }
}
