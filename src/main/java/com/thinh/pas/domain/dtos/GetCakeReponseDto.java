package com.thinh.pas.domain.dtos;


import com.thinh.pas.domain.entities.cakesize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCakeReponseDto {
    private String namecake;

    private String description;

    private String image;

    private Integer promotion;

    private List<cakesize> cakesizes;
}
