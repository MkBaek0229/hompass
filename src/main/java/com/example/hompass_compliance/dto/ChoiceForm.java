package com.example.hompass_compliance.dto;
import com.example.hompass_compliance.entity.Users;

import java.util.Random;

public class ChoiceForm {
    private String option;
    private String decide;
    private String nickname;
    private String[] random_nickname = {"돌고래", "개발자", "오랑우탄"};


    public String createRandomNickname() {
        Random random = new Random();
        String nickname = this.random_nickname[random.nextInt(this.random_nickname.length)];
        return nickname;
    }

    public String getOption() {
        return option;
    }

    public ChoiceForm(String option, String decide) {
        this.option = option;
        this.decide = decide;
        this.nickname = createRandomNickname();
        System.out.println(this.nickname);
    }

    @Override
    public String toString() {
        return "ChoiceForm{" +
                "nickname='" + nickname + '\'' +
                ", decide='" + decide + '\'' +
                ", option='" + option + '\'' +
                '}';
    }

    public Users toEntity() {
        return new Users(null,nickname,decide);
    }
}
