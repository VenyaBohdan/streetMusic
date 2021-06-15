package com.street.interlayer.service;

import com.street.interlayer.model.Band;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BandService {

    List<Band> getAllBands();
    Band getBandById(Long id);
    Band saveBand(Band band);
    void deleteBand(Long id);

}
