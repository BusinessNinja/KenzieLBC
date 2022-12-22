import BaseClass from "../util/baseClass";
import axios from 'axios'

/**
 * Client to call the ExampleService.
 */
export default class GameClient extends BaseClass {

    constructor(props = {}) {
        super();
        const methodsToBind = ['clientLoaded', 'getGame', 'createGame', 'getAllGames'];
        this.bindClassMethods(methodsToBind, this);
        this.props = props;
        this.clientLoaded(axios);
    }

    /**
     * Run any functions that are supposed to be called once the client has loaded successfully.
     * @param client The client that has been successfully loaded.
     */
    clientLoaded(client) {
        this.client = client;
        if (this.props.hasOwnProperty("onReady")) {
            this.props.onReady();
        }
    }

    async getGame(id, errorCallback) {
        try {
            const response = await this.client.get(`/game/${id}`);
            return response.data;
        } catch (error) {
            this.handleError("getGame", error, errorCallback)
        }
    }

    async getAllGames(errorCallback) {
        try {
            const response = await this.client.get("/game/all");
            return response.data;
        } catch (error) {
            this.handleError("getAllGames", error, errorCallback)
        }
    }

    async createGame(gameTitle, genre, weightOfGame, conditionOfGame, maturityLevel,
                     numberOfPlayers, playtimeInMinutes, errorCallback) {
        try {
            const response = await this.client.post("/game/new", {
                "gameTitle": gameTitle,
                "genre": genre,
                "weightOfGame": weightOfGame,
                "conditionOfGame": conditionOfGame,
                "maturityLevel": maturityLevel,
                "numberOfPlayers": numberOfPlayers,
                "playtimeInMinutes": playtimeInMinutes
            });
            console.log(response);
            return response.data;
        } catch (error) {
            this.handleError("createGame", error, errorCallback);
        }
    }

    /**
     * Helper method to log the error and run any error functions.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(method, error, errorCallback) {
        console.error(method + " failed - " + error);
        if (error.response.data.message !== undefined) {
            console.error(error.response.data.message);
        }
        if (errorCallback) {
            errorCallback(method + " failed - " + error);
        }
    }
}
