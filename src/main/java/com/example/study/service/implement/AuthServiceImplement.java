package com.example.study.service.implement;


import com.example.study.dto.auth.*;
import com.example.study.dto.response.ResponseDto;
import com.example.study.dto.response.auth.*;
import com.example.study.entity.CertificationEntity;
import com.example.study.entity.UserEntity;
import com.example.study.provider.EmailProvider;
import com.example.study.provider.JwtProvider;
import com.example.study.repository.CertificationRepository;
import com.example.study.repository.UserRepository;
import com.example.study.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final EmailProvider emailProvider;
    private final CertificationRepository certificationRepository;
    private final JwtProvider jwtProvider;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public ResponseEntity<? super IdCheckResponseDto> idCheck(IdCheckRequestDto dto) {
        try{
            String userId = dto.getId();
            boolean isExistId = userRepository.existsByUserId(userId);
            if (isExistId) {
                return IdCheckResponseDto.duplicated();
            }

        }catch (Exception exception){
            exception.printStackTrace();
            return IdCheckResponseDto.databaseError();
        }

        return IdCheckResponseDto.success();
    }

    @Override
    public ResponseEntity<? super EmailCertificationResponseDto> emailCertification(EmailCertificationRequestDto dto) {

        try{
            String userId = dto.getId();
            String email = dto.getEmail();
            boolean isExistId = userRepository.existsByUserId(userId);
            if (isExistId) {
                return IdCheckResponseDto.duplicated();
            }

            String certificationNumber = getCertificationNumber();
            boolean isSuccessed = emailProvider.sendCertificationMail(email, certificationNumber);
            if(!isSuccessed){
                return EmailCertificationResponseDto.mailSendFail();
            }

            CertificationEntity certificationEntity = new CertificationEntity(userId, email, certificationNumber);
            certificationRepository.save(certificationEntity);


        }catch (Exception exception){
            exception.printStackTrace();
            return IdCheckResponseDto.databaseError();
        }

        return EmailCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super CheckCertificationResponseDto> checkCertification(CheckCertificationRequestDto dto) {
        try{

            String id = dto.getId();
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();
            CertificationEntity certificationEntity = certificationRepository.findByUserId(id);
            if(certificationEntity == null) {
                return CheckCertificationResponseDto.certificationFail();
            }
            boolean isMatched = certificationEntity.getEmail().equals(email) && certificationEntity.getCertificationNumber().equals(certificationNumber);
            if(!isMatched){
                return CheckCertificationResponseDto.certificationFail();
            }


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return CheckCertificationResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try{

            String userid = dto.getId();

            boolean isExistId = userRepository.existsByUserId(userid);
            if(isExistId){
                return SignUpResponseDto.duplicated();
            }
            String email = dto.getEmail();
            String certificationNumber = dto.getCertificationNumber();
            CertificationEntity certificationEntity = certificationRepository.findByUserId(userid);

            boolean isMatched = certificationEntity.getEmail().equals(email) && certificationEntity.getCertificationNumber().equals(certificationNumber);
            if(!isMatched){
                return SignUpResponseDto.certificationFail();
            }

            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);
            UserEntity userEntity = new UserEntity(dto);

            userRepository.save(userEntity);
            certificationRepository.deleteByUserId(userid);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token =null;
        try{
            String userId = dto.getId();
            UserEntity userEntity = userRepository.findByUserId(userId);
            if(userEntity==null) return SignInResponseDto.signInFail();

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();
            boolean isMatched = passwordEncoder.matches(password,encodedPassword);
            if(!isMatched) return SignInResponseDto.signInFail();

            token = jwtProvider.create(userId);


        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);

    }


    private  String getCertificationNumber(){
        String certificationNumber ="";
        for (int i = 0; i < 4; i++) {
            certificationNumber += (int) (Math.random()*10);


        }

        return certificationNumber;
    }
}
