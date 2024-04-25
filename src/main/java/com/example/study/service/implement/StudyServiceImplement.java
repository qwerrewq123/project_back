package com.example.study.service.implement;

import com.example.study.dto.request.study.PatchStudyRequestDto;
import com.example.study.dto.request.study.PostStudyRequestDto;
import com.example.study.dto.response.ResponseDto;
import com.example.study.dto.response.study.*;
import com.example.study.entity.NotificationEntity;
import com.example.study.entity.StudyEntity;
import com.example.study.entity.UserEntity;
import com.example.study.repository.NotificationRespository;
import com.example.study.repository.StudyRepository;
import com.example.study.repository.UserRepository;
import com.example.study.service.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class StudyServiceImplement implements StudyService {

    private final UserRepository userRepository;
    private final StudyRepository studyRepository;
    private final NotificationRespository notificationRespository;

    @Override
    public ResponseEntity<? super PostStudyResponseDto> postStudy(PostStudyRequestDto dto, String userId) {
        try{

            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity == null) return PostStudyResponseDto.notExistUser();

            StudyEntity studyEntity = new StudyEntity();
            studyEntity.setManager(userEntity);
            studyEntity.setTitle(dto.getTitle());
            studyEntity.setShortDescription(dto.getShortDescription());
            studyEntity.setFullDescription(dto.getFullDescription());
            studyEntity.setClosed(false);
            studyEntity.setPublished(false);

            studyRepository.save(studyEntity);

            NotificationEntity notificationEntity = new NotificationEntity();
            notificationEntity.setContent("키키키키");
            List<UserEntity> all = userRepository.findAll();
            for (UserEntity user : all) {
                notificationEntity.getUsers().add(user);
            }

            notificationRespository.save(notificationEntity);



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetStudyResponseDto> getStudy(Integer studyId) {

        StudyEntity studyEntity = null;
        try{
            studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity == null) {
                return GetStudyResponseDto.notExistStudy();
            }

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetStudyResponseDto.success(studyEntity);
    }

    @Override
    public ResponseEntity<? super GetAllStudyResponseDto> getAllStudy() {

        List<StudyEntity> studies = null;
        try{

            studies = studyRepository.findAll();
            System.out.println(studies);
            if(studies == null){
                return GetAllStudyResponseDto.notExistStudy();
            }



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetAllStudyResponseDto.success(studies);
    }

    @Override
    public ResponseEntity<? super DeleteStudyResponseDto> deleteStudy(Integer studyId,String userId) {


        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return DeleteStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity== null){
                return DeleteStudyResponseDto.noExistStudy();
            }

            boolean isWriter = studyEntity.getManager().getUserId().equals(userId);

            if(!isWriter){
                return DeleteStudyResponseDto.noPermission();
            }

            studyRepository.delete(studyEntity);



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PatchStudyResponseDto> patchStudy(PatchStudyRequestDto dto, Integer studyId, String userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return DeleteStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity== null){
                return DeleteStudyResponseDto.noExistStudy();
            }

            boolean isWriter = studyEntity.getManager().getUserId().equals(userId);

            if(!isWriter){
                return DeleteStudyResponseDto.noPermission();
            }


            studyEntity.setShortDescription(dto.getShortDescription());
            studyEntity.setFullDescription(dto.getFullDescription());



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PatchStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super PublishStudyResponseDto> publishStudy(Integer studyId, String userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return PublishStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity== null){
                return PublishStudyResponseDto.noExistStudy();
            }

            boolean isWriter = studyEntity.getManager().getUserId().equals(userId);

            if(!isWriter){
                return PublishStudyResponseDto.noPermission();
            }

            studyEntity.setPublished(true);



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PublishStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super CloseStudyResponseDto> closeStudy(Integer studyId, String userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return CloseStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity== null){
                return CloseStudyResponseDto.noExistStudy();
            }

            boolean isWriter = studyEntity.getManager().getUserId().equals(userId);

            if(!isWriter){
                return CloseStudyResponseDto.noPermission();
            }

            studyEntity.setClosed(true);



        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return CloseStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super JoinStudyResponseDto> joinStudy(Integer studyId, String userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return JoinStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);
            if(studyEntity== null){
                return JoinStudyResponseDto.noExistStudy();
            }



            studyEntity.getMembers().add(userEntity);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return JoinStudyResponseDto.success();
    }

    @Override
    public ResponseEntity<? super LeaveStudyResponseDto> leaveStudy(Integer studyId, String userId) {
        try{
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity== null){
                return LeaveStudyResponseDto.noExistUser();
            }
            StudyEntity studyEntity = studyRepository.findByStudyId(studyId);

            if(studyEntity== null){
                return LeaveStudyResponseDto.noExistStudy();
            }

            studyEntity.getMembers().remove(userEntity);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return LeaveStudyResponseDto.success();
    }
}
