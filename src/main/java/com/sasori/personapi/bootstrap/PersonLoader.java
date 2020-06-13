package com.sasori.personapi.bootstrap;


import com.sasori.personapi.domain.Person;
import com.sasori.personapi.domain.repositories.PersonRepository;
import com.sasori.personapi.domain.repositories.specs.PersonSpecification;
import com.sasori.personapi.domain.repositories.specs.SearchCriteria;
import com.sasori.personapi.domain.repositories.specs.SearchOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class PersonLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    public PersonLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (personRepository.count() == 0) {
            loadPersonObjects();
        }
    }

    private void loadPersonObjects() {
        // create new persons
        personRepository.saveAll(Arrays.asList(
                new Person("Julian", "Vega", "M", 1.68, 60),
                new Person("Laura ", "Nevsky", "F", 1.74, 84),
                new Person("Ivan", "Ausburgo", "M", 1.93, 96),
                new Person("Miguel", "Romanov", "M", 1.86, 78),
                new Person("Elizabeth", "Romero", "F", 1.78, 66),
                new Person("Ana", "Barbosa", "F", 1.58, 59),
                new Person("Bodis", "Godunov", "M", 1.81, 87),
                new Person("Vasili", "Cabrera", "M", 1.88, 74),
                new Person("Dimitri", "Suarez", "M", 1.74, 84)
        ));

        // Persons by gender
        System.out.println("---search persons by gender`---");
        PersonSpecification psGender = new PersonSpecification();
        psGender.add(new SearchCriteria("gender", "F", SearchOperation.EQUAL));
        List<Person> psList = personRepository.findAll(psGender);
        psList.forEach(System.out::println);

        // Persons that has an e in its name
        System.out.println("---search persons by name`---");
        PersonSpecification psName = new PersonSpecification();
        psName.add(new SearchCriteria("name", "E", SearchOperation.MATCH));
        List<Person> psList1 = personRepository.findAll(psName);
        psList1.forEach(System.out::println);

        // Persons that has an e in its name and weight > 70
        System.out.println("---Persons that has an e in its name and weight > 70---");
        PersonSpecification psNameAndWeight = new PersonSpecification();
        psNameAndWeight.add(new SearchCriteria("name", "E", SearchOperation.MATCH));
        psNameAndWeight.add(new SearchCriteria("weight", 70, SearchOperation.GREATER_THAN));
        List<Person> psList2 = personRepository.findAll(psNameAndWeight);
        psList2.forEach(System.out::println);


        // Persons height < 1.80 ordered by name
        System.out.println("---Persons height < 1.80 ordered by name---");
        PersonSpecification psHeightSortName = new PersonSpecification();
        psHeightSortName.add(new SearchCriteria("height", 1.80, SearchOperation.LESS_THAN_EQUAL));
        List<Person> psList3 = personRepository.findAll(psHeightSortName, Sort.by("name"));
        psList3.forEach(System.out::println);

        // search persons by lastname <> 'vega' and paginate results
        System.out.println("--- search persons by lastname <> 'vega' and paginate results---");
        PersonSpecification msLastName = new PersonSpecification();
        msLastName.add(new SearchCriteria("lastName", "vega", SearchOperation.NOT_EQUAL));

        Pageable pageable = PageRequest.of(0, 3, Sort.by("weight").descending());
        Page<Person> msPersonList = personRepository.findAll(msLastName, pageable);

        msPersonList.forEach(System.out::println);
    }
}