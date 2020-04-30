package com.inventorysolution.inventory.beans.compositeId;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkuLotLocId implements Serializable {
    private String sku;
    private int lot;
    private String loc;

    public SkuLotLocId(){
    }

    public SkuLotLocId(String sku, int lot, String loc){
        this.sku = sku;
        this.lot = lot;
        this.loc = loc;
    }

    public String getSku() { return sku; }
    public int getLot() { return lot; }
    public String getLoc() { return loc; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof SkuLotLocId)) { return false; }
        SkuLotLocId skuLotLocId = (SkuLotLocId) o;
        return Objects.equals(getSku(), skuLotLocId.getSku()) &&
                Objects.equals(getLot(), skuLotLocId.getLot()) &&
                Objects.equals(getLoc(), skuLotLocId.getLoc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku(), getLot(), getLoc());
    }

}
