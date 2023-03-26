package com.example.picture_management1.controller;

import com.example.picture_management1.model.Picture;
import com.example.picture_management1.service.ICoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private ICoreService<Picture> iCoreService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("picture/list");
        modelAndView.addObject("pictures", iCoreService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("picture", new Picture());
        return "picture/create";
    }

    @PostMapping
    public String createPicture(@ModelAttribute Picture picture) {
        iCoreService.save(picture);
        return "redirect:/pictures";
    }

    @GetMapping("/update/{id}")
    public String updateForm(Model model, @PathVariable Long id) {
        model.addAttribute("picture", iCoreService.findById(id));
        return "picture/update";
    }

    @PostMapping("/update")
    public String updatePicture(@ModelAttribute Picture picture) {
        iCoreService.save(picture);
        return "redirect:/pictures";
    }

    @GetMapping("/delete/{id}")
    public String deletePicture(@PathVariable Long id) {
        iCoreService.delete(id);
        return "redirect:/pictures";
    }

    @GetMapping("/detail/{id}")
    public String search(@PathVariable Long id,Model model){
        model.addAttribute("pictures", iCoreService.findById(id));
        return "picture/detail";
    }
}
