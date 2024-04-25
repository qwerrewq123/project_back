package com.example.study.repository;

import com.example.study.entity.StudyEntity;
import com.example.study.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRepository extends JpaRepository<StudyEntity,Long> {


    StudyEntity findByStudyId(Integer studyId);


    List<StudyEntity> findAllByPublishedTrue();

}
