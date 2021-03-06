package com.androidadvance.androidsurvey;


import com.androidadvance.androidsurvey.models.Personal;
import com.androidadvance.androidsurvey.models.Question;
import com.google.gson.Gson;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

//Singleton Answers ........

public class Answers implements Serializable {
    private volatile static Answers uniqueInstance;
    private  final ArrayList<AnswerValue> answerValues=new ArrayList<>();
    private final ArrayList<PersonalValue> personalValue = new ArrayList<>();
    private String surveyId;
    private String AnswerId;

    private Answers() {
    }

    public static Answers getInstance() {
        if (uniqueInstance == null) {
            synchronized (Answers.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Answers();
                }
            }
        }
        return uniqueInstance;
    }

    public void put_answer(String id, String ask, String typeAsk, ArrayList<Question.MultipleChoice> answer) {
        answerValues.add(new AnswerValue(id, ask, typeAsk, answer));
    }

    public void put_answer(String id, ArrayList<Personal> answer) {
        personalValue.add(new PersonalValue(id, answer));
    }

    public String getAnswerId() {
        return AnswerId;
    }

    public void setAnswerId(String creatorId) {
        Calendar calss = Calendar.getInstance();
        SimpleDateFormat smp2 = new SimpleDateFormat("yyMMddhhmmss");
        AnswerId = String.valueOf(creatorId).concat(String.valueOf(smp2.format(calss.getTime())));
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(new AllValue(AnswerId, surveyId, personalValue, answerValues));
    }

    public AllValue getAnswer() {
        return new AllValue(AnswerId, surveyId, personalValue, answerValues);
    }

    public ArrayList<AnswerValue>  getValue() {
        return answerValues;
    }

    public class AllValue implements Serializable {
        String AnswerId;
        String SurveyId;
        ArrayList<PersonalValue> PersonalInfo;
        ArrayList<AnswerValue> SurveyAnswer;
        boolean StatusSend;

        public AllValue(String answerId, String surveyId, ArrayList<PersonalValue> personal, ArrayList<AnswerValue> answer) {
            this.AnswerId = answerId;
            this.SurveyId = surveyId;
            this.PersonalInfo = personal;
            this.SurveyAnswer = answer;
        }

        public String getAnswerId() {
            return AnswerId;
        }

        public void setAnswerId(String answerId) {
            AnswerId = answerId;
        }

        public ArrayList<PersonalValue> getPersonalInfo() {
            return PersonalInfo;
        }

        public void setPersonalInfo(ArrayList<PersonalValue> personalInfo) {
            PersonalInfo = personalInfo;
        }

        public ArrayList<AnswerValue> getSurveyAnswer() {
            return SurveyAnswer;
        }

        public void setSurveyAnswer(ArrayList<AnswerValue> surveyAnswer) {
            SurveyAnswer = surveyAnswer;
        }

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.SurveyId = surveyId;
        }

        public boolean isStatusSend() {
            return StatusSend;
        }

        public void setStatusSend(boolean statusSend) {
            StatusSend = statusSend;
        }

        public ArrayList<PersonalValue> getPersonal() {
            return PersonalInfo;
        }

        public void setPersonal(ArrayList<PersonalValue> personal) {
            this.PersonalInfo = personal;
        }

        public ArrayList<AnswerValue> getAnswer() {
            return SurveyAnswer;
        }

        public void setAnswer(ArrayList<AnswerValue> answer) {
            this.SurveyAnswer = answer;
        }
    }

    public class PersonalValue implements Serializable {
        String idAsk;
        ArrayList<Personal> value;

        public PersonalValue(String idAsk, ArrayList<Personal> value) {
            this.idAsk = idAsk;
            this.value = value;
        }

        public String getIdAsk() {
            return idAsk;
        }

        public void setIdAsk(String idAsk) {
            this.idAsk = idAsk;
        }


        public ArrayList<Personal> getValue() {
            return value;
        }

        public void setValue(ArrayList<Personal> value) {
            this.value = value;
        }
    }

    public class AnswerValue implements Serializable {
        String idAsk;
        String Ask;
        String TypeAsk;
        ArrayList<Question.MultipleChoice> Answer;


        public AnswerValue(String idAsk, String ask, String typeAsk, ArrayList<Question.MultipleChoice> answer) {
            this.idAsk = idAsk;
            this.Ask = ask;
            this.TypeAsk = typeAsk;
            this.Answer = answer;
        }

        public String getIdAsk() {
            return idAsk;
        }

        public void setIdAsk(String idAsk) {
            this.idAsk = idAsk;
        }

        public String getAsk() {
            return Ask;
        }

        public void setAsk(String ask) {
            this.Ask = ask;
        }

        public String getTypeAsk() {
            return TypeAsk;
        }

        public void setTypeAsk(String typeAsk) {
            TypeAsk = typeAsk;
        }

        public ArrayList<Question.MultipleChoice> getAnswer() {
            return Answer;
        }

        public void setAnswer(ArrayList<Question.MultipleChoice> answer) {
            Answer = answer;
        }

    }
}
