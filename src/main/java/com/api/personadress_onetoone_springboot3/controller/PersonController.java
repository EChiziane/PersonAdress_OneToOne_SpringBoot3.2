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

    private final PersonService personService;
    private final AddressService addressService;

    // Constructor injection for PersonService and AddressService
    public PersonController(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    // Endpoint to add a new person
    @PostMapping
    public ResponseEntity addPerson(@RequestBody PersonDto personDto) {
        // Create a new PersonModel object
        PersonModel personModel = new PersonModel();

        // Retrieve address by ID
        var address = addressService.getAddressById(personDto.getAddressId());
        if (address.isEmpty()) {
            // Return BAD_REQUEST status if address not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Address not found");
        }
        // Set the address for the person
        personModel.setAddress(address.get());

        // Copy properties from PersonDto to PersonModel
        BeanUtils.copyProperties(personDto, personModel);

        // Add the person and return CREATED status with the added person
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.addPerson(personModel));
    }

    // Endpoint to get all persons
    @GetMapping
    public ResponseEntity getAllPersons() {
        // Return OK status with all persons
        return ResponseEntity.status(HttpStatus.OK).body(personService.getAllPersons());
    }

    // Endpoint to get a person by ID
    @GetMapping("/{id}")
    public ResponseEntity getPersonById(@PathVariable UUID id) {
        // Retrieve the person by ID
        var personOptional = personService.getPersonById(id);
        if (personOptional.isEmpty()) {
            // Return NOT_FOUND status if person not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person found with id " + id);
        }
        // Return OK status with the found person
        return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
    }

    // Endpoint to delete a person by ID
    @DeleteMapping("/{id}")
    public ResponseEntity deletePersonById(@PathVariable UUID id) {
        // Retrieve the person by ID
        var personOptional = personService.getPersonById(id);
        if (personOptional.isEmpty()) {
            // Return NOT_FOUND status if person not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No person found with id " + id);
        }
        // Delete the person and return NO_CONTENT status
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted person with id " + id);
    }
}
