package com.androidadvance.androidsurvey.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Question implements Serializable {

    @SerializedName("question_type")
    @Expose
    private String questionType;
    @SerializedName("question_id")
    @Expose
    private String questionId;
    @SerializedName("question_title")
    @Expose
    private String questionTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("required")
    @Expose
    private Boolean required;
    @SerializedName("random_choices")
    @Expose
    private Boolean randomChoices;
    @SerializedName("choices")
    @Expose
   // private List<String> choices = new ArrayList<String>();//change to array  string and int
    private List<MultipleChoice> choices=new ArrayList<>();
    @SerializedName("min")
    @Expose
    private Integer min;
    @SerializedName("max")
    @Expose
    private Integer max;
    @SerializedName("number_of_lines")
    @Expose
    private Integer numberOfLines;


    public static class MultipleChoice{
        String idChoice;
        String valueChoice;
        boolean selected;

        public MultipleChoice(String idChoice, String valueChoice) {
            this.idChoice = idChoice;
            this.valueChoice = valueChoice;
        }

        public MultipleChoice(String idChoice, String valueChoice, boolean selected) {
            this.idChoice = idChoice;
            this.valueChoice = valueChoice;
            this.selected = selected;
        }

        public String getIdChoice() {
            return idChoice;
        }

        public void setIdChoice(String idChoice) {
            this.idChoice = idChoice;
        }

        public String getValueChoice() {
            return valueChoice;
        }

        public void setValueChoice(String valueChoice) {
            this.valueChoice = valueChoice;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }

    /**
     *
     * @return
     * The questionType
     */
    public String getQuestionType() {
        return questionType;
    }

    /**
     *
     * @param questionType
     * The question_type
     */
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    /**
     *
     * @return
     * The questionTitle
     */
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     *
     * @param questionTitle
     * The question_title
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The required
     */
    public Boolean getRequired() {
        return required;
    }

    /**
     *
     * @param required
     * The required
     */
    public void setRequired(Boolean required) {
        this.required = required;
    }

    /**
     *
     * @return
     * The randomChoices
     */
    public Boolean getRandomChoices() {
        return randomChoices;
    }

    /**
     *
     * @param randomChoices
     * The random_choices
     */
    public void setRandomChoices(Boolean randomChoices) {
        this.randomChoices = randomChoices;
    }

    /**
     *
     * @return
     * The choices
     */
    /*public List<String> getChoices() {
        return choices;
    }*/
    public List<MultipleChoice> getChoices() {
        return choices;
    }

    /**
     *
     * @param choices
     * The choices
     */
   /* public void setChoices(List<String> choices) {
        this.choices = choices;
    }*/
    public void setChoices(List<MultipleChoice> choices) {
        this.choices = choices;
    }

    /**
     *
     * @return
     * The min
     */
    public Integer getMin() {
        return min;
    }

    /**
     *
     * @param min
     * The min
     */
    public void setMin(Integer min) {
        this.min = min;
    }

    /**
     *
     * @return
     * The max
     */
    public Integer getMax() {
        return max;
    }

    /**
     *
     * @param max
     * The max
     */
    public void setMax(Integer max) {
        this.max = max;
    }

    /**
     *
     * @return
     * The numberOfLines
     */
    public Integer getNumberOfLines() {
        return numberOfLines;
    }

    /**
     *
     * @param numberOfLines
     * The number_of_lines
     */
    public void setNumberOfLines(Integer numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    /**
     *
     * @return
     * The Id Question
     */
    public String getQuestionId() {
        return questionId;
    }

    /**
     *
     * @param questionId
     * The Id Question
     */
    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

}