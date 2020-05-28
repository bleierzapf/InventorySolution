package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.model.compositeId.SkuLotLocPK;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CycleCountController {

    @Autowired
    private InvOnHandService invOnHandService;

    @Autowired
    private TasksService tasksService;

    @RequestMapping(value="availableCCResults", method = RequestMethod.GET)
    public ModelAndView availableCCResults(){
        System.out.println("Cycle Count Release Exclude No Date History");
        ModelAndView mav = new ModelAndView();
        Iterable<InvOnHand> onHandList = invOnHandService.invWithCycleCount();
        mav.addObject("onHandList", onHandList).setViewName("ccRelease");
        return mav;
    }

    @RequestMapping(value="releaseCounts", method = RequestMethod.POST)
    public String releaseCounts (@RequestParam(value="ids[]") String skus[]) {
        List<InvOnHand> invCountArr = new ArrayList<>();

        for (String sku: skus) {
            invCountArr.addAll(invOnHandService.invToCount(sku));
            System.out.println(sku + " added to count list.");
        }

        for (InvOnHand count : invCountArr) {
            try{
                int added = tasksService.insertNewTask(count.getSkuLotLocPK().getSku(), count.getQty(),
                        count.getSkuLotLocPK().getLoc(), count.getClient(), count.getSkuLotLocPK().getLot());
                System.out.println("Added SKU " + count.getSkuLotLocPK().getSku() + " : Loc " + count.getSkuLotLocPK().getLoc());
            } catch (Exception e) {
                System.out.println("Insert Exception: " + e);
            }
        }

        return "redirect:/availableCCResults";
    }

}
