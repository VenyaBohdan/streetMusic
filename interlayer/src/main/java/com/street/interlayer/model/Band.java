package com.street.interlayer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Band {

    private Long id;
    private String name;
    private String description;
    private String genre;

}
