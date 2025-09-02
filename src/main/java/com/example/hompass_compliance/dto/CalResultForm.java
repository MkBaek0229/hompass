package com.example.hompass_compliance.dto;

import com.example.hompass_compliance.entity.BaseEntity;
import com.example.hompass_compliance.entity.CalResult;
import com.example.hompass_compliance.entity.Users;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class CalResultForm {
    private Long id;
    private int kcal;
    private int protein;
    private int carb;
    private int fat;
    private LocalDateTime create_at;


    public static CalResultForm createCalResultForm(CalResult calResult) {
        return new CalResultForm(
                calResult.getId(),
                calResult.getKcal(),
                calResult.getCarb(),
                calResult.getProtein(),
                calResult.getFat(),
                calResult.getCreated_at()
        );
    }

    public Long getId() {
        return id;
    }

    public int getKcal() {
        return kcal;
    }

    public int getCarb() {
        return carb;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }


//    public CalResultForm(Long id, int kcal, int protein, int carb, int fat, LocalDateTime create_at) {
//        this.id = id;
//        this.kcal = kcal;
//        this.protein = protein;
//        this.carb = carb;
//        this.fat = fat;
//        this.create_at = create_at;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public int getKcal() {
//        return kcal;
//    }
//
//    public int getProtein() {
//        return protein;
//    }
//
//    public int getFat() {
//        return fat;
//    }
//
//    public int getCarb() {
//        return carb;
//    }
//
//    public LocalDateTime getCreate_at() {
//        return create_at;
//    }
}
