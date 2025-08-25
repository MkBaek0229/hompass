package com.example.hompass_compliance.dto;

public class ChoiceForm {
    private String option;
    private String decide;

    public String getOption() {
        return option;
    }

    public ChoiceForm(String option, String decide) {
        this.option = option;
        this.decide = decide;
    }

    @Override
    public String toString() {
        return "ChoiceForm{" +
                "option='" + option + '\'' +
                ", decide='" + decide + '\'' +
                '}';
    }
}
