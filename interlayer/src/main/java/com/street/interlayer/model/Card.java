package com.street.interlayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Card {

    private String id;
    @JsonProperty("owner")
    private Long ownerId;
    private Account account;
    private String number;
    private String exp_date;
    private String name;

}
