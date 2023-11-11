package com.codecool.myfirstsoapservice.repository;

import com.codecool.myfirstsoapservice.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryJPARepository extends JpaRepository<CountryModel, Long> {
    public Optional<CountryModel> findByName(String name);

}
