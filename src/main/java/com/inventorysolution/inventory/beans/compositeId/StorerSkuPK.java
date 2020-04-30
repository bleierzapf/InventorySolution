package com.inventorysolution.inventory.beans.compositeId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StorerSkuPK implements Serializable {
    @Column(name = "storerkey")
    private int storerKey;
    @Column(name = "sku")
    private String sku;

    public StorerSkuPK(){ }

    public StorerSkuPK(int storerKey, String sku) {
        this.storerKey = storerKey;
        this.sku = sku;
    }

    public int getStorerKey() { return storerKey; }
    public String getSku() { return sku; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (!(o instanceof StorerSkuPK)) { return false; }
        StorerSkuPK storerSkuPK = (StorerSkuPK) o;
        return Objects.equals(getStorerKey(), storerSkuPK.getStorerKey()) &&
                Objects.equals(getSku(), storerSkuPK.getSku());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStorerKey(), getSku());
    }

}
