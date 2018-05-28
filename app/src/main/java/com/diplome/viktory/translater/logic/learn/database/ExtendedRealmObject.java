package com.diplome.viktory.translater.logic.learn.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class ExtendedRealmObject extends RealmObject {

    @Required
    private String kyrg_question;
    @Required
    private String rus_question;
    @Required
    private String eng_question;
    @Required
    private String eng_question_wrong1;
    @Required
    private String eng_question_wrong2;
    @Required
    private String eng_question_wrong3;
    @Required
    private String kyrg_question_wrong1;
    @Required
    private String kyrg_answer;
    @Required
    private String rus_answer;
    @Required
    private String eng_answer;
    @Required
    private String kyrg_question_wrong2;
    @Required
    private String kyrg_question_wrong3;
    @Required
    private String rus_question_wrong1;
    @Required
    private String rus_question_wrong2;
    @Required
    private String rus_question_wrong3;


    public String getEng_question_wrong1() {
        return eng_question_wrong1;
    }

    public void setEng_question_wrong1(String eng_question_wrong1) {
        this.eng_question_wrong1 = eng_question_wrong1;
    }

    public String getEng_question_wrong2() {
        return eng_question_wrong2;
    }

    public void setEng_question_wrong2(String eng_question_wrong2) {
        this.eng_question_wrong2 = eng_question_wrong2;
    }

    public String getEng_question_wrong3() {
        return eng_question_wrong3;
    }

    public void setEng_question_wrong3(String eng_question_wrong3) {
        this.eng_question_wrong3 = eng_question_wrong3;
    }

    public List<String> getWrongAnswers(Context context) {
        List<String> stringList = new ArrayList<>();

        // Получаем из setup preferences данные и по ним определяем
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


        String nativeLanguage = sharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                LanguagesInteractor.KeysField.RUSSIAN);

        switch (nativeLanguage) {
            case LanguagesInteractor.KeysField.ENGLISH:
                stringList.addAll(Arrays.asList(getEng_question_wrong1(),
                        getEng_question_wrong2(), getEng_question_wrong3()));
                break;
            case LanguagesInteractor.KeysField.KYRGUZS:
                stringList.addAll(Arrays.asList(getKyrg_question_wrong1(),
                        getKyrg_question_wrong2(), getKyrg_question_wrong3()));
                break;
            case LanguagesInteractor.KeysField.RUSSIAN:
                stringList.addAll(Arrays.asList(getRus_question_wrong1(),
                        getRus_question_wrong2(), getRus_question_wrong3()));
                break;
        }

        return stringList;
    }

    public String getKyrg_question_wrong1() {
        return kyrg_question_wrong1;
    }

    public void setKyrg_question_wrong1(String kyrg_question_wrong1) {
        this.kyrg_question_wrong1 = kyrg_question_wrong1;
    }

    public String getKyrg_question_wrong2() {
        return kyrg_question_wrong2;
    }

    public void setKyrg_question_wrong2(String kyrg_question_wrong2) {
        this.kyrg_question_wrong2 = kyrg_question_wrong2;
    }

    public String getKyrg_question_wrong3() {
        return kyrg_question_wrong3;
    }

    public void setKyrg_question_wrong3(String kyrg_question_wrong3) {
        this.kyrg_question_wrong3 = kyrg_question_wrong3;
    }

    public String getRus_question_wrong1() {
        return rus_question_wrong1;
    }

    public void setRus_question_wrong1(String rus_question_wrong1) {
        this.rus_question_wrong1 = rus_question_wrong1;
    }

    public String getRus_question_wrong2() {
        return rus_question_wrong2;
    }

    public void setRus_question_wrong2(String rus_question_wrong2) {
        this.rus_question_wrong2 = rus_question_wrong2;
    }

    public String getRus_question_wrong3() {
        return rus_question_wrong3;
    }

    public void setRus_question_wrong3(String rus_question_wrong3) {
        this.rus_question_wrong3 = rus_question_wrong3;
    }


    private int imageId;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getKyrg_answer() {
        return kyrg_answer;
    }

    public void setKyrg_answer(String kyrg_answer) {
        this.kyrg_answer = kyrg_answer;
    }

    public String getRus_answer() {
        return rus_answer;
    }

    public void setRus_answer(String rus_answer) {
        this.rus_answer = rus_answer;
    }

    public String getEng_answer() {
        return eng_answer;
    }

    public void setEng_answer(String eng_answer) {
        this.eng_answer = eng_answer;
    }

    public String getKyrg_question() {
        return kyrg_question;
    }

    public String getAnswer(Context context) {
        // Получаем из setup preferences данные и по ним определяем
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);


        String nativeLanguage = sharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                LanguagesInteractor.KeysField.RUSSIAN);

        switch (nativeLanguage) {
            case LanguagesInteractor.KeysField.ENGLISH:
                return getEng_answer();
            case LanguagesInteractor.KeysField.KYRGUZS:
                return getKyrg_answer();
            case LanguagesInteractor.KeysField.RUSSIAN:
                return getRus_answer();
        }

        return getEng_answer();
    }

    public String getQuestion(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        // Получаем из setup preferences данные и по ним определяем нативный и язык какой язык мы учим

        String learnLanguage = sharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_LEARN_LANGUAGE,
                LanguagesInteractor.KeysField.ENGLISH);
        switch (learnLanguage) {
            case LanguagesInteractor.KeysField.ENGLISH:
                return getEng_question();
            case LanguagesInteractor.KeysField.KYRGUZS:
                return getKyrg_question();
            case LanguagesInteractor.KeysField.RUSSIAN:
                return getRus_question();
        }

        return getEng_question();

    }

    public void setKyrg_question(String kyrg_question) {
        this.kyrg_question = kyrg_question;
    }

    public String getRus_question() {
        return rus_question;
    }

    public void setRus_question(String rus_question) {
        this.rus_question = rus_question;
    }

    public String getEng_question() {
        return eng_question;
    }

    public void setEng_question(String eng_question) {
        this.eng_question = eng_question;
    }
}
