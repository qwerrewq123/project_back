package com.example.study.repository;

import com.example.study.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRespository extends JpaRepository<NotificationEntity,Long> {
}
