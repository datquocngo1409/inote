package com.codegym.inote.service;

import com.codegym.inote.model.INote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface INoteService {
    Page<INote> findAll(Pageable pageable);

    INote findById(Long id);

    void save(INote iNote);

    void remove(Long id);

    Page<INote> findAllByTitle(String s, Pageable pageable);
}
