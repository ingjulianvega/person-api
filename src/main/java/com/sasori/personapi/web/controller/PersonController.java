package com.sasori.personapi.web.controller;

import com.sasori.personapi.services.PersonService;
import com.sasori.personapi.web.model.PersonDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController implements Person {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public ResponseEntity<PersonDto> getPerson(@NotNull UUID personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity handlePost(@NotNull @Valid PersonDto PersonDto) {
        PersonDto savedDto = personService.saveNewPerson(PersonDto);
        HttpHeaders headers = new HttpHeaders();
        //TODO Add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity handleUpdate(@NotNull UUID personId, @NotNull @Valid PersonDto PersonDto) {
        personService.updatePerson(personId, PersonDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public void deletePerson(@NotNull UUID personId) {
        personService.deletePerson(personId);
    }
}
