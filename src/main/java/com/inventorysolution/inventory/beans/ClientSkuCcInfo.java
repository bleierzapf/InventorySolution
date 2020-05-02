package com.inventorysolution.inventory.beans;

import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "ClientSkuCcInfo")
@Table(name = "SKU")
public class ClientSkuCcInfo implements Serializable {

    @Id
    @Column(name = "serialKey")
    private int serialKey;
    @Column(name = "storerKey")
    private int storerKey;
    @Column(name = "sku")
    private String sku;
    @Column(name = "lastCycleCount")
    private String lastCycleCount;
    @Column(name = "lastCcReleaseDate")
    private String lastCcReleaseDate;

    public int getSerialKey() { return serialKey; }
    public void setSerialKey(int serialKey) { this.serialKey = serialKey; }

    public int getStorerKey() { return storerKey; }
    public void setStorerKey(int storerKey) { this.storerKey = storerKey; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getLastCycleCount() { return lastCycleCount; }
    public void setLastCycleCount(String lastCycleCount) { this.lastCycleCount = lastCycleCount; }

    public String getLastCcReleaseDate() { return lastCcReleaseDate; }
    public void setLastCcReleaseDate(String lastCcReleaseDate) { this.lastCcReleaseDate = lastCcReleaseDate; }

}
