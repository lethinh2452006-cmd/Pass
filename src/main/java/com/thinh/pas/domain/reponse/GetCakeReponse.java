package com.thinh.pas.domain.reponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCakeReponse {
    private String namecake;

    private String description;

    private String image;
}
