package com.codegym.inote.service.impl;

import com.codegym.inote.model.Notetype;
import com.codegym.inote.repository.NotetypeRepository;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NotetypeServiceImpl implements NotetypeService {
    @Autowired
    NotetypeRepository notetypeRepository;
    @Override
    public Iterable<Notetype> findAll() {
        return notetypeRepository.findAll();
    }

    @Override
    public Notetype findById(Long id) {
        return notetypeRepository.findById(id).get();
    }

    @Override
    public void save(Notetype notetype) {
        notetypeRepository.save(notetype);
    }

    @Override
    public void remove(Long id) {
        notetypeRepository.delete(findById(id));
    }
}
