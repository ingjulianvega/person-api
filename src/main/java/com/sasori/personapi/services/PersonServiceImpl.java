package com.sasori.personapi.services;

import com.sasori.personapi.web.model.GenderEnum;
import com.sasori.personapi.web.model.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public PersonDto getPersonById(UUID personId) {
        log.debug("getting a person...");
        return PersonDto
                .builder()
                .id(UUID.randomUUID())
                .name("Julian")
                .gender(GenderEnum.MALE)
                .build();
    }

    @Override
    public PersonDto saveNewPerson(PersonDto personDto) {
        return PersonDto
                .builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updatePerson(UUID personId, PersonDto personDto) {
        log.debug("Updating a person...");
    }

    @Override
    public void deletePerson(UUID personId) {
        log.debug("deleting a person...");
    }
}
