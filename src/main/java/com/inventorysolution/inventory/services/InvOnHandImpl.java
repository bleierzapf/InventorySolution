package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.repository.InvOnHandRepository;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Service
public class InvOnHandImpl implements InvOnHandService {

    @Autowired
    private InvOnHandRepository invOnHandRepository;

    @Override
    public Iterable<InvOnHand> findall(){
        return invOnHandRepository.findAll();
    }

    @Override
    public Iterable<InvOnHand> invWithCycleCount(){
        return invOnHandRepository.invWithCycleCount();
    }

    @Override
    public ArrayList<InvOnHand> invToCount(@RequestParam("inputSku") String inputSku) {
        return invOnHandRepository.invToCount(inputSku);
    }

}
