package com.spring.controller;

import com.spring.model.Town;
import com.spring.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/towns")
public class TownController {
    private TownService townService;

    @Autowired
    public TownController(TownService townService) {
        this.townService = townService;
    }

    @GetMapping("/all")
    public String getAllTowns(Model model) {
        List<Town> townList = townService.findAll();
        model.addAttribute("towns", townList);
        return "towns";
    }
}
