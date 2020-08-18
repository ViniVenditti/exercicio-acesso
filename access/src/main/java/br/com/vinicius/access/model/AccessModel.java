package br.com.vinicius.access.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessModel {

    @JsonProperty("cliente_id")
    private Long clientId;

    @JsonProperty("porta_id")
    private Long doorId;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getDoorId() {
        return doorId;
    }

    public void setDoorId(Long doorId) {
        this.doorId = doorId;
    }
}
