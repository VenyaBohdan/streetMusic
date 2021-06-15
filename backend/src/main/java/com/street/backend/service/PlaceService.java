package com.street.backend.service;

import com.street.backend.entity.Place;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PlaceService {

    Iterable<Place> getAllPlaces();
    Optional<Place> getPlaceById(Long id);
    Place savePlace(Place place);
    void deletePlace(Long id);

}
