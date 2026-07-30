package com.thinh.pas.domain.reponse;

import com.thinh.pas.domain.entities.size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCakeSizeReponse {
    private Integer price;

    private Integer stock;

    private String sizeName;
}
