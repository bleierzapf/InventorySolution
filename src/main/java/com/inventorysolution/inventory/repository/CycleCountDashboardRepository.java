package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.ClientSkuCcInfo;
//import com.inventorysolution.inventory.beans.CycleCountDashboard;
import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CycleCountDashboardRepository extends CrudRepository<ClientSkuCcInfo, StorerSkuPK> {

    @Query("select c from ClientSkuCcInfo c")
    public List<ClientSkuCcInfo> getCcStats();
}