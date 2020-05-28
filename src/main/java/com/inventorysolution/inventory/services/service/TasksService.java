package com.inventorysolution.inventory.services.service;

import com.inventorysolution.inventory.model.Tasks;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Timestamp;

@Service("tasksService")
public interface TasksService {
    Iterable<Tasks> allTasks();

    @Transactional
    int insertNewTask(String sku, int qty, String loc, int client, String lot);

    // Overload Cycle Count Tasks for Mobile Filter
    Tasks cycleCountTask();
    Tasks cycleCountTask(int filterClient);
    //Iterable<Tasks> cycleCountIterableTask01(String filterLocSql);
    //Iterable<Tasks> cycleCountIterableTask11(int filterClient, String filterLocSql);
    // Overload Cycle Count Tasks for Mobile Filter

    @Transactional
    int updateTaskUserName(String userName, int iTask);

    @Transactional
    int postCompletedTask(int iTask);
}
