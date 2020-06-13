package com.inventorysolution.inventory.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountsByDateDTO {

    /*
    private int id;
    @JsonProperty(value="text")
    private String code;
    */

    private Date date;
    private String status;
    private int count;

}
