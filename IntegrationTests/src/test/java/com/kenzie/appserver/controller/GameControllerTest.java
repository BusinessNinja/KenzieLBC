package com.kenzie.appserver.controller;

import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.ExampleCreateRequest;
import com.kenzie.appserver.controller.model.GameCreateRequest;
import com.kenzie.appserver.service.ExampleService;
import com.kenzie.appserver.service.GameService;
import com.kenzie.appserver.service.model.Example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.kenzie.appserver.service.model.Game;
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

public class GameControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    GameService gameService;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getById_Exists() throws Exception {
        String id = UUID.randomUUID().toString();
        String title = mockNeat.strings().valStr();
        String genre = mockNeat.strings().valStr();
        String weight = mockNeat.strings().valStr();
        String condition = mockNeat.strings().valStr();
        String level = mockNeat.strings().valStr();
        Integer players = Integer.valueOf(mockNeat.ints().valStr());
        Integer playtime = Integer.valueOf(mockNeat.ints().valStr());
        String tags = mockNeat.strings().valStr();


        Game game = new Game(id, title, genre, weight, condition, level, players, playtime, tags);
        Game persistedGame = gameService.addNewGame(game);
        mvc.perform(get("/game/{id}", persistedGame.getGameId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("gameId")
                        .value(is(id)))
                .andExpect(jsonPath("gameTitle")
                        .value(is(title)))
                .andExpect(jsonPath("genre")
                        .value(is(genre)))
                .andExpect(jsonPath("weightOfGame")
                        .value(is(weight)))
                .andExpect(jsonPath("conditionOfGame")
                        .value(is(condition)))
                .andExpect(jsonPath("maturityLevel")
                        .value(is(level)))
                .andExpect(jsonPath("numberOfPlayers")
                        .value(is(players)))
                .andExpect(jsonPath("playtimeInMinutes")
                        .value(is(playtime)))
                .andExpect(jsonPath("tags")
                        .value(is(tags)))
                .andExpect(status().isOk());
    }

    @Test
    public void createGame_CreateSuccessful() throws Exception {
        String title = mockNeat.strings().valStr();

        GameCreateRequest gameCreateRequest = new GameCreateRequest();
        gameCreateRequest.setGameTitle(title);

        mapper.registerModule(new JavaTimeModule());

        mvc.perform(post("/game")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(gameCreateRequest)))
                .andExpect(jsonPath("gameid")
                        .exists())
                .andExpect(jsonPath("title")
                        .value(is(title)))
                .andExpect(status().isCreated());
    }
}
