package com.kenzie.appserver;

import com.kenzie.appserver.controller.model.GameResponse;

public enum MaturityLevelEnum {

    EVERYBODY,
    TEEN,
    MATURE;
}

    class MaturityLevelEnumMain {
        public static void main(String[] args) {
            MaturityLevelEnum myVar = MaturityLevelEnum.EVERYBODY;

            GameResponse gameResponse = new GameResponse();

            gameResponse.setMaturityLevel(myVar.toString());

            switch(myVar) {
                case EVERYBODY:
                    gameResponse.setMaturityLevel("Everyone");
                    break;
                case TEEN:
                    gameResponse.setMaturityLevel("Teen");
                    break;
                case MATURE:
                    gameResponse.setMaturityLevel("Mature");
                    break;
            }
        }
    }
