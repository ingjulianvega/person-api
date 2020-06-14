package com.sasori.personapi.services;

import com.sasori.personapi.domain.Person;
import com.sasori.personapi.domain.repositories.PersonRepository;
import com.sasori.personapi.web.controller.NotFoundException;
import com.sasori.personapi.web.mappers.PersonMapper;
import com.sasori.personapi.web.model.PersonDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto getPersonById(UUID personId) {
        log.debug("getting a person...");
        return personMapper.personToPersonDto(
                personRepository.findById(personId).orElseThrow(NotFoundException::new));
    }

    @Override
    public PersonDto saveNewPerson(PersonDto personDto) {
        log.debug("Saving a person...");
        return personMapper.personToPersonDto(
                personRepository.save(personMapper.personDtoToPerson(personDto)));
    }

    @Override
    public PersonDto updatePerson(UUID personId, PersonDto personDto) {
        log.debug("Updating a person...");
        Person person = personRepository.findById(personId).orElseThrow(NotFoundException::new);
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        person.setGender(personDto.getGender().toString());
        person.setHeight(personDto.getHeight());
        person.setWeight(personDto.getWeight());

        return personMapper.personToPersonDto(
                personRepository.save(personMapper.personDtoToPerson(personDto)));
    }

    @Override
    public void deletePerson(UUID personId) {
        log.debug("deleting a person...");
        personRepository.deleteById(personId);
    }
}
