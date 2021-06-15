package com.street.backend.service.impl;

import com.street.backend.entity.Band;
import com.street.backend.repository.BandRepository;
import com.street.backend.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BandServiceImpl implements BandService {

    @Autowired
    private BandRepository bandRepository;

    public Optional<Band> getBandById(Long id) {
        return bandRepository.findById(id);
    }

    public Iterable<Band> getAllBands() {
        return bandRepository.findAll();
    }

    public Band saveBand(Band band) {
        return bandRepository.save(band);
    }

    public void deleteBand(Long id) {
        bandRepository.deleteById(id);
    }

}
