package com.thinh.pas.domain.dtos.category;

import lombok.*;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCategoryRespondDto {
    private UUID categoryId;
    private String categoryname;
}