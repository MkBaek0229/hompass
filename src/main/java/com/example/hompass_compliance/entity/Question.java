package com.example.hompass_compliance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
public class Question {
     @Id
     @GeneratedValue
     private Long id;
     @Column
     private Integer topic_id;
     @Column
     private String contents;
     @Column
     private String is_adult;

    public Integer getTopic_id() {
        return topic_id;
    }


}
