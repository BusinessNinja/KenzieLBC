package com.kenzie.appserver;

import com.kenzie.appserver.controller.model.GameResponse;

public enum ConditionOfGameEnum {
    NEW,
    LIKE_NEW,
    GOOD,
    FAIR,
    POOR;

    public class ConditionOfGameEnumMain {
        public void main(String[] args) {
            ConditionOfGameEnum myVar = ConditionOfGameEnum.NEW;

            GameResponse gameResponse = new GameResponse();

            gameResponse.setConditionOfGame(myVar.toString());

            switch (myVar) {
                case NEW:
                    gameResponse.setConditionOfGame("New");
                    break;
                case LIKE_NEW:
                    gameResponse.setConditionOfGame("Like New");
                    break;
                case GOOD:
                    gameResponse.setConditionOfGame("Good");
                    break;
                case FAIR:
                    gameResponse.setConditionOfGame("Fair");
                    break;
                case POOR:
                    gameResponse.setConditionOfGame("Poor");
                    break;
            }
        }
    }
}
