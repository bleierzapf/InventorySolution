package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.Sku;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SkuRepository extends CrudRepository<Sku, Integer> {

    @Query("select s from Sku s")
    List<Sku> getAllSkuTable();
}