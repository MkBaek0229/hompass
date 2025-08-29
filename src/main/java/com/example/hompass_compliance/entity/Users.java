package com.example.hompass_compliance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nickname;
    @Column
    private String man_woman;
    @Column
    private int age;
    @Column
    private int cm;
    @Column
    private int kg;
    @Column
    private String activity_level;

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getMan_woman() {
        return man_woman;
    }

    public int getAge() {
        return age;
    }

    public int getKg() {
        return kg;
    }

    public int getCm() {
        return cm;
    }

    public String getActivity_level() {
        return activity_level;
    }
//    public Users(Long id, String nickname, String man_woman, int age, int cm, int kg, String activity_level) {
//        this.id = id;
//        this.nickname = nickname;
//        this.man_woman = man_woman;
//        this.age = age;
//        this.cm = cm;
//        this.kg = kg;
//        this.activity_level = activity_level;
//    }
}
