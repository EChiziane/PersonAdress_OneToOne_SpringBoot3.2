package com.api.personadress_onetoone_springboot3.repository;

import com.api.personadress_onetoone_springboot3.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonModel, UUID> {
}
