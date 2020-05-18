package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.repository.TasksRepository;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public int insertNewTask(String sku, int qty, String loc, int client, int lot) {
        return tasksRepository.insertNewTask(sku, qty, loc, client, lot, this.timestamp);
    }

    // Overload Cycle Count Tasks for Mobile Filter
    @Override
    public Iterable<Tasks> cycleCountIterableTask() {
        return tasksRepository.cycleCountIterableTask();
    }

    @Override
    public Iterable<Tasks> cycleCountIterableTask(int filterClient) {
        return tasksRepository.cycleCountIterableTask(filterClient);
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


}
