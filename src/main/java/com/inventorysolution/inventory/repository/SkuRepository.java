package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.Sku;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends CrudRepository<Sku, Integer> {
}