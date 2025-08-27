package com.example.hompass_compliance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@ToString
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
}
