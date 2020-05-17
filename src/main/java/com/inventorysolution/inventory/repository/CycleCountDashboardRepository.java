package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.ClientSkuCcInfo;
//import com.inventorysolution.inventory.beans.CycleCountDashboard;
import com.inventorysolution.inventory.model.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CycleCountDashboardRepository extends CrudRepository<ClientSkuCcInfo, StorerSkuPK> {

    @Query("select c from ClientSkuCcInfo c")
    public List<ClientSkuCcInfo> getCcStats();
}