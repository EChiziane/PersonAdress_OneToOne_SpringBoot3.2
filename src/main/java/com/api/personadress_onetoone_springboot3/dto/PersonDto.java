package com.api.personadress_onetoone_springboot3.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class PersonDto {
    @NotBlank
    private String name;
    @NotBlank
    private UUID addressId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getAddressId() {
        return addressId;
    }

    public void setAddressId(UUID addressId) {
        this.addressId = addressId;
    }
}
