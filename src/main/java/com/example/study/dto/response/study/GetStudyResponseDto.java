package com.example.study.dto.response.study;
import com.example.study.common.ResponseCode;
import com.example.study.common.ResponseMessage;
import com.example.study.dto.response.ResponseDto;
import com.example.study.entity.StudyEntity;
import com.example.study.entity.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

@Getter
public class GetStudyResponseDto extends ResponseDto {
    private UserEntity manager;
    private Set<UserEntity> members;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private String publishedDatetime;
    private Boolean published;
    private Boolean closed;

    private GetStudyResponseDto(StudyEntity studyEntity){
        super();
        this.manager = studyEntity.getManager();
        this.members = studyEntity.getMembers();
        this.title = studyEntity.getTitle();
        this.shortDescription = studyEntity.getShortDescription();
        this.fullDescription = studyEntity.getFullDescription();
        this.publishedDatetime = studyEntity.getPublishedDatetime();
        this.published = studyEntity.isPublished();
        this.closed = studyEntity.isClosed();

    }


    public static ResponseEntity<GetStudyResponseDto> success(StudyEntity studyEntity){
        GetStudyResponseDto responseBody = new GetStudyResponseDto(studyEntity);

        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistStudy(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_STUDY, ResponseMessage.NOT_EXISTED_STUDY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
