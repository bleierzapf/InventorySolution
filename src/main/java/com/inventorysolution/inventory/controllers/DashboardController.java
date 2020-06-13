package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.model.DTO.CountsByDateDTO;
import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.services.service.CCDetailService;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.tags.HtmlEscapingAwareTag;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class DashboardController {
    
    @Autowired
    private InvOnHandService invOnHandService;

    @Autowired
    private CCDetailService ccDetailService;

    @RequestMapping(value = "displayDashboard", method = RequestMethod.GET)
    public ModelAndView displayDashboard(){
        System.out.println("Display Dashboard");
        ModelAndView mav = new ModelAndView();

        pieOnTimeChart(mav);
        //countsByDayChart(mav);
        mav.setViewName("dashboard");

        return mav;
    }

    private ModelAndView pieOnTimeChart(ModelAndView mav){
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

        return mav.addObject("ccTimelinessData", onTimeChartNumbers);
    }

    /*
    private ModelAndView countsByDayChart(ModelAndView mav){
        List<CountsByDateDTO> last30DaysCounts = ccDetailService.last30Days();

        System.out.println(last30DaysCounts);

        return mav.addObject("countsByDateData", last30DaysCounts);
    }
    */
}
