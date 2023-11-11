package com.codecool.myfirstsoapservice.repository;

import com.codecool.myfirstsoapservice.model.Country;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        countries.put("Spain", Country.of(
                "Spain",
                46704314,
                "EUR",
                "Madrid")
        );
        countries.put("Poland", Country.of(
                "Poland",
                38186860,
                "PLN",
                "Warsaw")
        );
        countries.put("United Kingdom", Country.of(
                "United Kingdom",
                63705000,
                "GBP",
                "London")
        );
    }
}
