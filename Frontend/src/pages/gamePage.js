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
        this.client = new GameClient();
        document.getElementById("create-game-form").addEventListener("submit", this.onCreate);

        this.dataStore.addChangeListener(this.renderGames)
    }

    /** Render Methods -----------------------------------------------------------------------------------------------*/

    async renderGames() {
        //let resultArea = document.getElementById("result-info");
        const games = this.dataStore.get("games");

        let content = "<ul>";
        if (games) {
            games.forEach(game => {
                content += `<li>${game.gameTitle}</li>`
                content += `<li>${game.genre}</li>`
                content += `<li>${game.weightOfGame}</li>`
                content += `<li>${game.conditionOfGame}</li>`
                content += `<li>${game.maturityLevel}</li>`
                content += `<li>${game.numberOfPlayers}</li>`
                content += `<li>${game.playtimeInMinutes}</li>`
            });
        }
        content += "</ul>";
        //resultArea.innerHTML = content;
    }

    /** Event Handlers -----------------------------------------------------------------------------------------------*/

    async onGetGames() {
        const games = await this.client.getAllGames(this.errorHandler);
        this.dataStore.set("games", games);
    }

    async onCreate(game) {
        // Prevent the page from refreshing on form submit
        game.preventDefault();

        // Get the form data
        const gameTitle = document.getElementById("create-game-gametitle").value;
        const genre = document.getElementById("create-game-genre").value;
        const weightOfGame = document.getElementById("create-game-weightofgame").value;
        const conditionOfGame = document.getElementById("create-game-conditionofgame").value;
        const maturityLevel = document.getElementById("create-game-maturitylevel").value;
        const numberOfPlayers = document.getElementById("create-game-numberofplayers").value;
        const playtimeInMinutes = document.getElementById("create-game-playtimeinminutes").value;

        // Create the game
        const newGame = {
            gameTitle,
            genre,
            weightOfGame,
            conditionOfGame,
            maturityLevel,
            numberOfPlayers,
            playtimeInMinutes
        };

        console.log(newGame)

        const createdGame = await this.client.createGame(gameTitle,
            genre,
            weightOfGame,
            conditionOfGame,
            maturityLevel,
            numberOfPlayers,
            playtimeInMinutes, this.errorHandler);

        if (createdGame) {
            this.showMessage("Added a game!")
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
        await this.onGetGames();

        // Clear the form
        game.target.reset();

        // Focus the game title field
        document.getElementById("gameTitle");

        // Prevent the form from submitting
        return false;
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const gamePage = new GamePage();
    await gamePage.mount();
};

window.addEventListener("DOMContentLoaded", main);