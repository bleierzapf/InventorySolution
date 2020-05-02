package com.inventorysolution.inventory.repository;

import com.inventorysolution.inventory.beans.InvOnHand;
import com.inventorysolution.inventory.beans.compositeId.StorerSkuPK;
import org.springframework.data.repository.CrudRepository;

public interface InvOnHandRepository extends CrudRepository<InvOnHand, StorerSkuPK> {
}