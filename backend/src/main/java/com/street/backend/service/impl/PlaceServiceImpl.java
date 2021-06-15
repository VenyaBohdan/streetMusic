package com.street.backend.service.impl;

import com.street.backend.entity.Band;
import com.street.backend.entity.Place;
import com.street.backend.repository.BandRepository;
import com.street.backend.repository.PlaceRepository;
import com.street.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    public Optional<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    public Iterable<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place savePlace(Place place) {
        return placeRepository.save(place);
    }

    public void deletePlace(Long id) {
        placeRepository.deleteById(id);
    }

}
