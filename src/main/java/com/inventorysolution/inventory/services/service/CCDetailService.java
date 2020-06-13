package com.inventorysolution.inventory.services.service;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.model.DTO.CountsByDateDTO;
import com.inventorysolution.inventory.model.InvOnHand;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("ccDetailService")
public interface CCDetailService {

    Iterable<CCDetail> ccDetailList();

    Iterable<CCDetail> viewCounts();

    @Transactional
    int postCompletedCycleCount(int iClient, String iSku, String iLoc, String iUser,
                                String iStatus, String iAdjReason, int iTaskNumber, String iLot, int iQty);

    //List<CountsByDateDTO> last30Days();
}
