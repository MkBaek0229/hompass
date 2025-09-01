package com.example.hompass_compliance.dto;

import com.example.hompass_compliance.entity.Users;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CalResultForm {
    private Long id;
    private int kcal;
    private int protein;
    private int carb;
    private int fat;


//    public CalResultForm(Long id, int kcal, int protein, int carb, int fat) {
//        this.id = id;
//        this.kcal = kcal;
//        this.protein = protein;
//        this.carb = carb;
//        this.fat = fat;
//    }

    public Long getId() {
        return id;
    }

    public int getKcal() {
        return kcal;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarb() {
        return carb;
    }
}
