package com.example.hompass_compliance.dto;
import com.example.hompass_compliance.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@AllArgsConstructor
@ToString

public class ChoiceForm {
    private String option;
    private String decide;


    public String getOption() {
        return option;
    }

//    public ChoiceForm(String option, String decide) {
//        this.option = option;
//        this.decide = decide;
//        this.nickname = createRandomNickname();
//    }

//    @Override
//    public String toString() {
//        return "ChoiceForm{" +
//                "nickname='" + nickname + '\'' +
//                ", decide='" + decide + '\'' +
//                ", option='" + option + '\'' +
//                '}';
//    }


}
