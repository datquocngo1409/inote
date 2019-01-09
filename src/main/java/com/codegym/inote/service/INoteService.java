package com.codegym.inote.service;

import com.codegym.inote.model.INote;

public interface INoteService {
    Iterable<INote> findAll();

    INote findById(Long id);

    void save(INote iNote);

    void remove(Long id);
}
