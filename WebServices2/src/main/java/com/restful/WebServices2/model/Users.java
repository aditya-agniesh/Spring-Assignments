package com.restful.WebServices2.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Represents a User entity in the system")
public class Users {

    @Schema(description = "Unique ID of the user", example = "1")
    private Integer id;

    @Schema(description = "Name of the user", example = "Aditya")
    private String name;

    @Schema(description = "Email of the user", example = "aditya@ttn.com")
    private String email;

    public Users(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
