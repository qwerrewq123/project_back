package com.example.study.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SignUpRequestDto {

    @NotBlank
    private String id;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String certificationNumber;
}
