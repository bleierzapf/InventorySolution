package com.inventorysolution.inventory.model;

import com.inventorysolution.inventory.model.compositeId.SkuLotLocPK;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity (name = "Tasks")
@Table(name = "TASKS")
public class Tasks {

    @Column(name="TaskType")
    private String taskType;

    @EmbeddedId
    private SkuLotLocPK skuLotLocPK;

    @Column(name="Status")
    private String status;

    @Column(name="Priority")
    private String priority;

    @Column(name="Quantity")
    private int qty;

    @Column(name="User")
    private String user;

    @Column(name="StartTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp startTime;

    @Column(name="EndTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp endTime;

    @Column(name="Storer")
    private int storerKey;

    public String getTaskType() { return taskType; }
    public void setTaskType(String taskType) { this.taskType = taskType; }

    public SkuLotLocPK getSkuLotLocPK() { return skuLotLocPK; }
    public void setSkuLotLocPK(SkuLotLocPK skuLotLocPK) { this.skuLotLocPK = skuLotLocPK; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public Timestamp getStartTime() { return startTime; }
    public void setStartTime(Timestamp startTime) { this.startTime = startTime; }

    public Timestamp getEndTime() { return endTime; }
    public void setEndTime(Timestamp endTime) { this.endTime = endTime; }

    public int getStorerKey() { return storerKey; }
    public void setStorerKey(int storerKey) { this.storerKey = storerKey; }
}
