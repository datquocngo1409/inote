package com.codegym.inote.service.impl;

import com.codegym.inote.model.INote;
import com.codegym.inote.repository.INoteRepository;
import com.codegym.inote.service.INoteService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class INoteServiceImpl implements INoteService {

    @Autowired
    INoteRepository iNoteRepository;

    @Override
    public Page<INote> findAll(Pageable pageable) {
        return iNoteRepository.findAll(pageable);
    }

    @Override
    public INote findById(Long id) {
        return iNoteRepository.findById(id).get();
    }

    @Override
    public void save(INote iNote) {
        iNoteRepository.save(iNote);
    }

    @Override
    public void remove(Long id) {
        iNoteRepository.deleteById(id);
    }
}
