package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.beans.CycleCountDashboard;
import com.inventorysolution.inventory.repository.CycleCountDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private CycleCountDashboardRepository cycleCountDashboardRepository;

    @GetMapping("/displayDashboard")
    public String displayDashboard(CycleCountDashboard cycleCountDashboard, Model model){
        System.out.println("Display Dashboard");

        List<CycleCountDashboard> ccList = new ArrayList<>();
        ccList = cycleCountDashboardRepository.getCcStats();
        model.addAttribute("ccList", ccList);
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
