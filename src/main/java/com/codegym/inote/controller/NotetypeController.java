package com.codegym.inote.controller;

import com.codegym.inote.model.INote;
import com.codegym.inote.model.Notetype;
import com.codegym.inote.service.INoteService;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotetypeController {
    @Autowired
    private NotetypeService notetypeService;

    @GetMapping("/notetypes")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("notetype/list", "notetypes", notetypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create-notetype")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("notetype/create");
        modelAndView.addObject("notetype", new Notetype());
        return modelAndView;
    }

    @PostMapping("/create-notetype")
    public ModelAndView createINote(@ModelAttribute("notetype") Notetype notetype){
        notetypeService.save(notetype);
        ModelAndView modelAndView = new ModelAndView("notetype/create", "mess", "Notetype Created!");
        modelAndView.addObject("notetype", new Notetype());
        return modelAndView;
    }

    @GetMapping("/edit-notetype/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Notetype notetype = notetypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("notetype/edit", "notetype", notetype);
        return modelAndView;
    }

    @PostMapping("/edit-notetype/{id}")
    public ModelAndView editINote(@ModelAttribute("notetype") Notetype notetype){
        notetypeService.save(notetype);
        ModelAndView modelAndView = new ModelAndView("notetype/edit");
        modelAndView.addObject("notetype", notetype);
        modelAndView.addObject("mess", "Edited!");
        return modelAndView;
    }

    @GetMapping("/delete-notetype/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Notetype notetype = notetypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("notetype/delete");
        modelAndView.addObject("notetype", notetype);
        return modelAndView;
    }

    @PostMapping("/delete-notetype")
    public String deleteINote(@ModelAttribute("notetype") Notetype notetype){
        notetypeService.remove(notetype.getId());
        return "redirect:notetypes";
    }
}
