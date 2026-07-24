package com.thinh.pas.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCakeRequestDto {
    @NotBlank(message = "can't be no blank")
    private String namecake;
    @NotBlank(message = "can't be no blank")
    private String description;
    @NotBlank(message = "can't be no blank")
    private String image;
}
