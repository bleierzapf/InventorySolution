package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.InvOnHand;
import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvOnHandRepository extends CrudRepository<InvOnHand, StorerSkuPK> {

    @Query("SELECT inv FROM InvOnHand inv WHERE inv.clientSkuCcInfo.lastCycleCount IS NOT NULL")
    Iterable<InvOnHand> invWithCycleCount();

}