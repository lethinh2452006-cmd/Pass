package com.thinh.pas.domain.reponse;

import com.thinh.pas.domain.entities.cakes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCakeReponse {
    private List<GetCakeReponse> getCakeReponseList;
    private int pageIndex;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;
}
