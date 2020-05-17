package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.repository.InvOnHandRepository;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class InvOnHandImpl implements InvOnHandService {

    @Autowired
    private InvOnHandRepository invOnHandRepository;

    @Override
    public Iterable<InvOnHand> invWithCycleCount(){
        return invOnHandRepository.invWithCycleCount();
    }

    @Override
    public ArrayList<InvOnHand> invToCount(String sku) { return invOnHandRepository.invToCount(sku); }

}
