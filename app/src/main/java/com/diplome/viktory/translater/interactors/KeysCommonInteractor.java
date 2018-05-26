package com.diplome.viktory.translater.interactors;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 14.04.2018.
 */

public interface KeysCommonInteractor {

    @StringDef({KeysField.API_KEY_YANDEX_TRANSLATER, KeysField.LOG_TAG})
    @Retention(RetentionPolicy.SOURCE)
    @interface KeysField {
        String API_KEY_YANDEX_TRANSLATER = "trnsl.1.1.20180415T024909Z.9c00f09b3bdd4ce8.3df4220cf32ad0a7184cb90b59e82b1cc4fde4e3";
        String LOG_TAG = "TRANSLATER_LOG";
    }
}
