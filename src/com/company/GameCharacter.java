package com.company;

class GameCharacter {

    //constants
    static final String NAME = "Robber";

    // static variable
    private static boolean alreadyCreated = false;

    // constructor
    GameCharacter() {
        alreadyCreated = true;
    }

    // instance methods
    public String takeMoneyFromUser (User user) {
        user.setPersonalMoney(0);
        return NAME + " " + "took all of your money";
    }
}
