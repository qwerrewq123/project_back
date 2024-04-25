package com.example.study.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="notification")
@Table(name="notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long notificationId;

    private String content;

    private String createDatetime;

    @ManyToMany
    private Set<UserEntity> users = new HashSet<>();
}
