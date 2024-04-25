package com.example.study.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailCertificationRequestDto {
    @NotBlank
    private String id;


    @NotBlank
    @Email
    private String email;
}
