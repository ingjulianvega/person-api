package com.sasori.personapi.services;

import com.sasori.personapi.domain.Person;
import com.sasori.personapi.domain.repositories.PersonRepository;
import com.sasori.personapi.web.mappers.PersonMapper;
import com.sasori.personapi.web.model.GenderEnum;
import com.sasori.personapi.web.model.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonDto getPersonById(UUID personId) {
        log.debug("getting a person...");
        Optional<Person> optionalPerson = personRepository.findById(personId);
        if (optionalPerson.isPresent()) {
            return personMapper.personToPersonDto(optionalPerson.get());
        } else {
            return PersonDto
                    .builder()
                    .id(UUID.randomUUID())
                    .name("Julian")
                    .gender(GenderEnum.M)
                    .build();
        }
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
