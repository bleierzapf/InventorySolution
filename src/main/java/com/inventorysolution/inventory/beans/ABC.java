package com.inventorysolution.inventory.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ABC {

    @Id
    private int serialKey;
    private String abc;
    private int days;
}
