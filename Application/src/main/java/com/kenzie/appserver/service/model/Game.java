package com.kenzie.appserver.service.model;

public class Game {
    private final String gameId;
    private final String gameTitle;
    private final String genre;
    private final String weightOfGame;
    private final String conditionOfGame;
    private final String maturityLevel;
    private final Integer numberOfPlayers;
    private final Integer playtimeInMinutes;

    public Game(String gameId, String gameTitle, String genre, String weightOfGame, String conditionOfGame, String maturityLevel, Integer numberOfPlayers, Integer playtimeInMinutes) {
        this.gameId = gameId;
        this.gameTitle = gameTitle;
        this.genre = genre;
        this.weightOfGame = weightOfGame;
        this.conditionOfGame = conditionOfGame;
        this.maturityLevel = maturityLevel;
        this.numberOfPlayers = numberOfPlayers;
        this.playtimeInMinutes = playtimeInMinutes;
    }

    public String getGameId() { return this.gameId; }

    public String getGameTitle() { return this.gameTitle; }

    public String getGenre() { return this.genre; }

    public String getWeightOfGame() { return this.weightOfGame; }

    public String getConditionOfGame() { return this.conditionOfGame; }

    public String getMaturityLevel() { return this.maturityLevel; }

    public Integer getNumberOfPlayers() { return this.numberOfPlayers; }

    public Integer getPlaytimeInMinutes() { return this.playtimeInMinutes; }
}
