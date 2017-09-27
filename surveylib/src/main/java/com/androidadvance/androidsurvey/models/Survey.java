package com.androidadvance.androidsurvey.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by kenjinsan on 9/27/17.
 */

public class Survey implements Serializable {
    int SurveyId;
    String SurveyName;
    String SurveyDesc;
    String SurveyType;
    int SurveyTypeRef;
    String SurveyTypeRefDesc;
    boolean UsePeriode;
    String PeriodeStart;
    String PeriodeEnd;
    boolean Status;
    SurveyProperties SurveyProperties;
    SurveyPersonal PersonalInformation;
    ArrayList<Question> Questions;

    public Survey(int surveyId, String surveyName, String surveyDesc, String surveyType, int surveyTypeRef, String surveyTypeRefDesc, boolean usePeriode, String periodeStart, String periodeEnd, boolean status, com.androidadvance.androidsurvey.models.SurveyProperties surveyProperties, SurveyPersonal personalInformation, ArrayList<Question> questions) {
        SurveyId = surveyId;
        SurveyName = surveyName;
        SurveyDesc = surveyDesc;
        SurveyType = surveyType;
        SurveyTypeRef = surveyTypeRef;
        SurveyTypeRefDesc = surveyTypeRefDesc;
        UsePeriode = usePeriode;
        PeriodeStart = periodeStart;
        PeriodeEnd = periodeEnd;
        Status = status;
        SurveyProperties = surveyProperties;
        PersonalInformation = personalInformation;
        Questions = questions;
    }

    public int getSurveyId() {
        return SurveyId;
    }

    public void setSurveyId(int surveyId) {
        SurveyId = surveyId;
    }

    public String getSurveyName() {
        return SurveyName;
    }

    public void setSurveyName(String surveyName) {
        SurveyName = surveyName;
    }

    public String getSurveyDesc() {
        return SurveyDesc;
    }

    public void setSurveyDesc(String surveyDesc) {
        SurveyDesc = surveyDesc;
    }

    public String getSurveyType() {
        return SurveyType;
    }

    public void setSurveyType(String surveyType) {
        SurveyType = surveyType;
    }

    public int getSurveyTypeRef() {
        return SurveyTypeRef;
    }

    public void setSurveyTypeRef(int surveyTypeRef) {
        SurveyTypeRef = surveyTypeRef;
    }

    public String getSurveyTypeRefDesc() {
        return SurveyTypeRefDesc;
    }

    public void setSurveyTypeRefDesc(String surveyTypeRefDesc) {
        SurveyTypeRefDesc = surveyTypeRefDesc;
    }

    public boolean isUsePeriode() {
        return UsePeriode;
    }

    public void setUsePeriode(boolean usePeriode) {
        UsePeriode = usePeriode;
    }

    public String getPeriodeStart() {
        return PeriodeStart;
    }

    public void setPeriodeStart(String periodeStart) {
        PeriodeStart = periodeStart;
    }

    public String getPeriodeEnd() {
        return PeriodeEnd;
    }

    public void setPeriodeEnd(String periodeEnd) {
        PeriodeEnd = periodeEnd;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public com.androidadvance.androidsurvey.models.SurveyProperties getSurveyProperties() {
        return SurveyProperties;
    }

    public void setSurveyProperties(com.androidadvance.androidsurvey.models.SurveyProperties surveyProperties) {
        SurveyProperties = surveyProperties;
    }

    public SurveyPersonal getPersonalInformation() {
        return PersonalInformation;
    }

    public void setPersonalInformation(SurveyPersonal personalInformation) {
        PersonalInformation = personalInformation;
    }

    public ArrayList<Question> getQuestions() {
        return Questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        Questions = questions;
    }
}
