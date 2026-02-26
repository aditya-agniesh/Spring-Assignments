package com.example.spring_data_jpa_3.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Address {

    private String streetNumber;
    private String location;
    private String state;

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setState(String state) {
        this.state = state;
    }
}
