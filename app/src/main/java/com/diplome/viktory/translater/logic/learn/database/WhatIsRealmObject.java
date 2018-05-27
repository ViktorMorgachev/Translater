package com.diplome.viktory.translater.logic.learn.database;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class WhatIsRealmObject extends RealmObject {

    private int ImageID;
    @Required
    private String kyrg_answer;
    @Required
    private String rus_answer;

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
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

    @Required


    private String eng_answer;

}
