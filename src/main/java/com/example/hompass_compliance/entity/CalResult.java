package com.example.hompass_compliance.entity;

import com.example.hompass_compliance.dto.CalResultForm;
import com.example.hompass_compliance.dto.UsersForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;


@NoArgsConstructor
@AllArgsConstructor
@Entity

public class CalResult {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int kcal;
    @Column
    private int protein;
    @Column
    private int carb;
    @Column
    private int fat;

    @OneToOne
    @JoinColumn(name="users_id")
    private Users users;

    public static CalResult createResult(CalResultForm dto) {
        // 예외를 발생시킴.
        if (dto.getId() != null)
            throw new IllegalArgumentException("이미 존재하는 결과입니다.");
        // 엔터티 생성 및 반환
        return CalResult(dto.getId(), dto.getKcal(), dto.getCarb(), dto.getProtein(), dto.getFat());

    }



    public Long getId() {
        return id;
    }

    public int getKcal() {
        return kcal;
    }

    public int getProtein() {
        return protein;
    }

    public int getCarb() {
        return carb;
    }

    public int getFat() {
        return fat;
    }


}
