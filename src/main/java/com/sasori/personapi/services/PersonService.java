package com.sasori.personapi.services;

import com.sasori.personapi.web.model.PersonDto;

import java.util.UUID;

public interface PersonService {
    PersonDto getPersonById(UUID personId);

    PersonDto saveNewPerson(PersonDto personDto);

    void updatePerson(UUID personId, PersonDto personDto);

    void deletePerson(UUID personId);
}
