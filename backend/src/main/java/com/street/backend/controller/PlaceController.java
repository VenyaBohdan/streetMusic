package com.street.backend.controller;

import com.street.backend.entity.Place;
import com.street.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Place> getPlaceById(@PathVariable Long id) {
        Optional<Place> place = placeService.getPlaceById(id);
        if (place.isPresent()) {
            return ResponseEntity.of(place);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
