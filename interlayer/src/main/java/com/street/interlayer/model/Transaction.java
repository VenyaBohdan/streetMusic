package com.street.interlayer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Transaction {

    private String id;
    @JsonProperty("author")
    private Long authorId;
    private Account account;
    private Double amount;
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String recipientWallet;

}
