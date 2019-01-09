package com.codegym.inote.controller;

import com.codegym.inote.model.INote;
import com.codegym.inote.model.Notetype;
import com.codegym.inote.service.INoteService;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoteController {

    @Autowired
    private INoteService iNoteService;

    @Autowired
    private NotetypeService notetypeService;

    @ModelAttribute("notetypes")
    public Iterable<Notetype> notetypes(){
        return notetypeService.findAll();
    }

    @GetMapping("/index")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("inote/list");
        Page<INote> iNotes = iNoteService.findAll(pageable);
        modelAndView.addObject("iNotes", iNotes);
//        Iterable<INote> iNotes = iNoteService.findAll();
//        modelAndView.addObject("iNotes", iNotes);
        return modelAndView;
    }

    @GetMapping("/create-inote")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("inote/create");
        modelAndView.addObject("iNote", new INote());
        return modelAndView;
    }

    @PostMapping("/create-inote")
    public ModelAndView createINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.save(iNote);
        ModelAndView modelAndView = new ModelAndView("inote/create", "mess", "INote Created!");
        modelAndView.addObject("iNote", new INote());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        INote iNote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("inote/edit", "iNote", iNote);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView editINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.save(iNote);
        ModelAndView modelAndView = new ModelAndView("inote/edit");
        modelAndView.addObject("iNote", iNote);
        modelAndView.addObject("mess", "Edited!");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        INote iNote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("inote/delete");
        modelAndView.addObject("iNote", iNote);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteINote(@ModelAttribute("iNote") INote iNote){
        iNoteService.remove(iNote.getId());
        return "redirect:index";
    }
}
