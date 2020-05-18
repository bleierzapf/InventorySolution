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

    @Transactional
    int insertNewTask(String sku, int qty, String loc, int client, int lot);

    // Overload Cycle Count Tasks for Mobile Filter
    Iterable<Tasks> cycleCountIterableTask();
    Iterable<Tasks> cycleCountIterableTask(int filterClient);
    //Iterable<Tasks> cycleCountIterableTask01(String filterLocSql);
    //Iterable<Tasks> cycleCountIterableTask11(int filterClient, String filterLocSql);
    // Overload Cycle Count Tasks for Mobile Filter

}
