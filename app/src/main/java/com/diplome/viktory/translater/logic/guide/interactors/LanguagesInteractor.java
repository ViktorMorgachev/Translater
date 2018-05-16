package com.diplome.viktory.translater.logic.guide.interactors;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface LanguagesInteractor {
    @StringDef({KeysField.ENGLISH, KeysField.KYRGUZS, KeysField.RUSSIAN})
    @Retention(RetentionPolicy.SOURCE)
    @interface KeysField {
        String RUSSIAN = "Русский";
        String ENGLISH = "Английский";
        String KYRGUZS = "Кыргызский";
        String EXTRA_KEY = "EXTRA_LANGUAGE_KEY";
    }
}
