package com.kenzie.appserver;

import com.kenzie.appserver.controller.model.GameResponse;

public enum PlaytimeEnum {
    FIFTEEN,
    THIRTY,
    FOURTYFIVE,
    SIXTY,
    SEVENTYFIVE,
    NINETY,
    ONEHUNDREDFIVE,
    ONEHUNDREDTWENTY;

}

    class PlaytimeEnumMain {
        public void main(String[] args) {
            PlaytimeEnum myVar = PlaytimeEnum.SIXTY;

            GameResponse gameResponse = new GameResponse();

            gameResponse.setPlaytimeInMinutes(Integer.valueOf(myVar.toString()));

            switch(myVar) {
                case FIFTEEN:
                    gameResponse.setPlaytimeInMinutes(15);
                    break;
                case THIRTY:
                    gameResponse.setPlaytimeInMinutes(30);
                    break;
                case FOURTYFIVE:
                    gameResponse.setPlaytimeInMinutes(45);
                    break;
                case SIXTY:
                    gameResponse.setPlaytimeInMinutes(60);
                    break;
                case SEVENTYFIVE:
                    gameResponse.setPlaytimeInMinutes(75);
                    break;
                case NINETY:
                    gameResponse.setPlaytimeInMinutes(90);
                    break;
                case ONEHUNDREDFIVE:
                    gameResponse.setPlaytimeInMinutes(105);
                    break;
                case ONEHUNDREDTWENTY:
                    gameResponse.setPlaytimeInMinutes(120);
                    break;
            }
        }
    }

