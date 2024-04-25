package com.example.study.dto.request.study;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PatchStudyRequestDto {

    @NotBlank
    private String shortDescription;
    @NotBlank
    private String fullDescription;
}
