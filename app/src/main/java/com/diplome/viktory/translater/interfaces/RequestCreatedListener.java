package com.diplome.viktory.translater.interfaces;

import com.diplome.viktory.translater.activities.interactors.DirectionInteractor;

import retrofit2.Response;

public interface RequestCreatedListener {

    void onEndedResponseCreated(Response response, @DirectionInteractor.Direction int direction);
}
