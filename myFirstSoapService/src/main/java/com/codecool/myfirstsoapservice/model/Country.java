package com.codecool.myfirstsoapservice.model;

public class Country {
    private final String name;
    private final int population;
    private final String currency;
    private final String capital;

    public static Country of(String name, int population, String currency, String capital) {
        return new Country(name, population, currency, capital);
    }

    private Country(String name, int population, String currency, String capital) {
        this.name = name;
        this.population = population;
        this.currency = currency;
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", currency=" + currency +
                ", capital='" + capital + '\'' +
                '}';
    }
}
