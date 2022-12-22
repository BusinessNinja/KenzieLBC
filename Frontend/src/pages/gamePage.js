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
        let resultArea = document.getElementById("result-info");
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
        resultArea.innerHTML = content;
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
        const formData = new FormData(game.target);
        const gameTitle = formData.get("gameTitle");
        const genre = formData.get("genre");
        const weightOfGame = formData.get("weightOfGame");
        const conditionOfGame = formData.get("conditionOfGame");
        const maturityLevel = formData.get("maturityLevel");
        const numberOfPlayers = formData.get("numberOfPlayers");
        const playtimeInMinutes = formData.get("playtimeInMinutes");

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

        const createdGame = this.client.createGame(gameTitle,
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
        document.getElementById("gameTitle").focus();

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