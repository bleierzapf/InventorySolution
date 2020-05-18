package com.inventorysolution.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity(name = "ClientSkuCcInfo")
@Table(name = "SKU")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientSkuCcInfo implements Serializable {

    @Id
    @Column(name = "serialKey")
    private int serialKey;
    @Column(name = "storerKey")
    private int storerKey;
    @Column(name = "sku")
    private String sku;

    @Column(name = "lastCycleCount")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp lastCycleCount;

    @Column(name = "lastCcReleaseDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp lastCcReleaseDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "abc", referencedColumnName = "abc", insertable = false, updatable = false),
    })
    private ABC abc;

    @Formula("calcDaysSinceLastCount")
    transient long daysSinceLastCount;

    @PostLoad
    protected void calcDaysSinceLastCount(){
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        setDaysSinceLastCount((long) (getLastCycleCount().getTime() - ts.getTime()) / (1000*3500*24));
    }
}
