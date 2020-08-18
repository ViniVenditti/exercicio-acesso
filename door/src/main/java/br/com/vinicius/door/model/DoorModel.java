package br.com.vinicius.door.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoorModel {

    @JsonProperty("andar")
    private String floor;

    @JsonProperty("sala")
    private String room;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
