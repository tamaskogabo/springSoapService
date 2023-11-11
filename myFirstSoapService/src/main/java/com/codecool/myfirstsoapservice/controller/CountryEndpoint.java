package com.codecool.myfirstsoapservice.controller;

import com.codecool.myfirstsoapservice.service.CountryService;
import io.spring.guides.gs_producing_web_service.PostCountryRequest;
import io.spring.guides.gs_producing_web_service.PostCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryService.getCountryByName(request.getName()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postCountryRequest")
    @ResponsePayload
    public PostCountryResponse postCountry(@RequestPayload PostCountryRequest request) {
        PostCountryResponse response = new PostCountryResponse();
        countryService.saveCountry(request);
        response.setResponse("Country saved");

        return response;
    }

}
