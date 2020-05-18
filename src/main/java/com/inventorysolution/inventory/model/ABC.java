package com.inventorysolution.inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name="ABC")
@Table(name="ABC")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ABC implements Serializable {

    @Id
    private int serialKey;
    private String abc;
    private int days;
}
