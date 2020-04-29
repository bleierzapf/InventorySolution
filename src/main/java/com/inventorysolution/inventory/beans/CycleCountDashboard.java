package com.inventorysolution.inventory.beans;

import com.inventorysolution.inventory.beans.compositeId.SkuLotLoc;

import javax.persistence.*;

@Entity
@IdClass(SkuLotLoc.class)
@Table(name = "LOTXLOCXID")
@SecondaryTable(name = "SKU")
public class CycleCountDashboard {

    private int client;
    @Id
    private String sku;
    @Id
    private int lot;
    @Id
    private String loc;

    /*
    @Column(table = "SKU")
    private String lastCycleCount;
    @Column(table = "SKU")
    private String lastCCReleaseDate;
*/
    public int getClient() { return client; }
    public String getSku() { return sku; }
    public int getLot() { return lot; }
    public String getLoc() { return loc; }
    //public String getLastCycleCount() { return lastCycleCount; }
    //public String getLastCCReleaseDate() { return lastCCReleaseDate; }

}
