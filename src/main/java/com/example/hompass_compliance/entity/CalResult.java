package com.example.hompass_compliance.entity;

import com.example.hompass_compliance.dto.CalResultForm;
import com.example.hompass_compliance.dto.UsersForm;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;


@NoArgsConstructor
@Entity
public class CalResult extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int kcal;
    @Column
    private int protein;
    @Column
    private int carb;
    @Column
    private int fat;


    @ManyToOne
    @JoinColumn(name="users_id", nullable = false)
    private Users users;


    public CalResult(Long id, int kcal, int protein, int carb, int fat, Users users) {
        this.id = id;
        this.kcal = kcal;
        this.protein = protein;
        this.carb = carb;
        this.fat = fat;
        this.users = users;
    }

    public static CalResult createResult(int kcal, int protein, int carb, int fat, Users user) {
        return new CalResult(null, kcal, protein, carb, fat, user); // @AllArgsConstructor 사용 시 필드 순서에 맞게
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


    public Users getUsers() {
        return users;
    }
}
