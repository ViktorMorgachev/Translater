package com.diplome.viktory.translater.logic.learn.database;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Sport extends RealmObject {
    @Required
    private String kyrg_name;
    @Required
    private String rus_name;
    @Required
    private String eng_name;


    public String getKyrg_name() {
        return kyrg_name;
    }

    public void setKyrg_name(String kyrg_name) {
        this.kyrg_name = kyrg_name;
    }

    public String getRus_name() {
        return rus_name;
    }

    public void setRus_name(String rus_name) {
        this.rus_name = rus_name;
    }

    public String getEng_name() {
        return eng_name;
    }

    public void setEng_name(String eng_name) {
        this.eng_name = eng_name;
    }
}
