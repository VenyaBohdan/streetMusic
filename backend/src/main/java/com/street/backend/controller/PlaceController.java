package com.street.backend.controller;

import com.street.backend.entity.Place;
import com.street.backend.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }

}
