package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.repository.TasksRepository;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Date;

@Service
public class TasksImpl implements TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    public TasksImpl() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        this.timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp timestamp;

    @Override
    public Iterable<Tasks> allTasks(){ return tasksRepository.allTasks(); }

    @Override
    public int insertNewTask(@RequestParam String sku, @RequestParam int qty, @RequestParam String loc,
                             @RequestParam int client, @RequestParam String lot) {
        return tasksRepository.insertNewTask(sku, qty, loc, client, lot, this.timestamp);
    }

    // Overload Cycle Count Tasks for Mobile Filter
    @Override
    public Tasks cycleCountTask() {
        return tasksRepository.cycleCountTask();
    }

    @Override
    public Tasks cycleCountTask(@RequestParam("filterClient") int filterClient) {
        return tasksRepository.cycleCountTask(filterClient);
    }
/*
    @Override
    public Iterable<Tasks> cycleCountIterableTask01(String filterLocSql) {
        return tasksRepository.cycleCountIterableTask01(filterLocSql);
    }

    @Override
    public Iterable<Tasks> cycleCountIterableTask11(int filterClient, String filterLocSql) {
        return tasksRepository.cycleCountIterableTask11(filterClient, filterLocSql);
    }
 */
    // Overload Cycle Count Tasks for Mobile Filter

    @Override
    public int updateTaskUserName(@RequestParam String iUserName, @RequestParam int iTask){
        return tasksRepository.updateTaskUserName(iUserName, iTask, this.timestamp);
    };

    @Override
    public int postCompletedTask(@RequestParam int iTask){
        return tasksRepository.postCompletedTask(iTask, this.timestamp);
    };

}
