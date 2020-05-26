package com.sasori.personapi.web.mappers;

import com.sasori.personapi.domain.Person;
import com.sasori.personapi.web.model.PersonDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface PersonMapper {
    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);
}
