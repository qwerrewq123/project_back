package com.example.study.repository;


import com.example.study.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<CertificationEntity,String> {
    CertificationEntity findByUserId(String id);

    void deleteByUserId(String userid);
}
