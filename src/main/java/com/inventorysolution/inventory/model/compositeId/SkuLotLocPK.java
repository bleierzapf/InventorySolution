package com.inventorysolution.inventory.model.compositeId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkuLotLocPK implements Serializable {
    @Column(name = "sku")
    private String sku;
    @Column(name = "lot")
    private int lot;
    @Column(name = "loc")
    private String loc;

    public SkuLotLocPK(){
    }

    public SkuLotLocPK(String sku, int lot, String loc){
        this.sku = sku;
        this.lot = lot;
        this.loc = loc;
    }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getLot() { return lot; }
    public void setLot(int lot) { this.lot = lot; }

    public String getLoc() { return loc; }
    public void setLoc(String loc) { this.loc = loc; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof SkuLotLocPK)) { return false; }
        SkuLotLocPK skuLotLocPK = (SkuLotLocPK) o;
        return Objects.equals(getSku(), skuLotLocPK.getSku()) &&
                Objects.equals(getLot(), skuLotLocPK.getLot()) &&
                Objects.equals(getLoc(), skuLotLocPK.getLoc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku(), getLot(), getLoc());
    }

}
