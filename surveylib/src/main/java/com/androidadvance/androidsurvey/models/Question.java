package com.androidadvance.androidsurvey.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Question implements Serializable {

    @SerializedName("QuestionType")
    @Expose
    private String questionType;
    @SerializedName("QuestionId")
    @Expose
    private String questionId;
    @SerializedName("QuestionTitle")
    @Expose
    private String questionTitle;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("Required")
    @Expose
    private Boolean required;
    @SerializedName("RandomChoices")
    @Expose
    private Boolean randomChoices;
    @SerializedName("Personal")
    @Expose
   // private List<String> choices = new ArrayList<String>();//change to array  string and int
    private transient List<Personal> personal = new ArrayList<>();
    @SerializedName("Choices")
    @Expose
    private List<MultipleChoice> choices=new ArrayList<>();
    @SerializedName("Min")
    @Expose
    private Integer min;
    @SerializedName("Max")
    @Expose
    private Integer max;
    @SerializedName("NumberOfLines")
    @Expose
    private Integer numberOfLines;

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

    public static class MultipleChoice implements Serializable {
        String IdChoice;
        String ValueChoice;
        boolean Selected;

        public MultipleChoice(String idChoice, String valueChoice) {
            this.IdChoice = idChoice;
            this.ValueChoice = valueChoice;
        }

        public MultipleChoice(String idChoice, String valueChoice, boolean selected) {
            this.IdChoice = idChoice;
            this.ValueChoice = valueChoice;
            this.Selected = selected;
        }

        public String getIdChoice() {
            return IdChoice;
        }

        public void setIdChoice(String idChoice) {
            this.IdChoice = idChoice;
        }

        public String getValueChoice() {
            return ValueChoice;
        }

        public void setValueChoice(String valueChoice) {
            this.ValueChoice = valueChoice;
        }

        public boolean isSelected() {
            return Selected;
        }

        public void setSelected(boolean selected) {
            this.Selected = selected;
        }
    }

}