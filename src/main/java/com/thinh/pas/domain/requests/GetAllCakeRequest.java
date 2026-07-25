package com.thinh.pas.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCakeRequest {
    private int page = 1;
    private int limit = 15;
    private String search;
    private String size;
    private UUID categoryId;
    private String sortBy = "createdAt";
    private String order = "desc";
}
