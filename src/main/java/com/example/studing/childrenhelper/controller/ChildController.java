package com.example.studing.childrenhelper.controller;

import com.example.studing.childrenhelper.converter.ChildConverter;
import com.example.studing.childrenhelper.dto.ChildDto;
import com.example.studing.childrenhelper.service.ChildService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChildController {
    private ChildService childService;
    private ChildConverter childConverter;

    public ChildController(ChildService childService, ChildConverter childConverter) {
        this.childService = childService;
        this.childConverter = childConverter;
    }
    @GetMapping("/children")
    public String findChildren(@RequestParam("exerciseName") String exerciseName, Model model){
        model.addAttribute("children", childService.findChildren(exerciseName));
        return "children";
    }
    @GetMapping
    public String getAddChild(Model model) {
        model.addAttribute("child", new ChildDto());
        return "addChild";
    }
    @PostMapping
    public String addChild(@ModelAttribute ChildDto childDto){
        childService.addChild(childDto);
        return "redirect:/children";
    }
}
