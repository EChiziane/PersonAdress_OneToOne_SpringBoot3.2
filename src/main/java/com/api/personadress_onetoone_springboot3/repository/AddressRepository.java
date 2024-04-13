package com.api.personadress_onetoone_springboot3.repository;

import com.api.personadress_onetoone_springboot3.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, UUID> {
}
