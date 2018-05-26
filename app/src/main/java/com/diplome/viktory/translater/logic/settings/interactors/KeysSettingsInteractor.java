package com.diplome.viktory.translater.logic.settings.interactors;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 14.04.2018.
 */

public interface KeysSettingsInteractor {

    @StringDef({KeysField.KEY_LEARN_LANGUAGE, KeysField.KEY_NATIVE_LANGUAGE, KeysField.KEY_SHOW_IMAGE})
    @Retention(RetentionPolicy.SOURCE)
    @interface KeysField {
        String KEY_NATIVE_LANGUAGE = "Native Language";
        String KEY_LEARN_LANGUAGE = "Learn Language";
        String KEY_SHOW_IMAGE = "Show image";
    }
}
