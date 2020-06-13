package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.model.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InvOnHandRepository extends JpaRepository<InvOnHand, StorerSkuPK> {

    @Query("SELECT inv FROM InvOnHand inv " +
            "WHERE inv.clientSkuCcInfo.lastCycleCount IS NOT NULL " +
            "AND inv.skuLotLocPK.sku NOT IN (SELECT t.skuLotLocPK.sku FROM Tasks t WHERE t.status = 'Pending') " +
            "AND inv.skuLotLocPK.loc NOT IN (SELECT l.loc FROM Loc l WHERE l.locationFlag = 'Hold') " +
            "AND inv.skuLotLocPK.loc <> 'PICKTO'")
    Iterable<InvOnHand> invWithCycleCount();

    @Query("SELECT inv FROM InvOnHand inv " +
            "WHERE inv.skuLotLocPK.sku = :inputSku " +
            "AND inv.skuLotLocPK.loc NOT IN (SELECT l.loc FROM Loc l WHERE l.locationFlag = 'Hold') " +
            "AND inv.skuLotLocPK.loc <> 'PICKTO'")
    ArrayList<InvOnHand> invToCount(String inputSku);

}