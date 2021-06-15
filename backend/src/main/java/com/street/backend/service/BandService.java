package com.street.backend.service;

import com.street.backend.entity.Band;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface BandService {

    Optional<Band> getBandById(Long id);
    Iterable<Band> getAllBands();
    Band saveBand(Band band);
    void deleteBand(Long id);

}
