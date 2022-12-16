package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Games")
public class GameRecord {
    private String gameId;
    private String gameTitle;
    private String genre;
    private String weightOfGame;
    private String conditionOfGame;
    private String maturityLevel;
    private Integer numberOfPlayers;
    private Integer playtimeInMinutes;

    @DynamoDBHashKey(attributeName = "gameId")
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    @DynamoDBRangeKey(attributeName = "gameTitle")
    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    @DynamoDBAttribute(attributeName = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @DynamoDBAttribute(attributeName = "weightOfGame")
    public String getWeightOfGame() {
        return weightOfGame;
    }

    public void setWeightOfGame(String weightOfGame) {
        this.weightOfGame = weightOfGame;
    }

    @DynamoDBAttribute(attributeName = "conditionOfGame")
    public String getConditionOfGame() {
        return conditionOfGame;
    }

    public void setConditionOfGame(String conditionOfGame) {
        this.conditionOfGame = conditionOfGame;
    }

    @DynamoDBAttribute(attributeName = "maturityLevel")
    public String getMaturityLevel() {
        return maturityLevel;
    }

    public void setMaturityLevel(String maturityLevel) {
        this.maturityLevel = maturityLevel;
    }

    @DynamoDBAttribute(attributeName = "numberOfPlayers")
    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    @DynamoDBAttribute(attributeName = "playtimeInMinutes")
    public Integer getPlaytimeInMinutes() {
        return playtimeInMinutes;
    }

    public void setPlaytimeInMinutes(Integer playtimeInMinutes) {
        this.playtimeInMinutes = playtimeInMinutes;
    }
}
