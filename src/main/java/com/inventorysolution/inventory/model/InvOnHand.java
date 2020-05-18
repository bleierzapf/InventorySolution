package com.inventorysolution.inventory.model;

import com.inventorysolution.inventory.model.compositeId.SkuLotLocPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity (name = "InvOnHand")
@Table (name = "LOTXLOCXID")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvOnHand {

    //transient boolean selected;

    @Column(name = "client")
    private int client;
    @EmbeddedId
    private SkuLotLocPK skuLotLocPK;
    @Column(name = "qty")
    private int qty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "client", referencedColumnName = "storerKey", insertable = false, updatable = false),
            @JoinColumn(name = "sku", referencedColumnName = "sku", insertable = false, updatable = false),
    })
    private ClientSkuCcInfo clientSkuCcInfo;

}
