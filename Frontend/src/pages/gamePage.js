import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import GameClient from "../api/gameClient";

class GamePage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onGetGames', 'onCreate', 'renderGames'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers
     */
    async mount() {
        // document.getElementById('get-by-id-form').addEventListener('submit', this.onGet);
        document.getElementById('create-game-form').addEventListener('submit', this.onCreate);
        this.client = new GameClient();


        this.dataStore.addChangeListener(this.renderGames)
        this.onGetGames();
    }

    /** Render Methods -----------------------------------------------------------------------------------------------*/

    async renderGames() {
        let resultArea = document.getElementById("result-info");
        const games = this.dataStore.get("games");

        let content = "<ul>";
        for (let game of games) {
            content += `
                <li>
                <h3>${game.gameTitle}</h3>
                <h3>${game.genre}</h3>
                <h3>${game.weightOfGame}</h3>
                <h3>${game.conditionOfGame}</h3>
                <h3>${game.maturityLevel}</h3>
                <h3>${game.numberOfPlayers}</h3>
                <h3>${game.playtimeInMinutes}</h3>
                </li>
            `
        }
        content += "</ul>";
        if (games.length > 0) {
            resultArea.innerHTML = content;
        } else {
            resultArea.innerHTML = "No Item";
        }

    }

    /** Event Handlers -----------------------------------------------------------------------------------------------*/

    async onGetGames() {
        let result =  this.client.getAllGames(this.errorHandler);
        this.dataStore.set("games", result);
    }

    async onCreate(game) {
        // Prevent the page from refreshing on form submit
        game.preventDefault();

        let gameTitle = document.getElementById("create-game-gametitle").value;
        let genre = document.getElementById("create-game-genre").value;
        let weightOfGame = document.getElementById("create-game-weightofgame").value;
        let conditionOfGame = document.getElementById("create-game-conditionofgame").value;
        let maturityLevel = document.getElementById("create-game-maturitylevel").value;
        let numberOfPlayers = document.getElementById("create-game-numberofplayers").value;
        let playtimeInMinutes = document.getElementById("create-game-playtimeinminutes").value;


        const createdGame =  this.client.createGame(gameTitle, genre, weightOfGame, conditionOfGame,
            maturityLevel, numberOfPlayers, playtimeInMinutes, this.errorHandler);


        if (createdGame) {
            this.showMessage(`Added a game!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
        this.onGetGames();
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const gamePage = new GamePage();
    await gamePage.mount();
};

window.addEventListener('DOMContentLoaded', main);
