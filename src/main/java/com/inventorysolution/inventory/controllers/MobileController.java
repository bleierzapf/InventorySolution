package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.DTO.MobileCCVariables;
import com.inventorysolution.inventory.services.service.CCDetailService;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    MobileCCVariables currentCount = new MobileCCVariables();

    @GetMapping(value="/mobileStartCount")
    public String mobileCount(@Valid @ModelAttribute("countParameters") MobileCCVariables mCCvar, BindingResult result,
                              @Param("iSection") String iSection,
                              @Param("iFacility") String iFacility,
                              @Param("iZone") String iZone,
                              @Param("iClient") String iClient)
    {
        currentCount.setSection(iSection);
        currentCount.setFacility(iFacility);
        currentCount.setZone(iZone);
        currentCount.setClient(iClient);

        return "redirect:/mobile/mobileCount";
    }

    @GetMapping("/mobileCount")
    public ModelAndView mobileCount() {
        ModelAndView mav = new ModelAndView();

        if(currentCount.getInputError() == null) {
            getCurrentCount();
        } else {
            currentCount.getInputError().forEach((k,v) -> mav.addObject(k, v));
        }
        mav.addObject("taskToCount", currentCount.getCurCount()).setViewName("mobile/mobileCount");
        return mav;
    }


    private void getCurrentCount(){
        if(!currentCount.getClient().equals("*")){
            currentCount.setCurCount(tasksService.cycleCountTask(currentCount.getClient()));
        } else { currentCount.setCurCount(tasksService.cycleCountTask()); }

        try{
            tasksService.updateTaskUserName("BLEIERZAPF", currentCount.getCurCount().getTaskNumber());
        } catch (NullPointerException e ){ return; }
    }

    @RequestMapping("/mobileCountValidation")
    public String mobileCountValidation(@RequestParam("submit") String iSub,
                                        @Param("iLoc") String iLoc,
                                        @Param("iLot") String iLot,
                                        @Param("iQty") int iQty) {
        System.out.println("Mobile Count Check Controller");

        HashMap<String, String> countError = new HashMap<>();
        if(!iLoc.equals(currentCount.getCurCount().getSkuLotLocPK().getLoc())){
            countError.put("errorLoc", "Wrong Location");
        }
        if(!iLot.equals(currentCount.getCurCount().getSkuLotLocPK().getLot())){
            countError.put("errorLot", "Wrong Lot Value");
        }
        if(iQty != currentCount.getCurCount().getQty()){
            if(iQty > currentCount.getCurCount().getQty()){
                countError.put("errorQty", "Count > System");
            } else { countError.put("errorQty", "Count < System"); }
        }

        if(countError.size() == 0){
            System.out.println("Post Count");
            postCount("Posted", iLoc, iLot, iQty);
        } else if(iSub.equals("Confirm Variance")) {
            System.out.println("Post Variance");
            postCount("Out of Variance", iLoc, iLot, iQty);
        } else {
            System.out.println("Count Validation Error");
            // Error Found During Validation - Ask User For Recount / Confirmation
            currentCount.setInputError(countError);
        }
        return "redirect:/mobile/mobileCount";
    }

    private void postCount(String status, String iLoc, String iLot, int iQty){
        // No Errors In Count - Post and Move Onto Next Count
        // Completes Task In Task Table
        tasksService.postCompletedTask(currentCount.getCurCount().getTaskNumber());
        // Posts Completed Count in CCDatail Table
        ccDetailService.postCompletedCycleCount(currentCount.getCurCount().getStorerKey(), currentCount.getCurCount().getSkuLotLocPK().getSku(),
                iLoc, "BLEIERZAPF", status, "RF CC Adjustment",
                currentCount.getCurCount().getTaskNumber(), iLot, iQty);
        // Sets Error Check To Null If Previous Errors Were Caught
        if(currentCount.getInputError() != null) { currentCount.setInputError(null); }
    }

    @ModelAttribute("countParameters")
    public MobileCCVariables getDefaultVariables() { return new MobileCCVariables(); }
}
