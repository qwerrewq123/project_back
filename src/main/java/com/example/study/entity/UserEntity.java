package com.example.study.entity;


import com.example.study.dto.auth.SignUpRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="user")
@Table(name="user")
public class UserEntity {
    @Id
    private String userId;
    private String password;
    private String email;
    private String type;
    private String role;
    private String bio;
    private String occupation;
    private String location;
    private String profileImage;




    public UserEntity(SignUpRequestDto dto) {
        this.userId = dto.getId();
        this.password= dto.getPassword();
        this.email=dto.getEmail();
        this.type="app";
        this.role="ROLE_USER";
    }
}
