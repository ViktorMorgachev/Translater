package com.diplome.viktory.translater.logic.guide;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.diplome.viktory.translater.R;
import com.diplome.viktory.translater.interactors.KeysCommonInteractor;
import com.diplome.viktory.translater.logic.guide.interactors.LanguagesInteractor;
import com.diplome.viktory.translater.logic.settings.interactors.KeysSettingsInteractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextStorage {

    SharedPreferences mSharedPreferences;
    // Должен хранится список Файлов
    // Должен хнанится список заголовков
    private List<Map<String, String>> mMapListContext = new ArrayList<>();
    private String mLearnLanguage;
    private Context mContext;

    public ContextStorage(Context context) {
        mContext = context;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    private Map<String, String> initKyrguzsOnKyrguzs() {

        Map<String, String> files = new HashMap<>();
        files.put(mContext.getResources().getString(R.string.nouns), "kurguz_nouns_kg");
        return files;
    }

    private Map<String, String> initKyrguzsOnRussian() {


        Map<String, String> files = new HashMap<>();

        files.put(mContext.getResources().getString(R.string.nouns), "kurguz_nouns_rus");
        return files;


    }

    private Map<String, String> initKyrguzsOnEnglish() {

        Map<String, String> files = new HashMap<>();
        files.put(mContext.getResources().getString(R.string.nouns), "kurguz_nouns_en");
        return files;

    }

    private Map<String, String> initRussianOnKyrguzs() {

        Map<String, String> files = new HashMap<>();
        files.put(mContext.getResources().getString(R.string.adjectives), "russian_adjectives_kg");
        files.put(mContext.getResources().getString(R.string.enumeration), "russian_enumeration_kg");
        files.put(mContext.getResources().getString(R.string.nouns), "russian_nouns_kg");
        files.put(mContext.getResources().getString(R.string.pronouns), "russian_pronouns_kg");
        files.put(mContext.getResources().getString(R.string.verbs), "russian_verbs_kg");
        return files;

    }

    private Map<String, String> initRussianOnRussian() {

        Map<String, String> files = new HashMap<>();
        files.put(mContext.getResources().getString(R.string.adjectives), "russian_adjectives_rus");
        files.put(mContext.getResources().getString(R.string.enumeration), "russian_enumeration_rus");
        files.put(mContext.getResources().getString(R.string.nouns), "russian_nouns_rus");
        files.put(mContext.getResources().getString(R.string.pronouns), "russian_pronouns_rus");
        files.put(mContext.getResources().getString(R.string.verbs), "russian_verbs_rus");
        return files;

    }

    private Map<String, String> initRussianOnEnglish() {


        Map<String, String> files = new HashMap<>();
        files.put(mContext.getResources().getString(R.string.adjectives), "russian_adjectives_en");
        files.put(mContext.getResources().getString(R.string.enumeration), "russian_enumeration_en");
        files.put(mContext.getResources().getString(R.string.nouns), "russian_nouns_en");
        files.put(mContext.getResources().getString(R.string.pronouns), "russian_pronouns_en");
        files.put(mContext.getResources().getString(R.string.verbs), "russian_verbs_en");
        return files;
    }

    private Map<String, String> initEnglishOnEnglish() {

        Map<String, String> files = new HashMap<>();

        files.put(mContext.getResources().getString(R.string.adjectives), "english_adjectives_en");
        files.put(mContext.getResources().getString(R.string.nouns), "english_nouns_en");
        files.put(mContext.getResources().getString(R.string.pronouns), "english_pronouns_en");
        files.put(mContext.getResources().getString(R.string.strings), "english_strings_en");
        files.put(mContext.getResources().getString(R.string.verbs_times), "english_verbs_time_en");
        files.put(mContext.getResources().getString(R.string.verbs), "english_verbs_en");
        return files;
    }

    private Map<String, String> initEnglishOnKyrguzs() {

        Map<String, String> files = new HashMap<>();

        files.put(mContext.getResources().getString(R.string.adjectives), "english_adjectives_kg");
        files.put(mContext.getResources().getString(R.string.nouns), "english_noun_kg");
        files.put(mContext.getResources().getString(R.string.pronouns), "english_pronoun_kg");
        files.put(mContext.getResources().getString(R.string.strings), "english_strings_kg");
        files.put(mContext.getResources().getString(R.string.verbs_times), "english_verbs_times_kg");
        files.put(mContext.getResources().getString(R.string.verbs), "english_verbs_kg");
        return files;
    }

    private Map<String, String> initEnglishOnRussian() {

        Map<String, String> files = new HashMap<>();

        files.put(mContext.getResources().getString(R.string.adjectives), "english_adjectives_rus");
        files.put(mContext.getResources().getString(R.string.nouns), "english_nouns_rus");
        files.put(mContext.getResources().getString(R.string.pronouns), "english_pronouns_rus");
        files.put(mContext.getResources().getString(R.string.strings), "english_strings_rus");
        files.put(mContext.getResources().getString(R.string.verbs_times), "english_verbs_time_rus");
        files.put(mContext.getResources().getString(R.string.verbs), "english_verbs_rus");
        return files;
    }


    Map<String, String> getContextList(){

        String nativeLanguage =  mSharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_NATIVE_LANGUAGE,
                LanguagesInteractor.KeysField.RUSSIAN);
        mLearnLanguage = mSharedPreferences.getString(KeysSettingsInteractor.KeysField.KEY_LEARN_LANGUAGE,
                LanguagesInteractor.KeysField.ENGLISH);

        Log.d(KeysCommonInteractor.KeysField.LOG_TAG, getClass().getCanonicalName() + ": getContextList " +
                "\nNative Language: " + nativeLanguage +
                "\nLearn Language: " + mLearnLanguage);

        if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.ENGLISH)) {


            switch (mLearnLanguage) {
                case LanguagesInteractor.KeysField.ENGLISH:
                    return initEnglishOnEnglish();
                case LanguagesInteractor.KeysField.KYRGUZS:
                    return initKyrguzsOnEnglish();
                case LanguagesInteractor.KeysField.RUSSIAN:
                    return  initRussianOnEnglish();
            }
        } else if (nativeLanguage.equalsIgnoreCase(LanguagesInteractor.KeysField.KYRGUZS)) {
            switch (mLearnLanguage) {
                case LanguagesInteractor.KeysField.ENGLISH:
                    return initEnglishOnKyrguzs();
                case LanguagesInteractor.KeysField.KYRGUZS:
                    return initKyrguzsOnKyrguzs();
                case LanguagesInteractor.KeysField.RUSSIAN:
                    return initRussianOnKyrguzs();
            }

        } else {
            switch (mLearnLanguage) {
                case LanguagesInteractor.KeysField.ENGLISH:
                    return initEnglishOnRussian();
                case LanguagesInteractor.KeysField.KYRGUZS:
                    return initKyrguzsOnRussian();
                case LanguagesInteractor.KeysField.RUSSIAN:
                    return initRussianOnRussian();
            }

        }

        throw  new UnsupportedOperationException();
    }

}