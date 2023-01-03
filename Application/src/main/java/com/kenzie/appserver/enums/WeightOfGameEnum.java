package com.kenzie.appserver.enums;

import com.kenzie.appserver.controller.model.GameResponse;

public enum WeightOfGameEnum {
    LIGHT,
    MEDIUM_LIGHT,
    MEDIUM,
    MEDIUM_HEAVY,
    HEAVY;


}

class WeightOfGameEnumMain {
    public void main(String[] args) {
        WeightOfGameEnum myVar = WeightOfGameEnum.MEDIUM;

        GameResponse gameResponse = new GameResponse();

        gameResponse.setWeightOfGame(myVar.toString());

        switch(myVar) {
            case LIGHT:
                gameResponse.setWeightOfGame("Light");
                break;
            case MEDIUM_LIGHT:
                gameResponse.setWeightOfGame("Medium Light");
                break;
            case MEDIUM:
                gameResponse.setWeightOfGame("Medium");
                break;
            case MEDIUM_HEAVY:
                gameResponse.setWeightOfGame("Medium Heavy");
                break;
            case HEAVY:
                gameResponse.setWeightOfGame("Heavy");
                break;

        }
    }
}
