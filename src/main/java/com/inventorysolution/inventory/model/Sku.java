package com.inventorysolution.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="SKU")
@Table(name="SKU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sku {

    @Id
    private int serialKey;
    private int storerKey;
    private String sku;
    private String descr;
    private String packKey;
    private String putAwayZone;
    private String putAwayLoc;
    private String abc;
    private String lastCycleCount;
    private String lastCCReleaseDate;
    private String editDate;
    private String editWho;
}
