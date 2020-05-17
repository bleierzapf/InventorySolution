package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.repository.TasksRepository;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

    public TasksImpl() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        this.timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public Iterable<Tasks> allTasks(){ return tasksRepository.allTasks(); }

    @Override
    public int skuInPending(String sku) { return tasksRepository.skuInPending(sku); }

    @Override
    public int insertNewTask(String sku, int qty, String loc, int client, int lot) {
        return tasksRepository.insertNewTask(sku, qty, loc, client, lot, this.timestamp); };
}
