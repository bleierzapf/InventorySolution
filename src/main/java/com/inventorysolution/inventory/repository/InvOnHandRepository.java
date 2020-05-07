package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.InvOnHand;
import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvOnHandRepository extends CrudRepository<InvOnHand, StorerSkuPK> {
/*
    @Query("SELECT inv FROM InvOnHand inv WHERE (inv.clientSkuCcInfo.lastCycleCount != NULL)")
    public Iterable<InvOnHand> invWithCycleCount;
    
 */
}