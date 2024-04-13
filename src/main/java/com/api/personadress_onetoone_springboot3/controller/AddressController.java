package com.api.personadress_onetoone_springboot3.controller;

import com.api.personadress_onetoone_springboot3.dto.AddressDto;
import com.api.personadress_onetoone_springboot3.model.AddressModel;
import com.api.personadress_onetoone_springboot3.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {

    // Consider renaming AddressController to AddressRestController for clarity

    private final AddressService addressService; // Declare fields at the top of the class

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity addAddress(@RequestBody AddressDto addressDto) {
        AddressModel addressModel = new AddressModel(); // Use camelCase for variable names
        BeanUtils.copyProperties(addressDto, addressModel);
        AddressModel savedAddress = addressService.addAddress(addressModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress); // Return the saved address directly
    }

    @GetMapping
    public ResponseEntity getAllAddresses() { // Method name should be getAllAddresses for consistency
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddressById(@PathVariable UUID id) { // Use @PathVariable instead of @RequestParam
      var addressModel = addressService.getAddressById(id);
        if (addressModel == null) { // Use null check instead of isEmpty()
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such address");
        }
        return ResponseEntity.status(HttpStatus.OK).body(addressModel);
    }

    @DeleteMapping("/{id}") // Specify the path variable for DELETE method
    public ResponseEntity deleteAddressById(@PathVariable UUID id) { // Use @PathVariable instead of @RequestParam
        var addressModel = addressService.getAddressById(id);
        if (addressModel == null) { // Use null check instead of isEmpty()
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such address");
        }
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Address deleted successfully");
    }
}
