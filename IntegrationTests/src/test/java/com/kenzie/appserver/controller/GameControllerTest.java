package com.kenzie.appserver.controller;

import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.GameCreateRequest;
import com.kenzie.appserver.service.GameService;
import com.kenzie.appserver.service.GameService;
import com.kenzie.appserver.service.model.Game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@IntegrationTest
class GameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    GameService gameService;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getById_Exists() throws Exception {
        String gameId = UUID.randomUUID().toString();
        String gameTitle = mockNeat.strings().valStr();
        String genre = mockNeat.strings().valStr();
        String weightOfGame = mockNeat.strings().valStr();
        String conditionOfGame = mockNeat.strings().valStr();
        String maturityLevel = mockNeat.strings().valStr();
        Integer numberOfPlayers = mockNeat.ints().range(1, 6).val();
        Integer playtimeInMinutes = mockNeat.ints().range(30, 180).val();

        Game game =
                new Game(gameId, gameTitle, genre, weightOfGame, conditionOfGame,
                        maturityLevel, numberOfPlayers, playtimeInMinutes);
        Game persistedGame = gameService.addNewGame(game);
        mvc.perform(get("/game/{id}", persistedGame.getGameId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("gameId")
                        .value(is(gameId)))
                .andExpect(jsonPath("gameTitle")
                        .value(is(gameTitle)))
                .andExpect(jsonPath("genre")
                        .value(is(genre)))
                .andExpect(jsonPath("weightOfGame")
                        .value(is(weightOfGame)))
                .andExpect(jsonPath("conditionOfGame")
                        .value(is(conditionOfGame)))
                .andExpect(jsonPath("maturityLevel")
                        .value(is(maturityLevel)))
                .andExpect(jsonPath("numberOfPlayers")
                        .value(is(numberOfPlayers)))
                .andExpect(jsonPath("playtimeInMinutes")
                        .value(is(playtimeInMinutes)))
                .andExpect(status().isOk());
    }

    @Test
    public void getById_NotExists()
            throws Exception {
        String gameId = UUID.randomUUID().toString();
        mvc.perform(get("/game/{id}", gameId)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createGame_CreateSuccessful() throws Exception {
        String gameId = UUID.randomUUID().toString();
        String gameTitle = mockNeat.strings().valStr();
        String genre = mockNeat.strings().valStr();
        String weightOfGame = mockNeat.strings().valStr();
        String conditionOfGame = mockNeat.strings().valStr();
        String maturityLevel = mockNeat.strings().valStr();
        Integer numberOfPlayers = mockNeat.ints().range(1, 6).val();
        Integer playtimeInMinutes = mockNeat.ints().range(30, 180).val();


        GameCreateRequest gameCreateRequest = new GameCreateRequest();
        gameCreateRequest.setGameId(gameId);
        gameCreateRequest.setGameTitle(gameTitle);
        gameCreateRequest.setGenre(genre);
        gameCreateRequest.setWeightOfGame(weightOfGame);
        gameCreateRequest.setConditionOfGame(conditionOfGame);
        gameCreateRequest.setMaturityLevel(maturityLevel);
        gameCreateRequest.setNumberOfPlayers(numberOfPlayers);
        gameCreateRequest.setPlaytimeInMinutes(playtimeInMinutes);

        mapper.registerModule(new JavaTimeModule());

        mvc.perform(post("/new")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gameCreateRequest)))
                .andExpect(jsonPath("gameId")
                        .exists())
                .andExpect(jsonPath("gameTitle")
                        .value(is(gameTitle)))
                .andExpect(jsonPath("genre")
                        .value(is(genre)))
                .andExpect(jsonPath("weightOfGame")
                        .value(is(weightOfGame)))
                .andExpect(jsonPath("conditionOfGame")
                        .value(is(conditionOfGame)))
                .andExpect(jsonPath("maturityLevel")
                        .value(is(maturityLevel)))
                .andExpect(jsonPath("numberOfPlayers")
                        .value(is(numberOfPlayers)))
                .andExpect(jsonPath("playtimeInMinutes")
                        .value(is(playtimeInMinutes)))
                .andExpect(status().isCreated());
    }

    @Test
    public void createGame_CreateUnsuccessful() throws Exception {
        String gameId = UUID.randomUUID().toString();
        String gameTitle = mockNeat.strings().valStr();
        String genre = mockNeat.strings().valStr();
        String weightOfGame = mockNeat.strings().valStr();
        String conditionOfGame = mockNeat.strings().valStr();
        String maturityLevel = mockNeat.strings().valStr();
        Integer numberOfPlayers = mockNeat.ints().range(1, 6).val();
        Integer playtimeInMinutes = mockNeat.ints().range(30, 180).val();

        GameCreateRequest gameCreateRequest = new GameCreateRequest();
        gameCreateRequest.setGameId(gameId);
        gameCreateRequest.setGameTitle(gameTitle);
        gameCreateRequest.setGenre(genre);
        gameCreateRequest.setWeightOfGame(weightOfGame);
        gameCreateRequest.setConditionOfGame(conditionOfGame);
        gameCreateRequest.setMaturityLevel(maturityLevel);
        gameCreateRequest.setNumberOfPlayers(numberOfPlayers);
        gameCreateRequest.setPlaytimeInMinutes(playtimeInMinutes);

        mapper.registerModule(new JavaTimeModule());

        mvc.perform(post("/new")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gameCreateRequest)))
                .andExpect(jsonPath("gameId")
                        .exists())
                .andExpect(jsonPath("gameTitle")
                        .value(is(gameTitle)))
                .andExpect(jsonPath("genre")
                        .value(is(genre)))
                .andExpect(jsonPath("weightOfGame")
                        .value(is(weightOfGame)))
                .andExpect(jsonPath("conditionOfGame")
                        .value(is(conditionOfGame)))
                .andExpect(jsonPath("maturityLevel")
                        .value(is(maturityLevel)))
                .andExpect(jsonPath("numberOfPlayers")
                        .value(is(numberOfPlayers)))
                .andExpect(jsonPath("playtimeInMinutes")
                        .value(is(playtimeInMinutes)))
                .andExpect(status().isCreated());

        mvc.perform(post("/new")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gameCreateRequest)))
                .andExpect(status().isBadRequest());

    }
}