package com.api.personadress_onetoone_springboot3.services;

import com.api.personadress_onetoone_springboot3.model.PersonModel;
import com.api.personadress_onetoone_springboot3.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PersonService {
    final private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonModel addPerson(PersonModel personModel) {
        return personRepository.save(personModel);
    }

    public List<PersonModel> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<PersonModel> getPersonById(UUID id) {
        return personRepository.findById(id);
    }

    public void deletePersonById(UUID id) {
        personRepository.deleteById(id);
    }
}
