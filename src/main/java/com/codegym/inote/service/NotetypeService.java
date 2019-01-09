package com.codegym.inote.service;

import com.codegym.inote.model.INote;
import com.codegym.inote.model.Notetype;

public interface NotetypeService {
    Iterable<Notetype> findAll();

    Notetype findById(Long id);

    void save(Notetype notetype);

    void remove(Long id);
}
