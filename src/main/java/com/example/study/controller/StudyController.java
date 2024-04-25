package com.example.study.controller;

import com.example.study.dto.request.study.PatchStudyRequestDto;
import com.example.study.dto.request.study.PostStudyRequestDto;
import com.example.study.dto.response.study.*;
import com.example.study.service.StudyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Join;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/study")
@RequiredArgsConstructor
public class StudyController {

    private final StudyService studyService;

    @PostMapping("")
    public ResponseEntity<? super PostStudyResponseDto> postStudy(
            @RequestBody @Valid PostStudyRequestDto requestbody,
            @AuthenticationPrincipal String userId){

        ResponseEntity<? super PostStudyResponseDto> response = studyService.postStudy(requestbody, userId);
        return response;

    }


    @GetMapping("{studyId}")
    public ResponseEntity<? super GetStudyResponseDto> getStudy(
            @PathVariable("studyId") Integer studyId
    ){

        ResponseEntity<? super GetStudyResponseDto> response = studyService.getStudy(studyId);
        return response;


    }


    @GetMapping("/all")
    public ResponseEntity<? super GetAllStudyResponseDto> getAllStudy(

    ){

        ResponseEntity<? super GetAllStudyResponseDto> response = studyService.getAllStudy();
        return response;


    }

    @DeleteMapping("{studyId}")
    public ResponseEntity<? super DeleteStudyResponseDto> getStudy(
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){

        ResponseEntity<? super DeleteStudyResponseDto> response = studyService.deleteStudy(studyId, userId);
        return response;


    }

    @PatchMapping("{studyId}")
    public ResponseEntity<? super PatchStudyResponseDto> patchStudy(
            @RequestBody @Valid PatchStudyRequestDto dto,
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){
        ResponseEntity<? super PatchStudyResponseDto> response = studyService.patchStudy(dto, studyId, userId);
        return response;


    }

    @PostMapping("/publish/{studyId}")
    public ResponseEntity<? super PublishStudyResponseDto> publishStudy(
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){

        ResponseEntity<? super PublishStudyResponseDto> response = studyService.publishStudy(studyId, userId);
        return response;


    }

    @PostMapping("/close/{studyId}")
    public ResponseEntity<? super CloseStudyResponseDto> closeStudy(
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){

        ResponseEntity<? super CloseStudyResponseDto> response = studyService.closeStudy(studyId, userId);
        return response;


    }

    @PostMapping("/join/{studyId}")
    public ResponseEntity<? super JoinStudyResponseDto> joinStudy(
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){

        ResponseEntity<? super JoinStudyResponseDto> response = studyService.joinStudy(studyId, userId);
        return response;


    }

    @PostMapping("/leave/{studyId}")
    public ResponseEntity<? super LeaveStudyResponseDto> leaveStudy(
            @PathVariable("studyId") Integer studyId,
            @AuthenticationPrincipal String userId
    ){

        ResponseEntity<? super LeaveStudyResponseDto> response = studyService.leaveStudy(studyId, userId);
        return response;


    }
}
