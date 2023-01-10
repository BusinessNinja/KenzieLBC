package com.kenzie.appserver.service.model;

public class Game {
    private final String gameId;
    private String gameTitle;
    private String genre;
    private String weightOfGame;
    private String conditionOfGame;
    private String maturityLevel;
    private Integer numberOfPlayers;
    private Integer playtimeInMinutes;
    private String tags;

    public Game(String gameId, String gameTitle, String genre, String weightOfGame, String conditionOfGame, String maturityLevel, Integer numberOfPlayers, Integer playtimeInMinutes, String tags) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.genre = genre;
        this.weightOfGame = weightOfGame;
        this.conditionOfGame = conditionOfGame;
        this.maturityLevel = maturityLevel;
        this.numberOfPlayers = numberOfPlayers;
        this.playtimeInMinutes = playtimeInMinutes;
        this.tags = tags;
    }

    public String getGameId() {
        return this.gameId;
    }

    public String getGameTitle() {
        return this.gameTitle;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getWeightOfGame() {
        return this.weightOfGame;
    }

    public String getConditionOfGame() {
        return this.conditionOfGame;
    }

    public String getMaturityLevel() {
        return this.maturityLevel;
    }

    public Integer getNumberOfPlayers() {
        return this.numberOfPlayers;
    }

    public Integer getPlaytimeInMinutes() {
        return this.playtimeInMinutes;
    }

    public String getTags() {
        return this.tags;
    }


}