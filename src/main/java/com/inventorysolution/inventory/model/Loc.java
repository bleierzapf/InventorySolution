package com.inventorysolution.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Loc")
@Table(name="LOC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loc {

    @Id
    private int serialKey;
    private String loc;
    private String locationType;
    private String locationFlag;
    private String locationCategory;
    private String facility;
    private String section;
    private String abc;
    private String putAwayZone;
    private String lastLocCountDate;
}
