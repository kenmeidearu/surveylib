package com.androidadvance.androidsurvey.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kenjinsan on 9/18/17.
 */

public class SurveyPersonal implements Serializable {

    @SerializedName("value")
    @Expose
    private ArrayList<Personal> personal;
    @SerializedName("RecId")
    @Expose
    private String personalId;
    @SerializedName("skip_personal")
    @Expose
    private Boolean skipPersonal;

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public ArrayList<Personal> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Personal> personal) {
        this.personal = personal;
    }

    public Boolean getSkipPersonal() {
        return skipPersonal;
    }

    public void setSkipPersonal(Boolean skipPersonal) {
        this.skipPersonal = skipPersonal;
    }
}
