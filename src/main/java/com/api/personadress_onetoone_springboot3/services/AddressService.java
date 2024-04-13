package com.api.personadress_onetoone_springboot3.services;

import com.api.personadress_onetoone_springboot3.model.AddressModel;
import com.api.personadress_onetoone_springboot3.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AddressService {
    final private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public AddressModel addAddress(AddressModel address) {
        return addressRepository.save(address);
    }

    public List<AddressModel> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Optional<AddressModel> getAddressById(UUID id) {
        return addressRepository.findById(id);
    }

    public AddressModel updateAddress(AddressModel address) {
        return addressRepository.save(address);
    }

    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }
}
