package com.street.interlayer.service;

import com.street.interlayer.model.Place;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlaceService {

    Place getPlaceById(Long id);
    List<Place> getAllPlaces();
    Place savePlace(Place place);
    void deletePlace(Long id);

}
