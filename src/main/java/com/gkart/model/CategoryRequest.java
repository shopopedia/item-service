package com.gkart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {

    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryRequest{" + "name='" + name + '\'' + '}';
    }
}
