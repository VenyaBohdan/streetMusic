package com.street.interlayer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Wallet {

    private String id;
    @JsonProperty("owner")
    private Long ownerId;
    private Account account;
    private Double amount;
    private List<Transaction> transactions;

}
