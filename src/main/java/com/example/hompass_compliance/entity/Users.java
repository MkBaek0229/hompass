package com.example.hompass_compliance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nickname;
    @Column
    private String is_age;

    public Users(Long id, String nickname, String is_age) {
        this.id = id;
        this.nickname = nickname;
        this.is_age = is_age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", is_age=" + is_age +
                '}';
    }
}
