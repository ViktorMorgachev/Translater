package com.diplome.viktory.translater.logic.translater;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultObjectLanguage {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("lang")
    @Expose
    private String lang;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResultObjectLanguage() {
    }

    /**
     *
     * @param code
     * @param lang
     */
    public ResultObjectLanguage(int code, String lang) {
        super();
        this.code = code;
        this.lang = lang;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "ResultObjectLanguage{" +
                "code=" + code +
                ", lang='" + lang + '\'' +
                '}';
    }
}