package com.thinh.pas.domain.reponse.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllCategoryRespond {
    private UUID categoryId;
    private String categoryname;
}