package com.inventorysolution.inventory.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ABC implements Serializable {

    @Id
    private int serialKey;
    private String abc;
    private int days;

    public int getSerialKey() { return serialKey; }
    public void setSerialKey(int serialKey) { this.serialKey = serialKey; }

    public String getAbc() { return abc; }
    public void setAbc(String abc) { this.abc = abc; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }
}
