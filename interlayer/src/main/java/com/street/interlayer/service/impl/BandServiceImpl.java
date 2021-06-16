package com.street.interlayer.service.impl;

import com.street.interlayer.model.Band;
import com.street.interlayer.service.BandService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class BandServiceImpl implements BandService {

    @Value("${backend.server.url}")
    private String backendServerUrl;
    private final String BAND = "band/";

    @Override
    public List<Band> getAllBands() {
        RestTemplate restTemplate = new RestTemplate();
        Band[] bandResponse = restTemplate.getForObject(backendServerUrl + BAND, Band[].class);
        return bandResponse == null ? Collections.emptyList() : Arrays.asList(bandResponse);
    }

    @Override
    public Band getBandById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + BAND + id, Band.class);
    }

    @Override
    public Band saveBand(Band band) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + BAND, band, Band.class).getBody();
    }

    @Override
    public void deleteBand(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + BAND + id);
    }
}
