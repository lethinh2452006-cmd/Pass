package com.thinh.pas.domain.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakeSizeResponseDto {
    private Integer price;

    private Integer stock;

    private String sizeName;
}
