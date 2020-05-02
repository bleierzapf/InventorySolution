package com.inventorysolution.inventory.beans;

import com.inventorysolution.inventory.beans.compositeId.SkuLotLocPK;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity (name = "InvOnHand")
@Table (name = "LOTXLOCXID")
public class InvOnHand {

    @Column(name = "client")
    private int client;
    @EmbeddedId
    private SkuLotLocPK skuLotLocPK;
    @Column(name = "qty")
    private int qty;

    public int getClient() { return client; }
    public void setClient(int client) { this.client = client; }

    public SkuLotLocPK getSkuLotLocPK() { return skuLotLocPK; }
    public void setSkuLotLocPK(SkuLotLocPK skuLotLocPK) { this.skuLotLocPK = skuLotLocPK; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "client", referencedColumnName = "storerKey", insertable = false, updatable = false),
            @JoinColumn(name = "sku", referencedColumnName = "sku", insertable = false, updatable = false),
    })
    private ClientSkuCcInfo clientSkuCcInfo;

    public ClientSkuCcInfo getClientSkuCcInfo() { return clientSkuCcInfo; }
    public void setClientSkuCcInfo(ClientSkuCcInfo clientSkuCcInfo) { this.clientSkuCcInfo = clientSkuCcInfo; }
}
