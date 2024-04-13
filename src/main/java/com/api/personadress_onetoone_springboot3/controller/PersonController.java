package com.api.personadress_onetoone_springboot3.controller;

import com.api.personadress_onetoone_springboot3.dto.PersonDto;
import com.api.personadress_onetoone_springboot3.model.PersonModel;
import com.api.personadress_onetoone_springboot3.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class PersonController {
    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity addPerson(@RequestBody @Valid PersonDto personDto) {
        var PersonModel = new PersonModel();
        BeanUtils.copyProperties(personDto, PersonModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(PersonModel));
    }
}