package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Integer> {
}