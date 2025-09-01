package com.example.hompass_compliance.entity;

import com.example.hompass_compliance.dto.UsersForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private float activity_level;

    @Column
    private float meal_goals;




    public static Users createUsers(UsersForm dto) {
        // 예외를 발생시킴.
        if (dto.getId() != null)
            throw new IllegalArgumentException("이미 존재하는 유저입니다.");
        // 엔터티 생성 및 반환
        return new Users(dto.getId(),dto.getNickname(), dto.getMan_woman(), dto.getAge(), dto.getCm(), dto.getKg(), dto.getActivity_level() , dto.getMeal_goals());
    }


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

    public float getActivity_level() {
        return activity_level;
    }

    public float getMeal_goals() {
        return meal_goals;
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
