package com.thinh.pas.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCakeReponseDto {
    private String namecake;

    private String description;

    private String image;
}
