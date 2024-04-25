package com.example.study.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="study")
@Table(name="study")
@ToString
public class StudyEntity {

    @Id @GeneratedValue
    private Long studyId;

    @ManyToOne

    private UserEntity manager;

    @ManyToMany
    private Set<UserEntity> members = new HashSet<>();

    private String title;

    private String shortDescription;

    @Lob @Basic(fetch = FetchType.EAGER)
    private String fullDescription;



    private String publishedDatetime;

    private boolean published;

    private boolean closed;


}
