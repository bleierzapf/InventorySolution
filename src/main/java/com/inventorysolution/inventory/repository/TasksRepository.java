package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.model.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Repository
public interface TasksRepository extends CrudRepository<Tasks, StorerSkuPK> {

    @Query("SELECT t FROM Tasks t WHERE t.status = 'Pending' ORDER BY t.priority, t.skuLotLocPK.loc ASC")
    Iterable<Tasks> allTasks();

    @Modifying
    @Query(value = "INSERT INTO Tasks (TaskType, Status, Sku, Priority, Quantity, Loc, StartTime, EndTime, Storer, Lot) " +
            "VALUES('Cycle Counts', 'Pending', :iSku, '1 - Highest Priority', :iQty, :iLoc, :iTimestamp, :iTimestamp, :iClient, :iLot)", nativeQuery = true)
    int insertNewTask(@Param("iSku") String iSku, @Param("iQty") int iQty, @Param("iLoc") String iLoc,
                      @Param("iClient") int iClient, @Param("iLot") int iLot, @Param("iTimestamp") Timestamp iTimestamp);

    // Overload Cycle Count Tasks for Mobile Filter
    @Query("SELECT t FROM Tasks t WHERE t.status = 'Pending' ORDER BY t.priority, t.skuLotLocPK.loc ASC")
    Iterable<Tasks> cycleCountIterableTask();

    @Query("SELECT t FROM Tasks t WHERE t.status = 'Pending' AND t.storerKey = :filterClient ORDER BY t.priority, t.skuLotLocPK.loc ASC")
    Iterable<Tasks> cycleCountIterableTask(@Param("filterClient") int filterClient);

    /*
    @Query("SELECT t FROM Tasks t WHERE :filterLocSql")
    Iterable<Tasks> cycleCountIterableTask01(@Param("filterLocSql") String filterLocSql);

    @Query("SELECT t FROM Tasks t WHERE t.storerKey = :filterClient AND :filterLocSql")
    Iterable<Tasks> cycleCountIterableTask11(@Param("filterClient") int filterClient, @Param("filterLocSql") String filterLocSql);
    // Overload Cycle Count Tasks for Mobile Filter
     */

}