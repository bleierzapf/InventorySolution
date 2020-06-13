package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.model.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, StorerSkuPK> {

    @Query("SELECT t FROM Tasks t WHERE t.status = 'Pending' ORDER BY t.priority, t.skuLotLocPK.loc ASC")
    Iterable<Tasks> allTasks();

    @Modifying
    @Query(value = "INSERT INTO Tasks (TaskType, Status, Sku, Priority, Quantity, Loc, StartTime, EndTime, Storer, Lot) " +
            "VALUES('Cycle Counts', 'Pending', :iSku, '1 - Highest Priority', :iQty, :iLoc, :iTimestamp, :iTimestamp, :iClient, :iLot)", nativeQuery = true)
    int insertNewTask(String iSku, int iQty, String iLoc, int iClient, String iLot, Timestamp iTimestamp);

    // Overload Cycle Count Tasks for Mobile Filter
    @Query(value = "SELECT * FROM Tasks t WHERE t.Status = 'Pending' " +
            "AND (t.User = '' OR t.User = ' ' OR t.User IS NULL) " +
            "ORDER BY t.Priority, t.Loc ASC LIMIT 1", nativeQuery = true)
    Tasks cycleCountTask();

    @Query(value = "SELECT * FROM Tasks t WHERE t.Status = 'Pending' " +
            "AND t.User = '' AND t.Storer = :filterClient " +
            "ORDER BY t.Priority, t.Loc ASC LIMIT 1", nativeQuery = true)
    Tasks cycleCountTask(String filterClient);

    /*
    @Query("SELECT t FROM Tasks t WHERE :filterLocSql")
    Iterable<Tasks> cycleCountIterableTask01(@Param("filterLocSql") String filterLocSql);

    @Query("SELECT t FROM Tasks t WHERE t.storerKey = :filterClient AND :filterLocSql")
    Iterable<Tasks> cycleCountIterableTask11(@Param("filterClient") int filterClient, @Param("filterLocSql") String filterLocSql);
    // Overload Cycle Count Tasks for Mobile Filter
     */

    @Modifying
    @Query(value = "UPDATE Tasks SET Status = 'In Process', User = :iUserName , StartTime = :iTimestamp WHERE TaskNumber = :iTask", nativeQuery = true)
    int updateTaskUserName(String iUserName, int iTask, Timestamp iTimestamp);

    @Modifying
    @Query(value = "UPDATE Tasks SET Status = 'Completed', EndTime = :iTimestamp WHERE TaskNumber = :iTask", nativeQuery = true)
    int postCompletedTask(int iTask, Timestamp iTimestamp);
}