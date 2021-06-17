package com.street.backend.controller;

import com.street.backend.entity.Band;
import com.street.backend.repository.BandRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class BandControllerIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    BandRepository bandRepository;

    @AfterEach
    public void resetDB() {
        bandRepository.deleteAll();
    }

    @Test
    public void whenCreatedBand_thenStatus200() {
        Band band = new Band("TestName", "TestDescription", "TestGenre");

        ResponseEntity<Band> response = restTemplate.postForEntity("/band", band, Band.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody().getId(), notNullValue());
        assertThat(response.getBody().getName(), is("TestName"));
    }

    @Test
    public void givenPerson_whenGetPerson_thenStatus200() {
        Long id = createBand("Venya").getId();

        Band band = restTemplate.getForObject("/band/" + id, Band.class);
        assertThat(band.getName(), is("Venya"));
        assertThat(band.getDescription(), is("baseDescription"));
    }

    @Test
    public void givenPerson_whenDeletePersonAndThenGetPerson_thenStatus404() {
        Long id = createBand("Nick").getId();

        restTemplate.delete("/band/" + id);
        ResponseEntity<Band> response = restTemplate.getForEntity("/band/" + id, Band.class);

        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));
    }

    private Band createBand(String name) {
        Band band = new Band(name, "baseDescription", "baseGenre");
        return bandRepository.save(band);
    }

}
