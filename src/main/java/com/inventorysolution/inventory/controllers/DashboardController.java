package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class DashboardController {
    
    @Autowired
    private InvOnHandService invOnHandService;

    @RequestMapping(value = "displayDashboard", method = RequestMethod.GET)
    public ModelAndView displayDashboard(){
        System.out.println("Display Dashboard");
        ModelAndView mav = new ModelAndView();

        int delinquent = 0;
        int onTime = 0;
        int noPastCount = 0;
        Iterable<InvOnHand> allCCData = invOnHandService.findall();

        for (InvOnHand cc : allCCData) {
            try{
                if(cc.getClientSkuCcInfo().getDaysCountOverdue() >= 0) {
                    onTime++;
                } else {
                    delinquent++; }
            } catch (NullPointerException e) {
                noPastCount++;
            }
        }
        HashMap<String, Integer> onTimeChartNumbers = new HashMap<>();
        onTimeChartNumbers.put("On Time", onTime);
        onTimeChartNumbers.put("Delinquent", delinquent);
        onTimeChartNumbers.put("Never Counted", noPastCount);

        mav.addObject("ccTimelinessData", onTimeChartNumbers);
        mav.setViewName("dashboard");

        return mav;
    }
    
}
