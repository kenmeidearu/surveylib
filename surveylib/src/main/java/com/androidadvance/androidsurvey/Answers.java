package com.androidadvance.androidsurvey;


import com.androidadvance.androidsurvey.models.Personal;
import com.androidadvance.androidsurvey.models.Question;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

//Singleton Answers ........

public class Answers implements Serializable {
    private volatile static Answers uniqueInstance;
    private  final ArrayList<AnswerValue> answerValues=new ArrayList<>();
    private final ArrayList<PersonalValue> personalValue = new ArrayList<>();
    private String surveyId;

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

    public void put_answer(String id,String ask,ArrayList<Question.MultipleChoice> answer ) {
        answerValues.add(new AnswerValue(id, ask,answer));
    }

    public void put_answer(String id, ArrayList<Personal> answer) {
        personalValue.add(new PersonalValue(id, answer));
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(new AllValue(surveyId, personalValue, answerValues));
    }

    public AllValue getAnswer() {
        return new AllValue(surveyId, personalValue, answerValues);
    }

    public ArrayList<AnswerValue>  getValue() {
        return answerValues;
    }

    public class AllValue implements Serializable {
        String SurveyId;
        ArrayList<PersonalValue> PersonalInfo;
        ArrayList<AnswerValue> SurveyAnswer;

        public AllValue(String surveyId, ArrayList<PersonalValue> personal, ArrayList<AnswerValue> answer) {
            this.SurveyId = surveyId;
            this.PersonalInfo = personal;
            this.SurveyAnswer = answer;
        }

        public String getSurveyId() {
            return surveyId;
        }

        public void setSurveyId(String surveyId) {
            this.SurveyId = surveyId;
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
        ArrayList<Question.MultipleChoice> Answer;

        public AnswerValue(String idAsk, String ask,ArrayList<Question.MultipleChoice> answer) {
            this.idAsk = idAsk;
            this.Ask = ask;
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

        public ArrayList<Question.MultipleChoice> getAnswer() {
            return Answer;
        }

        public void setAnswer(ArrayList<Question.MultipleChoice> answer) {
            Answer = answer;
        }
    }
}
