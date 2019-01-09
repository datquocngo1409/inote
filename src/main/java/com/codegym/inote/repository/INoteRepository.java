package com.codegym.inote.repository;

import com.codegym.inote.model.INote;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INoteRepository extends PagingAndSortingRepository<INote, Long> {
}
