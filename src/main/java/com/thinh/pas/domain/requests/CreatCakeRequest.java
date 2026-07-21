package com.thinh.pas.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatCakeRequest {
    private String namecake;
    private String description;
    private String image;
}
