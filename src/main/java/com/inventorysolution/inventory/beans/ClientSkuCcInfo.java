package com.inventorysolution.inventory.beans;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity(name = "ClientSkuCcInfo")
@Table(name = "SKU")
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

    public int getSerialKey() { return serialKey; }
    public void setSerialKey(int serialKey) { this.serialKey = serialKey; }

    public int getStorerKey() { return storerKey; }
    public void setStorerKey(int storerKey) { this.storerKey = storerKey; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public Timestamp getLastCycleCount() { return lastCycleCount; }
    public void setLastCycleCount(Timestamp lastCycleCount) { this.lastCycleCount = lastCycleCount; }

    public Timestamp getLastCcReleaseDate() { return lastCcReleaseDate; }
    public void setLastCcReleaseDate(Timestamp lastCcReleaseDate) { this.lastCcReleaseDate = lastCcReleaseDate; }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "abc", referencedColumnName = "abc", insertable = false, updatable = false),
    })
    private ABC abc;

    public ABC getAbc() { return abc; }
    public void setAbc(ABC abc) { this.abc = abc; }

    @Formula("calcDaysSinceLastCount")
    transient long daysSinceLastCount;

    public long getDaysSinceLastCount() { return daysSinceLastCount; }
    public void setDaysSinceLastCount(long daysSinceLastCount) { this.daysSinceLastCount = daysSinceLastCount; }

    @PostLoad
    protected void calcDaysSinceLastCount(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        setDaysSinceLastCount((long) (getLastCycleCount().getTime() - ts.getTime()) / (1000*3500*24));
    }
}
