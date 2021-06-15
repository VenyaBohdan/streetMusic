package com.street.interlayer.model;

import lombok.Data;

import java.util.Date;

@Data
public class Review {

    private Long id;
    private String title;
    private String description;
    private Account author;
    private Date createdAt;
    private Integer rating;

}
