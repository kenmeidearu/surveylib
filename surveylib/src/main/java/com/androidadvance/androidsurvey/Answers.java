package com.androidadvance.androidsurvey;


import com.androidadvance.androidsurvey.models.Question;
import com.google.gson.Gson;
import java.util.ArrayList;

//Singleton Answers ........

public class Answers {
    private volatile static Answers uniqueInstance;
    private  final ArrayList<AnswerValue> answerValues=new ArrayList<>();

    private Answers() {
    }

    public void put_answer(String id,String ask,ArrayList<Question.MultipleChoice> answer ) {
        answerValues.add(new AnswerValue(id, ask,answer));
    }


    public String get_json_object() {
        Gson gson = new Gson();
        return gson.toJson(answerValues);
    }

    public ArrayList<AnswerValue>  getValue() {
        return answerValues;
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

    public  class  AnswerValue{
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
