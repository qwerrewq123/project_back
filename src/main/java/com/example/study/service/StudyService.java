package com.example.study.service;

import com.example.study.dto.request.study.PatchStudyRequestDto;
import com.example.study.dto.request.study.PostStudyRequestDto;
import com.example.study.dto.response.study.*;
import org.springframework.http.ResponseEntity;

public interface StudyService {
    ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userId);

    ResponseEntity<? super GetStudyResponseDto> getStudy(Integer studyId);

    ResponseEntity<? super GetAllStudyResponseDto> getAllStudy();


    ResponseEntity<? super DeleteStudyResponseDto> deleteStudy(Integer studyId,String userId);

    ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyId, String userId);

    ResponseEntity<? super PublishStudyResponseDto> publishStudy(Integer studyId, String userId);

    ResponseEntity<? super CloseStudyResponseDto> closeStudy(Integer studyId,String userId);

    ResponseEntity<? super JoinStudyResponseDto> joinStudy(Integer studyId,String userId);

    ResponseEntity<? super LeaveStudyResponseDto> leaveStudy(Integer studyId,String userId);



}
