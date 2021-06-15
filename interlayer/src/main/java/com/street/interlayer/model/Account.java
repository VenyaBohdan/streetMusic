package com.street.interlayer.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Admin admin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Band band;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;
    private String login;
    private String password;
    private String email;
    private Date createdAt;
    private Date lastLoginAt;

}
