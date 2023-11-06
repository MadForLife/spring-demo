package com.spring.controller;

import com.spring.model.Minion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.service.MinionService;

import java.util.List;

@Controller
@RequestMapping("/minions")
public class MinionController {
    private MinionService minionService;

    @Autowired
    public MinionController(MinionService minionService) {
        this.minionService = minionService;
    }

    @GetMapping("/all")
    public String getAllMinions(Model model) {
        List<Minion> minionList = minionService.findAll();
        model.addAttribute("minions", minionList);
        return "minions";
    }

}
