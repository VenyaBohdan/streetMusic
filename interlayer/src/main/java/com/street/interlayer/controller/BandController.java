package com.street.interlayer.controller;

import com.street.interlayer.model.Band;
import com.street.interlayer.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/band")
public class BandController {

    @Autowired
    private BandService bandService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Band>> getAllBands() {
        return ResponseEntity.ok(bandService.getAllBands());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Band> getBandById(@PathVariable String id) {
        return ResponseEntity.ok(bandService.getBandById(Long.valueOf(id)));
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Band> saveBand(@RequestBody Band band) {
        if (band != null) {
            return ResponseEntity.ok(bandService.saveBand(band));
        }
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBand(@PathVariable String id) {
        bandService.deleteBand(Long.valueOf(id));
    }

}
