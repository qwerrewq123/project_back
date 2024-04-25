package com.example.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="certification")
@Table(name="certification")
public class CertificationEntity {

    @Id
    private String userId;
    private String email;
    private String certificationNumber;
}
