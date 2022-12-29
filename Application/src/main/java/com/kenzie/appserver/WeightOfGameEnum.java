package com.kenzie.appserver;

import com.kenzie.appserver.controller.model.GameResponse;

public enum WeightOfGameEnum {
    LIGHT,
    MEDUIM_LIGHT,
    MEDUIM,
    MEDUIM_HEAVY,
    HEAVY;


}

class WeightOfGameEnumMain {
    public void main(String[] args) {
        WeightOfGameEnum myVar = WeightOfGameEnum.MEDUIM;

        GameResponse gameResponse = new GameResponse();

        gameResponse.setWeightOfGame(myVar.toString());

        switch(myVar) {
            case LIGHT:
                gameResponse.setWeightOfGame("Light");
                break;
            case MEDUIM_LIGHT:
                gameResponse.setWeightOfGame("Meduim Light");
                break;
            case MEDUIM:
                gameResponse.setWeightOfGame("Meduim");
                break;
            case MEDUIM_HEAVY:
                gameResponse.setWeightOfGame("Meduim Heavy");
                break;
            case HEAVY:
                gameResponse.setWeightOfGame("Heavy");
                break;

        }
    }
}
