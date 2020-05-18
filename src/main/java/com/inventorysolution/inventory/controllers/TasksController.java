package com.inventorysolution.inventory.controllers;

import com.inventorysolution.inventory.model.InvOnHand;
import com.inventorysolution.inventory.model.Tasks;
import com.inventorysolution.inventory.services.service.InvOnHandService;
import com.inventorysolution.inventory.services.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value="/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @RequestMapping(value="/viewAllTasks", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView viewAllTasks(/*Tasks tasks, Model mode, HttpServletRequest request*/){
        System.out.println("Display All Tasks");
        ModelAndView mav = new ModelAndView();
        Iterable<Tasks> allTasks = tasksService.allTasks();
        mav.addObject("allTasks", allTasks).setViewName("tasks");
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
