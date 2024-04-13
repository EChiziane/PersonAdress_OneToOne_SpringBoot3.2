package com.api.personadress_onetoone_springboot3.controller;

import com.api.personadress_onetoone_springboot3.dto.PersonDto;
import com.api.personadress_onetoone_springboot3.model.PersonModel;
import com.api.personadress_onetoone_springboot3.services.AddressService;
import com.api.personadress_onetoone_springboot3.services.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/person")
public class PersonController {
    final private PersonService personService;
    final private AddressService addressService;

    public PersonController(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity addPerson(@RequestBody PersonDto personDto) {
        var PersonModel = new PersonModel();
        var address = addressService.getAddressById(personDto.getAddressId());
        if (address.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address not found");
        }
        PersonModel.setAddress(address.get());
        BeanUtils.copyProperties(personDto, PersonModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(PersonModel));
    }

    @GetMapping
    public ResponseEntity GetAllPersons() {
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    @GetMapping("/{id}")
    public ResponseEntity GetPersonById(@PathVariable UUID id) {
        if (personService.getPersonById(id).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person found with id " + id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id).get());
    }

    @DeleteMapping("/{}")
    public ResponseEntity DeletePersonById(@PathVariable UUID id) {
        if (personService.getPersonById(id).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person found with id " + id);
        }
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted person with id " + id);
    }

}