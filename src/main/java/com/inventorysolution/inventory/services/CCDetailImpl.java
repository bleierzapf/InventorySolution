package com.inventorysolution.inventory.services;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.model.DTO.CountsByDateDTO;
import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.repository.CCDetailRepository;
import com.inventorysolution.inventory.repository.InvOnHandRepository;
import com.inventorysolution.inventory.services.service.CCDetailService;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CCDetailImpl implements CCDetailService {

    @Autowired
    private CCDetailRepository ccDetailRepository;

    public CCDetailImpl() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        this.timestamp = timestamp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Timestamp timestamp;

    @Override
    public Iterable<CCDetail> ccDetailList() {
        return ccDetailRepository.findAll();
    }

    @Override
    public int postCompletedCycleCount(@RequestParam int iClient,@RequestParam String iSku,@RequestParam String iLoc,@RequestParam String iUser, @RequestParam String iStatus,
                                @RequestParam String iAdjReason,@RequestParam int iTaskNumber,@RequestParam String iLot,@RequestParam int iQty) {
        return ccDetailRepository.postCompletedCycleCount(iClient, iSku, iLoc, this.timestamp, iUser,
                iStatus, iAdjReason, iTaskNumber, iLot, iQty); }

    public Iterable<CCDetail> viewCounts() { return ccDetailRepository.findAll(); }

    /*
    @Override
    public List<CountsByDateDTO> last30Days() { return ccDetailRepository.last30Days(); }
    */

}
