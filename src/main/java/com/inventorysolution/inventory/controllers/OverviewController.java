package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.CCDetail;
import com.inventorysolution.inventory.services.service.CCDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/overview")
public class OverviewController {

    @Autowired
    private CCDetailService ccDetailService;

    @RequestMapping(value="/historicCCList", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView historicCCList(){
        System.out.println("Overview List");
        ModelAndView mav = new ModelAndView();
        Iterable<CCDetail> overviewList = ccDetailService.viewCounts();
        mav.addObject("overview", overviewList).setViewName("ccOverview");
        return mav;
    }


}
