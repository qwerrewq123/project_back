package com.example.study.dto.request.study;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostStudyRequestDto {
    @NotBlank
    private String title;
    @NotBlank
    private String shortDescription;
    @NotBlank
    private String fullDescription;
}
