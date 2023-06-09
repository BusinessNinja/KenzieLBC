package com.kenzie.appserver.repositories.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;
@DynamoDBTable(tableName = "Games")
public class GameRecord {
    @Id
    private GamePrimaryKey primaryKey;
    private String genre;
    private String weightOfGame;
    private String conditionOfGame;
    private String maturityLevel;
    private Integer numberOfPlayers;
    private Integer playtimeInMinutes;
    private String tags;

    @DynamoDBHashKey(attributeName = "gameId")
    public String getGameId() {
        if (primaryKey != null)
            return primaryKey.getGameId();
        return null;
    }

    public void setGameId(String gameId) {
        if (primaryKey == null)
            primaryKey = new GamePrimaryKey();
        primaryKey.setGameId(gameId);
    }

    @DynamoDBRangeKey(attributeName = "gameTitle")
    public String getGameTitle() {
        if (primaryKey != null)
            return primaryKey.getGameTitle();
        return null;
    }

    public void setGameTitle(String gameTitle) {
        if (primaryKey == null)
            primaryKey = new GamePrimaryKey();
        primaryKey.setGameTitle(gameTitle);
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

    @DynamoDBAttribute(attributeName = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
