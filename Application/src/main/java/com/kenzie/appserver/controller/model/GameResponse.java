package com.kenzie.appserver.controller.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameResponse {
    @JsonProperty("gameId")
    private String gameId;
    @JsonProperty("gameTitle")
    private String gameTitle;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("weightOfGame")
    private String weightOfGame;
    @JsonProperty("conditionOfGame")
    private String conditionOfGame;
    @JsonProperty("maturityLevel")
    private String maturityLevel;
    @JsonProperty("numberOfPlayers")
    private Integer numberOfPlayers;
    @JsonProperty("playtimeInMinutes")
    private Integer playtimeInMinutes;
    @JsonProperty("tags")
    private String tags;


    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWeightOfGame() {
        return weightOfGame;
    }

    public void setWeightOfGame(String weightOfGame) {
        this.weightOfGame = weightOfGame;
    }

    public String getConditionOfGame() {
        return conditionOfGame;
    }

    public void setConditionOfGame(String conditionOfGame) {
        this.conditionOfGame = conditionOfGame;
    }

    public String getMaturityLevel() {
        return maturityLevel;
    }

    public void setMaturityLevel(String maturityLevel) {
        this.maturityLevel = maturityLevel;
    }

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getPlaytimeInMinutes() {
        return playtimeInMinutes;
    }

    public void setPlaytimeInMinutes(Integer playtimeInMinutes) {
        this.playtimeInMinutes = playtimeInMinutes;
    }

    public String getTags() { return tags; }

    public void setTags(String tags) { this.tags = tags; }
}
