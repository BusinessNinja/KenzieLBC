package com.kenzie.appserver;

import com.kenzie.appserver.controller.model.GameResponse;

public enum NumberOfPlayersEnum {
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX;
}

class NumberOfPlayersEnumMain {
    public void main(String[] args) {
        NumberOfPlayersEnum myVar = NumberOfPlayersEnum.FOUR;

        GameResponse gameResponse = new GameResponse();

        gameResponse.setNumberOfPlayers(Integer.valueOf(myVar.toString()));

        switch(myVar) {
            case ONE:
                gameResponse.setNumberOfPlayers(1);
                break;
            case TWO:
                gameResponse.setNumberOfPlayers(2);
                break;
            case THREE:
                gameResponse.setNumberOfPlayers(3);
                break;
            case FOUR:
                gameResponse.setNumberOfPlayers(4);
                break;
            case FIVE:
                gameResponse.setNumberOfPlayers(5);
                break;
            case SIX:
                gameResponse.setNumberOfPlayers(6);
                break;

        }
    }
}

