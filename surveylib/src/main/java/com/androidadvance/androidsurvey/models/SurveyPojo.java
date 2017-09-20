package com.androidadvance.androidsurvey.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SurveyPojo implements Serializable {

    @SerializedName("SurveyProperties")
    @Expose
    private SurveyProperties surveyProperties;
    @SerializedName("PersonalInformation")
    @Expose
    private SurveyPersonal surveyPersonal;
    @SerializedName("Questions")
    @Expose
    private List<Question> questions = new ArrayList<Question>();

    /**
     *
     * @return
     * The surveyProperties
     */
    public SurveyProperties getSurveyProperties() {
        return surveyProperties;
    }

    /**
     *
     * @param surveyProperties
     * The survey_properties
     */
    public void setSurveyProperties(SurveyProperties surveyProperties) {
        this.surveyProperties = surveyProperties;
    }

    public SurveyPersonal getSurveyPersonal() {
        return surveyPersonal;
    }

    public void setSurveyPersonal(SurveyPersonal surveyPersonal) {
        this.surveyPersonal = surveyPersonal;
    }

    /**
     *
     * @return
     * The questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     *
     * @param questions
     * The questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}