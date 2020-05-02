package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.Sku;
import org.springframework.data.repository.CrudRepository;

public interface SkuRepository extends CrudRepository<Sku, Integer> {
}