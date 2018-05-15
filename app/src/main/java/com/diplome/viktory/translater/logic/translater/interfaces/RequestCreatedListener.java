package com.diplome.viktory.translater.logic.translater.interfaces;

import com.diplome.viktory.translater.interactors.DirectionInteractor;
import com.diplome.viktory.translater.logic.translater.ResultObjectContext;

import retrofit2.Response;

public interface RequestCreatedListener {

    void onEndedResponseCreated(Response<ResultObjectContext> response, @DirectionInteractor.Direction int direction);
}