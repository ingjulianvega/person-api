package com.sasori.personapi.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PersonPagedList extends PageImpl<PersonDto> {
    public PersonPagedList(List<PersonDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public PersonPagedList(List<PersonDto> content) {
        super(content);
    }
}
