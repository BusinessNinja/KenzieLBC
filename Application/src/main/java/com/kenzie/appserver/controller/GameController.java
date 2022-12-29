package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.GameCreateRequest;
import com.kenzie.appserver.controller.model.GameResponse;
import com.kenzie.appserver.repositories.model.GamePrimaryKey;
import com.kenzie.appserver.service.GameService;
import com.kenzie.appserver.service.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/game")
public class GameController{

    private GameService gameService;

    GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameResponse> getGame(@PathVariable("gameId") GamePrimaryKey gameId) {

        Game game = gameService.findById(gameId);
        if (game == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(gameToResponse(game));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GameResponse>> getGame() {

        List<Game> games = gameService.findAll();

        List<GameResponse> responses = games.stream().map(game -> gameToResponse(game)).collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    @PostMapping("/new")//Suggestion from Nathan
    public ResponseEntity<GameResponse> addNewGame(@RequestBody GameCreateRequest gameCreateRequest) {

        Game game = new Game(randomUUID().toString(), gameCreateRequest.getGameTitle(), gameCreateRequest.getGenre(), gameCreateRequest.getWeightOfGame(),
                gameCreateRequest.getConditionOfGame(), gameCreateRequest.getMaturityLevel(), gameCreateRequest.getNumberOfPlayers(), gameCreateRequest.getPlaytimeInMinutes());

        System.out.println(game.toString());

        gameService.addNewGame(game);

        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(game.getGameId());
        gameResponse.setGameTitle(game.getGameTitle());



        return ResponseEntity.created(URI.create("/game/" + gameResponse.getGameId())).body(gameResponse);
    }

    private GameResponse gameToResponse(Game game) {
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(game.getGameId());
        gameResponse.setGameTitle(game.getGameTitle());
        gameResponse.setGenre(game.getGenre());
        gameResponse.setWeightOfGame(game.getWeightOfGame());
        gameResponse.setConditionOfGame(game.getConditionOfGame());
        gameResponse.setMaturityLevel(game.getMaturityLevel());
        gameResponse.setNumberOfPlayers(game.getNumberOfPlayers());
        gameResponse.setPlaytimeInMinutes(game.getPlaytimeInMinutes());
        return gameResponse;
    }
}
