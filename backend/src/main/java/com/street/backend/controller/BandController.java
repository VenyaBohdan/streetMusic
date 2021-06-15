package com.street.backend.controller;

import com.street.backend.entity.Band;
import com.street.backend.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    Iterable<Band> getAllBands() {
        return bandService.getAllBands();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Band> getBandById(@PathVariable(name = "id") Long id) {
        Optional<Band> band = bandService.getBandById(id);
        if (band.isPresent()) {
            return ResponseEntity.of(band);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    Band saveBand(@RequestBody Band band) {
        return bandService.saveBand(band);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Band> deleteBand(@PathVariable(name = "id") Long id) {
        bandService.deleteBand(id);
        return ResponseEntity.noContent().build();
    }

}
