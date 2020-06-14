package com.sasori.personapi.web.controller;

import com.sasori.personapi.services.PersonService;
import com.sasori.personapi.web.model.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/person")
public class PersonController implements Person {
    private final PersonService personService;

    @Override
    public ResponseEntity<PersonDto> getPerson(@NotNull UUID personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity saveNewPerson(@NotNull @Valid PersonDto PersonDto) {
        return new ResponseEntity<>(personService.saveNewPerson(PersonDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity updatePerson(@NotNull UUID personId, @NotNull @Valid PersonDto PersonDto) {
        return new ResponseEntity(personService.updatePerson(personId, PersonDto),HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity deletePerson(@NotNull UUID personId) {
        personService.deletePerson(personId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
