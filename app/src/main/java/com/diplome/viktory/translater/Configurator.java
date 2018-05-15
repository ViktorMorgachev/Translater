package com.diplome.viktory.translater;

import android.app.Application;

public class Configurator {

    public static boolean isIsAutoDeterminate() {
        return isAutoDeterminate;
    }

    public static void setIsAutoDeterminate(boolean isAutoDeterminate) {
        Configurator.isAutoDeterminate = isAutoDeterminate;
    }

    private static boolean isAutoDeterminate;
}
