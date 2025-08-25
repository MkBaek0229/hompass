package com.example.hompass_compliance.dto;

public class ChoiceForm {
    private String option;

    public String getOption() {
        return option;
    }

    public ChoiceForm(String option) {
        this.option = option;
    }

    @Override
    public String toString() {
        return "ChoiceForm{" +
                "option='" + option + '\'' +
                '}';
    }


}
