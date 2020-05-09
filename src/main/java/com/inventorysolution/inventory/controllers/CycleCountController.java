package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.beans.InvOnHand;
import com.inventorysolution.inventory.repository.InvOnHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import javax.sql.DataSource;

@Controller
public class CycleCountController {

    @Autowired
    DataSource dataSource;

    @Autowired
    private InvOnHandRepository invOnHandRepository;

    @RequestMapping(value = "/availableCCResults", method = RequestMethod.GET)
    public ModelAndView availableCCResults(InvOnHand invOnHand, Model model){
        System.out.println("Display Dashboard Non Cycle Count Dates");
        ModelAndView mav = new ModelAndView();
        Iterable<InvOnHand> onHandList = invOnHandRepository.invWithCycleCount();
        mav.addObject("onHandList", onHandList).setViewName("ccRelease");
        return mav;
    }

    /*

    @Autowired
    private SkuRepository skuRepository;

    @GetMapping("/displayDashboard")
    public String displayDashboard(Sku sku, Model model){
        System.out.println("Display Dashboard");

        List<Sku> skuList = new ArrayList<>();
        skuList = skuRepository.getAllSkuTable();
        model.addAttribute("skuList", skuList);
        return "dashboard";
    }*/
}
