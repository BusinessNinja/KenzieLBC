package com.kenzie.appserver.service;

import com.kenzie.appserver.repositories.GameRepository;

import com.kenzie.appserver.repositories.model.GamePrimaryKey;
import com.kenzie.appserver.repositories.model.GameRecord;
import com.kenzie.appserver.service.GameService;
import com.kenzie.appserver.service.model.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameServiceTest {
    private GameRepository gameRepository;
    private GameService gameService;

    @BeforeEach
    void setup() {
        gameRepository = mock(GameRepository.class);
        gameService = new GameService(gameRepository);
    }
    /** ------------------------------------------------------------------------
     *  gameService.findById
     *  ------------------------------------------------------------------------ **/

    @Test
    void findByGameId() {
        // GIVEN
        String id = randomUUID().toString();
        GamePrimaryKey gamePrimaryKey = new GamePrimaryKey(id, "gameTitle");

        GameRecord record = new GameRecord();
        record.setGameId(id);
        record.setGameTitle("Test Game");

        // WHEN
        when(gameRepository.findById(gamePrimaryKey)).thenReturn(Optional.of(record));
        Game game = gameService.findById(gamePrimaryKey);

        // THEN
        Assertions.assertNotNull(game, "Game should not be null");
        Assertions.assertEquals(id, game.getGameId(), "The id is correct");
        Assertions.assertEquals("Test Game", game.getGameTitle(), "The title is correct");
    }

    @Test
    void findByGameId_invalidId() {
        // GIVEN
        String id = randomUUID().toString();
        GamePrimaryKey gamePrimaryKey = new GamePrimaryKey(id, "gameTitle");

        when(gameRepository.findById(gamePrimaryKey)).thenReturn(Optional.empty());

        // WHEN
        Game game = gameService.findById(gamePrimaryKey);

        // THEN
        Assertions.assertNull(game, "The game is null");
    }

//    /** ------------------------------------------------------------------------
//     *  gameService.findByTitle
//     *  ------------------------------------------------------------------------ **/
//
//    @Test
//    void findByGameTitle() {
//        //GIVEN
//        String title = "Test Game";
//
//        GameRecord record = new GameRecord();
//        record.setGameId(randomUUID().toString());
//        record.setGameTitle(title);
//
//        //WHEN
//        when(gameRepository.findByGameTitle(title)).thenReturn(Optional.of(record));
//        Game game = gameService.findByGameTitle(title);
//
//        //THEN
//        Assertions.assertNotNull(game, "Game should not be null");
//        Assertions.assertEquals(title, game.getGameTitle(), "The title is correct");
//    }
//
//    @Test
//    void findByGameTitle_invalidTitle() {
//        //GIVEN
//        String title = "";
//
//        when(gameRepository.findByGameTitle(title)).thenReturn(Optional.empty());
//
//        //WHEN
//        Game game = gameService.findByGameTitle(title);
//
//        //THEN
//        Assertions.assertNull(game, "The game is null");
//    }
//
//    /** ------------------------------------------------------------------------
//     *  gameService.findByGenre
//     *  ------------------------------------------------------------------------ **/
//
//    @Test
//    void findByGameGenre() {
//        //GIVEN
//        String genre = "Test Genre";
//
//        GameRecord record = new GameRecord();
//        record.setGameId(randomUUID().toString());
//        record.setGameTitle("Test Game");
//        record.setGenre(genre);
//
//        //WHEN
//        when(gameRepository.findByGenre(genre)).thenReturn(Optional.of(record));
//        Game game = gameService.findByGenre(genre);
//
//        //THEN
//        Assertions.assertNotNull(game, "Game should not be null");
//        Assertions.assertEquals(genre, game.getGenre(), "The genre is correct");
//    }
//
//    @Test
//    void findByGameGenre_invalidGenre() {
//        //GIVEN
//        String genre = null;
//
//        when(gameRepository.findByGenre(genre)).thenReturn(Optional.empty());
//
//        //WHEN
//        Game game = gameService.findByGenre(genre);
//
//        //THEN
//        Assertions.assertNull(game, "The game is null");
//    }

    /** ------------------------------------------------------------------------
     *  gameService.findALl
     *  ------------------------------------------------------------------------ **/

    @Test
    void findAll() {
        //GIVEN
        String id = randomUUID().toString();

        GameRecord record = new GameRecord();
        record.setGameId(id);
        record.setGameTitle("Test Game");

        //WHEN
        List<GameRecord> value = new java.util.ArrayList<>();
        value.add(record);
        when(gameRepository.findAll()).thenReturn(value);
        List<Game> games = gameService.findAll();

        //THEN
        Assertions.assertNotNull(games, "Games should not be null");
        Assertions.assertEquals(1, games.size(), "There is one game");
        Assertions.assertEquals(id, games.get(0).getGameId(), "The id is correct");
        Assertions.assertEquals("Test Game", games.get(0).getGameTitle(), "The title is correct");
    }

    @Test
    void findAll_empty() {
        //GIVEN

        //WHEN
        List<GameRecord> value = new java.util.ArrayList<>();
        when(gameRepository.findAll()).thenReturn(value);
        List<Game> games = gameService.findAll();

        //THEN
        Assertions.assertNotNull(games, "Games should not be null");
        Assertions.assertEquals(0, games.size(), "There are no games");
    }

    /** ------------------------------------------------------------------------
     *  gameService.addNewGame
     *  ------------------------------------------------------------------------ **/
    @Test
    void addNewGame() {
        //GIVEN
        String id = randomUUID().toString();

        GameRecord record = new GameRecord();
        record.setGameId(id);
        record.setGameTitle("Test Game");
        record.setGenre("Test Genre");
        record.setWeightOfGame("1");
        record.setConditionOfGame("Test Condition");
        record.setMaturityLevel("1");
        record.setNumberOfPlayers(1);
        record.setPlaytimeInMinutes(1);

        Game game = new Game(record.getGameId(), record.getGameTitle(), record.getGenre(), record.getWeightOfGame(),
                record.getConditionOfGame(), record.getMaturityLevel(), record.getNumberOfPlayers(), record.getPlaytimeInMinutes());

        //WHEN
        when(gameRepository.save(record)).thenReturn(record);
        Game newGame = gameService.addNewGame(game);

        //THEN
        Assertions.assertNotNull(newGame, "Game should not be null");
        Assertions.assertEquals(id, newGame.getGameId(), "The id is correct");
        Assertions.assertEquals("Test Game", newGame.getGameTitle(), "The title is correct");
    }

    //TODO: addNewGame_invalidInput


    /** ------------------------------------------------------------------------
     *  gameService.updateGame
     *  ------------------------------------------------------------------------ **/
    //TODO: updateGame

    //TODO: updateGame_invalidGame

}
