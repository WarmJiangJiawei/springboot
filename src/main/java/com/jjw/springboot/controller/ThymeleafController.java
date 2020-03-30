package com.jjw.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    @RequestMapping("/testThymeleaf")
    public String testThymeleaf(ModelMap modelMap) {
        System.out.println("/////");
        modelMap.addAttribute("name", "jjw");
        return "testThymeleaf";
    }
}
