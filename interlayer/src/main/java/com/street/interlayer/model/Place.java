package com.street.interlayer.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Place {

    private Long id;
    private String name;
    private String description;
    private String address;
    private String photo;
    private List<Review> reviews;
    private Account author;
    private Date createdAt;

}
