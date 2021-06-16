package com.street.interlayer.service.impl;

import com.street.interlayer.model.Place;
import com.street.interlayer.service.PlaceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class PlaceServiceImpl implements PlaceService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    private final String PLACE = "place/";

    @Override
    public Place getPlaceById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + PLACE + id, Place.class);
    }

    @Override
    public List<Place> getAllPlaces() {
        RestTemplate restTemplate = new RestTemplate();
        Place[] placeResponse = restTemplate.getForObject(backendServerUrl + PLACE, Place[].class);
        return placeResponse == null ? Collections.emptyList() : Arrays.asList(placeResponse);
    }

    @Override
    public Place savePlace(Place place) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + PLACE, place, Place.class).getBody();
    }

    @Override
    public void deletePlace(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + PLACE + id);
    }
}
