package com.diplome.viktory.translater.logic.learn.database;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class SimpleRealmObject extends RealmObject {
    @Required
    private String kyrg_name;
    @Required
    private String rus_name;
    @Required
    private String eng_name;

    private int image;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNativeLanguage() {
        // Получаем из setup preferences данные и по ним определяем нативный и язык какой язык мы учим
        return getRus_name();
    }

    public String getLearnLanguage() {
        // Получаем из setup preferences данные и по ним определяем нативный и язык какой язык мы учим
        return getEng_name();
    }

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
