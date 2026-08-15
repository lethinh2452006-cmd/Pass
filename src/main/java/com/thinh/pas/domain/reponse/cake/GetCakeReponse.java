package com.thinh.pas.domain.reponse;


import com.thinh.pas.domain.dtos.CakeSizeResponseDto;
import com.thinh.pas.domain.entities.cakesize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCakeReponse {
    private String namecake;

    private String description;

    private String image;

    private Integer promotion;

    private List<CakeSizeResponseDto> cakesizes;
}
