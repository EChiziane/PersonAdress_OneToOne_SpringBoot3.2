package com.api.personadress_onetoone_springboot3.controller;


import com.api.personadress_onetoone_springboot3.dto.AddressDto;
import com.api.personadress_onetoone_springboot3.model.AddressModel;
import com.api.personadress_onetoone_springboot3.services.AddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/address")
public class AddressController {
    final private AddressService addressService;


    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity addAddress(@RequestBody AddressDto addressDto) {
        var AddressModel = new AddressModel();
        BeanUtils.copyProperties(addressDto, AddressModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.addAddress(AddressModel));
    }
}
