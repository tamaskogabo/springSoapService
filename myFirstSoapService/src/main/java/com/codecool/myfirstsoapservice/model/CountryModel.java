package com.codecool.myfirstsoapservice.model;

import io.spring.guides.gs_producing_web_service.Currency;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "country")
public class CountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String capital;
    private Currency currency;
    private int population;
}
