package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.GameRepository;
import com.kenzie.appserver.repositories.model.GameRecord;
import com.kenzie.appserver.service.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) { this.gameRepository = gameRepository; }

    public Game findById(String id) {
        Game gameFromBackend = gameRepository
                .findById(id)
                .map(comment -> new Game(game.getId(), game.getOwner(), game.getTitle(),
                        game.getContent(), game.getContent(), game.getContent(),
                        game.getContent(), game.getContent()))
                .orElse(null);
        return gameFromBackend;
    }

    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        gameRepository
                .findAll()
                .forEach(comment -> games.add(new Game(comment.getId(), comment.getOwner(), comment.getTitle(), comment.getContent(),
                        comment.getContent(), comment.getContent(), comment.getContent(), comment.getContent())));
        return games;
    }

    public Game addNewGame(Game game) {
        GameRecord gameRecord = new GameRecord();
        gameRecord.setGameId(game.getGameId());
        gameRecord.setGameTitle(game.getGameTitle());
        gameRecord.setGenre(game.getGenre());
        gameRecord.setWeightOfGame(game.getWeightOfGame());
        gameRecord.setConditionOfGame(game.getConditionOfGame());
        gameRecord.setMaturityLevel(game.getMaturityLevel());
        gameRecord.setNumberOfPlayers(game.getNumberOfPlayers());
        gameRecord.setPlaytimeInMinutes(game.getPlaytimeInMinutes());
        gameRecord.save(gameRecord);
        return game;
    }
}
