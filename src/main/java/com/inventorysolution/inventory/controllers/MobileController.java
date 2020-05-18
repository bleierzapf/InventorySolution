package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/mobile")
public class MobileController {

    @Autowired
    private TasksService tasksService;

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

    @GetMapping("/mobileCount")
    public ModelAndView mobileCount(@Param("iSection") String iSection,
                              @Param("iFacility") String iFacility,
                              @Param("iZone") String iZone,
                              @Param("iClient") String iClient) //parse to int if not *
    {
        /*
        StringBuilder locationSb = new StringBuilder();
        if(!(iSection.equals("*") && iFacility.equals("*") && iZone.equals("*"))) {
            System.out.println("Not Equal to *");
        }
        */
        ModelAndView mav = new ModelAndView();
        Iterable<Tasks> taskToCount;
        if(!iClient.equals("*")){
            taskToCount = tasksService.cycleCountIterableTask(Integer.parseInt(iClient));
        } else { taskToCount = tasksService.cycleCountIterableTask(); }
        mav.addObject("taskToCount", taskToCount).setViewName("mobile/mobileCount");

        return mav;
    }
}
