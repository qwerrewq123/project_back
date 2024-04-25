//package com.example.study.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@Entity(name="event")
//@Table(name="event")
//public class EventEntity {
//
//    @Id @GeneratedValue
//    private Long eventId;
//    @ManyToOne
//    private StudyEntity study;
//    @ManyToOne
//    private UserEntity createdBy;
//
//    private String title;
//    @Lob
//    private String description;
//
//    private String createdDatetime;
//
//    private String endEnrollmentDatetime;
//
//    private String startDatetime;
//
//    private String endDatetime;
//
//    private Integer limitOfEnrollemnts;
//
//
//    @OneToMany(mappedBy = "event")
//    private List<EnrollmentEntity> enrollments = new ArrayList<>();
//
//
//
//}
