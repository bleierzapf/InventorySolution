package com.inventorysolution.inventory.model;

import com.inventorysolution.inventory.model.compositeId.SkuLotLocPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity (name = "Tasks")
@Table(name = "TASKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
