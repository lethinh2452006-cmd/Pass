package com.thinh.pas.domain.dtos;

import com.thinh.pas.domain.reponse.GetCakeReponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCakeReponseDto {
    private List<GetCakeReponse> getCakeReponseList;
    private int page_index;
}
