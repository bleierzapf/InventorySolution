package com.inventorysolution.inventory.services.service;

import com.inventorysolution.inventory.model.InvOnHand;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("invOnHandService")
public interface InvOnHandService {
    Iterable<InvOnHand> findall();

    Iterable<InvOnHand> invWithCycleCount();

    ArrayList<InvOnHand> invToCount(String sku);
}
