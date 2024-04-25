package com.example.study.service.implement;


import com.example.study.dto.response.ResponseDto;
import com.example.study.dto.response.user.GetSignInUserResponseDto;
import com.example.study.entity.UserEntity;
import com.example.study.repository.UserRepository;
import com.example.study.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {


    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {

        UserEntity userEntity = null;
        try{
            userEntity = userRepository.findByUserId(userId);
            if(userEntity == null) return GetSignInUserResponseDto.notExistUser();

        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetSignInUserResponseDto.success(userEntity);
    }
}
