package com.codegym.inote.controller;

import com.codegym.inote.model.INote;
import com.codegym.inote.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoteController {

    @Autowired
    private INoteService iNoteService;

    @GetMapping("/index")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("list", "iNotes", iNoteService.findAll());
//        Iterable<INote> iNotes = iNoteService.findAll();
//        modelAndView.addObject("iNotes", iNotes);
        return modelAndView;
    }

    @GetMapping("/create-inote")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("iNote", new INote());
        return modelAndView;
    }

    @PostMapping("/create-inote")
    public ModelAndView createINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.save(iNote);
        ModelAndView modelAndView = new ModelAndView("create", "mess", "INote Created!");
        modelAndView.addObject("iNote", new INote());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        INote iNote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit", "iNote", iNote);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.save(iNote);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("iNote", iNote);
        modelAndView.addObject("mess", "Edited!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        INote iNote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("iNote", iNote);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.remove(iNote.getId());
        return "redirect:index";
    }
}
