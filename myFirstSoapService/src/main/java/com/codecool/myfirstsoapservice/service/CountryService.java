package com.codecool.myfirstsoapservice.service;

import com.codecool.myfirstsoapservice.model.CountryModel;
import com.codecool.myfirstsoapservice.repository.CountryJPARepository;
import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.PostCountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryJPARepository repository;

    @Autowired
    public CountryService(CountryJPARepository repository) {
        this.repository = repository;
    }

    public Country getCountryByName(String name) {
        Optional<CountryModel> countryModel = repository.findByName(name);
        if (countryModel.isPresent()) {
            CountryModel countryToMap = countryModel.get();
            Country countryToSend = new Country();
            countryToSend.setName(countryToMap.getName());
            countryToSend.setCapital(countryToMap.getCapital());
            countryToSend.setCurrency(countryToMap.getCurrency());
            countryToSend.setPopulation(countryToMap.getPopulation());
            return countryToSend;
        }
        return null;
    }

    public void saveCountry(PostCountryRequest request) {
        CountryModel toSave = new CountryModel();
        toSave.setName(request.getName());
        toSave.setCapital(request.getCapital());
        toSave.setPopulation(request.getPopulation());
        toSave.setCurrency(request.getCurrency());
        repository.save(toSave);
    }
}
