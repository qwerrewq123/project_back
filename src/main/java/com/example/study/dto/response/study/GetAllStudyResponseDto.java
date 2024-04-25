package com.example.study.dto.response.study;

import com.example.study.common.ResponseCode;
import com.example.study.common.ResponseMessage;
import com.example.study.dto.response.ResponseDto;
import com.example.study.entity.StudyEntity;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Getter

public class GetAllStudyResponseDto extends ResponseDto {

    private List<StudyEntity> studies = new ArrayList<>();


    private GetAllStudyResponseDto(List<StudyEntity> studies){
        super();
        this.studies=studies;

    }

    public static ResponseEntity<GetAllStudyResponseDto> success(List<StudyEntity> studies){
        GetAllStudyResponseDto responseBody = new GetAllStudyResponseDto(studies);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_STUDY, ResponseMessage.NOT_EXISTED_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
