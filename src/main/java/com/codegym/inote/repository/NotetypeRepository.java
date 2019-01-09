package com.codegym.inote.repository;

import com.codegym.inote.model.Notetype;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NotetypeRepository extends PagingAndSortingRepository<Notetype, Long> {
}
