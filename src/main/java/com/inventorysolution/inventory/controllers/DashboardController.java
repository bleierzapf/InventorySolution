package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.beans.InvOnHand;
import com.inventorysolution.inventory.repository.InvOnHandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.sql.DataSource;

@Controller
public class DashboardController {

    @Autowired
    DataSource dataSource;

    @Autowired
    private InvOnHandRepository invOnHandRepository;

    @RequestMapping(value = "/displayDashboard", method = RequestMethod.GET)
    public String displayDashboard(InvOnHand invOnHand, Model model){
        System.out.println("Display Dashboard");

        Iterable<InvOnHand> onHandList = invOnHandRepository.findAll();
        model.addAttribute("onHandList", onHandList);
        return "dashboard";
    }

    @RequestMapping(value = "/filterOutNonCCDates", method = RequestMethod.GET)
    public String filterOutNonCCDates(InvOnHand invOnHand, Model model){
        System.out.println("Display Dashboard Non Cycle Count Dates");

        Iterable<InvOnHand> onHandList = invOnHandRepository.findAll();
        model.addAttribute("onHandList", onHandList);
        return "dashboard";
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
