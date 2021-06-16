package com.street.interlayer.controller;

import com.street.interlayer.model.Place;
import com.street.interlayer.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> getAllCards() {
        List<Place> places = placeService.getAllPlaces();
        return ResponseEntity.ok(places);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Place> getPlaceById(@PathVariable String id) {
        return ResponseEntity.ok(placeService.getPlaceById(Long.valueOf(id)));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Place> savePlace(@RequestBody Place place) {
        if (place != null) {
            return ResponseEntity.ok(placeService.savePlace(place));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        placeService.deletePlace(Long.valueOf(id));
    }

}
