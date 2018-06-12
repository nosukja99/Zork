package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Foyer extends Room {
    //constant
    public static final String ROOMNAME = "Foyer";
    public static final String ROOMCONTENTS = "dead scorpion";

    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
    double money;
    /**
     * constructor with no parameter
     */
    public Foyer()
    {
        roomNumber = 1;
        contents.add("dead scorpion");
        direction.put('n',2);
        setRandomAmountOfMoney();
    }

    @Override
    public String getRoomName () {
        return ROOMNAME;
    }

    @Override
    public String getContents () {
        return ROOMCONTENTS;
    }

    @Override
    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public HashMap getExit() {
        return direction;
    }

    @Override
    public String displayContent(User user) {
        String display = "You are standing in the foyer of an old house.\nYou see "+contents.get(0) +
                "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                String.format("$%.2f",getAmountOfMoney());
        return display;

    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the north or press Q to quit}";
        return exitMessage;
    }

    @Override
    public char changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='n'; break;
            case "q": direction='q'; break;
            case "Q": direction='q'; break;
        }
        return direction;
    }

    @Override
    public void setRandomAmountOfMoney (){
        Random rn = new Random();
        this.money = Double.valueOf(rn.nextInt(100000)/10);
    }

    @Override
    public double getAmountOfMoney (){
        return this.money;
    }
    @Override
    public void setMoney (double money) {
        this.money = money;
    }
    @Override
    public void takeMoney (User user) {
        user.setPersonalMoney(user.getPersonalMoney()+ getAmountOfMoney());
        setMoney(0);
    }
}
