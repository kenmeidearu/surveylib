package com.androidadvance.androidsurvey.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kenjinsan on 9/18/17.
 */

public class Personal implements Serializable {
    @SerializedName("PersonalId")
    @Expose
    private int PersonalId;
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Required")
    @Expose
    private Boolean required;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Value")
    @Expose
    private String value;

    public Personal(int personalId, String title, String value) {
        this.PersonalId = personalId;
        this.title = title;
        this.value = value;
    }

    public int getPersonalId() {
        return PersonalId;
    }

    public void setPersonalId(int personalId) {
        PersonalId = personalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
