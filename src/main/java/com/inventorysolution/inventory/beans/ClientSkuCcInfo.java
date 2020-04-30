package com.inventorysolution.inventory.beans;

import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "ClientSkuCcInfo")
@Table(name = "SKU")
public class ClientSkuCcInfo {

    @EmbeddedId
    private StorerSkuPK storerSkuPK;
    private String lastCycleCount;
    private String lastCcReleaseDate;

    public StorerSkuPK getStorerSkuPK() { return storerSkuPK; }
    public void setStorerSkuPK(StorerSkuPK id) { this.storerSkuPK = storerSkuPK; }

    public String getLastCycleCount() { return lastCycleCount; }
    public void setLastCycleCount(String lastCycleCount) { this.lastCycleCount = lastCycleCount; }

    public String getLastCcReleaseDate() { return lastCcReleaseDate; }
    public void setLastCcReleaseDate(String lastCcReleaseDate) { this.lastCcReleaseDate = lastCcReleaseDate; }

}
