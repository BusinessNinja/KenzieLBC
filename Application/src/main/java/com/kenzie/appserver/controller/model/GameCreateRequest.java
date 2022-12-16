package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class GameCreateRequest {

    @NotEmpty
    @JsonProperty("gameId")
    private String gameId;
    @JsonProperty("gameTitle")
    private String gameTitle;



    public String getGameId() {
        return gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }



    public void setGameId(String gameId) { this.gameId = gameId; }

    public void setGameTitle(String gameTitle) { this.gameTitle = gameTitle; }
}
