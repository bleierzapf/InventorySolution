package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.InvOnHand;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class NavigationController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("Load Index Page");
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        System.out.println("Load Dashboard");
        return "dashboard";
    }

    @GetMapping("/settings")
    public String settings(){
        System.out.println("Load Settings");
        return "settings";
    }

    @GetMapping("/cycleCountRelease")
    public String ccRelease(){
        System.out.println("Load Cycle Count Release");
        return "ccRelease";
    }

    @GetMapping("/cycleCountOverview")
    public String ccOverview(){
        System.out.println("Load Cycle Count Overview");
        return "ccOverview";
    }

    @GetMapping("/cycleCountManualImport")
    public String ccManualImport(){
        System.out.println("Load Cycle Count Manual Import");
        return "ccManualImport";
    }

    @GetMapping("/locationImport")
    public String locationImport(){
        System.out.println("Load Location Import");
        return "locationImport";
    }

    @GetMapping("/skuImport")
    public String skuImport(){
        System.out.println("Load Sku Import");
        return "skuImport";
    }

    @GetMapping("/tasks")
    public String tasks(){
        System.out.println("Load Tasks");
        return "tasks";
    }

    @ModelAttribute("selectedCount")
    public InvOnHand getCycleCountValues() {
        return new InvOnHand();
    }

}
