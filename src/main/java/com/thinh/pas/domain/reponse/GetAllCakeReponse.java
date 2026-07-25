package com.thinh.pas.domain.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCakeReponse {
    private List<GetCakeReponse> getCakeReponseList;
    private int page_index;
}
