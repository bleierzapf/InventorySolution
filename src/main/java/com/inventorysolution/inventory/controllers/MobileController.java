package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.model.MobileCCVariables;
import com.inventorysolution.inventory.services.service.CCDetailService;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/mobile")
public class MobileController {

    @Autowired
    private TasksService tasksService;

    @Autowired
    private CCDetailService ccDetailService;

    @GetMapping("/index")
    public String mobileIndex(){
        System.out.println("Load Mobile Index");
        return "mobile/mobileInterface";
    }

    @GetMapping("/mobileCCIndex")
    public String mobileCCIndex(){
        System.out.println("Load Mobile CC Index");
        return "mobile/mobileCCIndex";
    }

    MobileCCVariables curCount = new MobileCCVariables();

    @GetMapping("/mobileStartCount")
    public String mobileCount(@Valid @ModelAttribute("countParameters") MobileCCVariables mCCvar, BindingResult result,
                              @Param("iSection") String iSection,
                              @Param("iFacility") String iFacility,
                              @Param("iZone") String iZone,
                              @Param("iClient") String iClient) //parse to int if not *
    {
        curCount.setSection(iSection);
        curCount.setFacility(iFacility);
        curCount.setZone(iZone);
        curCount.setClient(iClient);

        return "redirect:/mobile/mobileCount";
    }

    @GetMapping("/mobileCount")
    public ModelAndView mobileCount() {

        ModelAndView mav = new ModelAndView();
        getCurrentCount();
        mav.addObject("taskToCount", curCount.getCurCount()).setViewName("mobile/mobileCount");

        return mav;
    }


    private void getCurrentCount(){
        if(!curCount.getClient().equals("*")){
            curCount.setCurCount(tasksService.cycleCountTask(Integer.parseInt(curCount.getClient())));
        } else { curCount.setCurCount(tasksService.cycleCountTask()); }

        tasksService.updateTaskUserName("BLEIERZAPF", curCount.getCurCount().getTaskNumber());
    }

    @RequestMapping("/mobileCountValidation")
    public String mobileCountValidation(@Param("iLoc") String iLoc,
                                         @Param("iLot") String iLot,
                                         @Param("iQty") int iQty) {
        System.out.println("Mobile Count Check Controller");

        HashMap<String, String> countError = new HashMap<>();
        if(!iLoc.equals(curCount.getCurCount().getSkuLotLocPK().getLoc())){
            countError.put("Loc", "Wrong Location: " + iLoc + " vs " + curCount.getCurCount().getSkuLotLocPK().getLoc());
        }
        if(!iLot.equals(curCount.getCurCount().getSkuLotLocPK().getLot())){
            countError.put("Lot", "Wrong Lot Value: " + iLoc + " vs " + curCount.getCurCount().getSkuLotLocPK().getLot());
        }
        if(iQty != curCount.getCurCount().getQty()){
            if(iQty > curCount.getCurCount().getQty()){
                countError.put("Qty", "Count > System");
            } else { countError.put("Qty", "Count < System"); }
        }

        if(countError.size() == 0){
            System.out.println("Post Count");
            // No Errors In Count - Post and Move Onto Next Count
            tasksService.postCompletedTask(curCount.getCurCount().getTaskNumber());
            ccDetailService.postCompletedCycleCount(curCount.getCurCount().getStorerKey(), curCount.getCurCount().getSkuLotLocPK().getSku(),
                    curCount.getCurCount().getSkuLotLocPK().getLoc(), "BLEIERZAPF", "Posted", "RF CC Adjustment",
                    curCount.getCurCount().getTaskNumber(), curCount.getCurCount().getSkuLotLocPK().getLot(), curCount.getCurCount().getQty());
            return "redirect:/mobile/mobileCount";
        }

        return "redirect:/mobile/mobileStartCount";
    }

    @ModelAttribute("countParameters")
    public MobileCCVariables getDefaultVariables() { return new MobileCCVariables(); }
}
