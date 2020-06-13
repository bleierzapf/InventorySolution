package com.inventorysolution.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity(name = "CCDetail")
@Table(name = "CCDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CCDetail {

    @Column(name = "Owner")
    private int owner;

    @Column(name = "Item")
    private String sku;

    @Column(name = "Location")
    private String loc;

    @Column(name = "CountDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp countDate;

    @Column(name = "User")
    private String user;

    @Column(name = "Status")
    private String status;

    @Column(name = "CCAdjustmentReason")
    private String adjReason;

    @Id
    @Column(name = "TaskNumber")
    private int taskNumber;

    @Column(name = "ReportID")
    private Integer reportId;

    @Column(name = "OrderNumber")
    private String orderNumber;

    @Column(name = "Lot")
    private String lot;

    @Column(name = "Qty")
    private int qty;
}
