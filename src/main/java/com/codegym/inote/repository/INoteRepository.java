package com.codegym.inote.repository;

import com.codegym.inote.model.INote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INoteRepository extends PagingAndSortingRepository<INote, Long> {
    Page<INote> findAllByTitle(String s, Pageable pageable);
}
