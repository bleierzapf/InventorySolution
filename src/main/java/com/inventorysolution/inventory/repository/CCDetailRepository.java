package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.model.Sku;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface CCDetailRepository extends CrudRepository<CCDetail, Integer> {

    @Modifying
    @Query(value = "INSERT INTO CCDetail (Owner, Item, Location, CountDate, User, Status, CCAdjustmentReason, TaskNumber, Lot, Qty) " +
            "VALUES (:iClient, :iSku, :iLoc, :iCountDate, :iUser, :iStatus, :iAdjReason, :iTaskNumber, :iLot, :iQty)", nativeQuery = true)
    int postCompletedCycleCount(int iClient, String iSku, String iLoc, Timestamp iCountDate, String iUser,
                                String iStatus, String iAdjReason, int iTaskNumber, String iLot, int iQty);

}