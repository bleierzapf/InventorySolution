package com.inventorysolution.inventory.services.service;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.model.Tasks;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service("tasksService")
public interface TasksService {
    Iterable<Tasks> allTasks();

    int skuInPending(String sku);

    @Transactional
    int insertNewTask(String sku, int qty, String loc, int client, int lot);

}
