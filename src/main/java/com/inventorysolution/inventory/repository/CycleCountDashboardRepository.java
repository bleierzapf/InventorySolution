package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.CycleCountDashboard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CycleCountDashboardRepository extends CrudRepository<CycleCountDashboard, Integer> {

    @Query("select c from CycleCountDashboard c")
    List<CycleCountDashboard> getCcStats();
}