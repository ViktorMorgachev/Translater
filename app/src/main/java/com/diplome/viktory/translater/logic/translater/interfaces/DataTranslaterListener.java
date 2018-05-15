package com.diplome.viktory.translater.logic.translater.interfaces;

import com.diplome.viktory.translater.logic.translater.ResultObjectContext;

import retrofit2.Response;

public interface DataTranslaterListener {

    void onStopedDataTranslater(Response<ResultObjectContext> response);

}
