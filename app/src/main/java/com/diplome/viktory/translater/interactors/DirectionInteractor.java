package com.diplome.viktory.translater.interactors;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Developer on 14.04.2018.
 */

public interface DirectionInteractor {

    @IntDef({Direction.LEFT, Direction.RIGHT})
    @Retention(RetentionPolicy.SOURCE)
    @interface Direction {
        int LEFT = 0;
        int RIGHT = 1;
    }
}
