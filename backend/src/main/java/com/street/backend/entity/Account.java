package com.street.backend.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Admin admin;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Band band;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private User user;

    private String login;
    private String password;
    private String email;
    private Date createdAt;
    private Date lastLoginAt;

}
