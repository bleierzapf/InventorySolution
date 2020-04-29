package com.inventorysolution.inventory.beans.compositeId;

import java.io.Serializable;

public class SkuLotLoc implements Serializable {
    private String sku;
    private int lot;
    private String loc;

    public SkuLotLoc(String sku, int lot, String loc){
        this.sku = sku;
        this.lot = lot;
        this.loc = loc;
    }
}
