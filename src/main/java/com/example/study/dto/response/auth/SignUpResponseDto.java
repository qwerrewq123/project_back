package com.example.study.dto.response.auth;


import com.example.study.common.ResponseCode;
import com.example.study.common.ResponseMessage;
import com.example.study.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SignUpResponseDto extends ResponseDto {

    private SignUpResponseDto(){
        super();
    }

    public static ResponseEntity<SignUpResponseDto> success(){

        SignUpResponseDto responseBody = new SignUpResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);

    }

    public static ResponseEntity<ResponseDto> duplicated(){

        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATE_ID, ResponseMessage.DUPLICATE_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);

    }


    public static ResponseEntity<ResponseDto> certificationFail(){

        ResponseDto responseBody = new ResponseDto(ResponseCode.CERTIFICATION_FAIL, ResponseMessage.CERTIFICATION_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);

    }
}
