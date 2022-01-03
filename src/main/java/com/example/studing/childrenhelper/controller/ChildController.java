package com.example.studing.childrenhelper.controller;

import com.example.studing.childrenhelper.converter.ChildConverter;
import com.example.studing.childrenhelper.dto.ChildDto;
import com.example.studing.childrenhelper.service.ChildService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/child")
public class ChildController {
    private ChildService childService;
    private ChildConverter childConverter;

    public ChildController(ChildService childService, ChildConverter childConverter) {
        this.childService = childService;
        this.childConverter = childConverter;
    }
    @GetMapping("/children")
    public String findChildren(@RequestParam(name = "exerciseName", defaultValue = "") String exerciseName, Model model){
       List<ChildDto> children = childService.findChildren(exerciseName);
        model.addAttribute("children", children);
        return "children";
    }
    @GetMapping
    public String getAddChild(Model model) {
        model.addAttribute("childDto", new ChildDto());
        return "addChild";
    }
    @PostMapping
    public String addChild(@ModelAttribute("childDto") ChildDto childDto){
        childService.addChild(childDto);
        return "redirect:/child/children";
    }
}
