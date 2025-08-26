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
    private String nickname;


    public String getOption() {
        return option;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Users toEntity() {
        return new Users(null,nickname,decide);
    }
}
