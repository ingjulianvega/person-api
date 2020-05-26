package com.sasori.personapi.web.controller;

import com.sasori.personapi.services.PersonService;
import com.sasori.personapi.web.model.PersonDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getBeer(@PathVariable("personId") UUID personId) {
        return new ResponseEntity<>(personService.getPersonById(personId), HttpStatus.OK);
    }


    @PostMapping //POST - create e new beer
    public ResponseEntity handlePost(@Valid @RequestBody PersonDto PersonDto) {
        PersonDto savedDto = personService.saveNewPerson(PersonDto);
        HttpHeaders headers = new HttpHeaders();
        //TODO Add hostname to url
        headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{personId}"})
    public ResponseEntity handleUpdate(@PathVariable("personId") UUID personId,
                                       @Valid @RequestBody PersonDto PersonDto) {
        personService.updatePerson(personId, PersonDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{personId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("personId") UUID personId) {
        personService.deletePerson(personId);
    }
}
