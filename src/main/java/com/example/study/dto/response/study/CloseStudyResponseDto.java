package com.example.study.dto.response.study;

import com.example.study.common.ResponseCode;
import com.example.study.common.ResponseMessage;
import com.example.study.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CloseStudyResponseDto extends ResponseDto {


    private CloseStudyResponseDto(){
        super();
    }

    public static ResponseEntity<CloseStudyResponseDto> success(){
        CloseStudyResponseDto responseBody = new CloseStudyResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }


    public static ResponseEntity<ResponseDto> noExistStudy(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_STUDY, ResponseMessage.NOT_EXISTED_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> noExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responseBody);
    }
}
