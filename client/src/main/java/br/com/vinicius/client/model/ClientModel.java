package br.com.vinicius.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientModel {

    @JsonProperty("nome")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
