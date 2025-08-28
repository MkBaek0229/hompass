package com.example.hompass_compliance.dto;

import com.example.hompass_compliance.entity.Users;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class UsersForm {
    private Long id;
    private String nickname;
    private String man_woman;
    private Integer age;
    private Integer cm;
    private Integer kg;
    private String activity_level;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Users toEntity() {
        return new Users(null,nickname,man_woman,age,cm,kg,activity_level);
    }
}
