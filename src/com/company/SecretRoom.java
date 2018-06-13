package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SecretRoom extends Room {
    //constant
    public static final String ROOMNAME = "Secret Room";
    public static final String ROOMCONTENTS = "piles of gold";

    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNum;
    double money;

    /**
     * constructor with no parameter
     */
    public SecretRoom()
    {
        roomNum = 8;
        contents.add("piles of gold");
        direction.put('w', 6);
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
        return roomNum;
    }

    public HashMap getExit()
    {
        return direction;
    }

    @Override
    public String displayContent(User user) {
        String display;
        if (user.hasLamp()) {
            display = "You are standing in the secret room.\nYou see "+ contents.get (0) +
                      "\nYou have " +String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                      String.format("$%.2f",getAmountOfMoney()) + "\nYou find a map of the entire house in the corner of" +
                      " the room. Type in ***Take Map*** to take map ***Take Gold*** to take the gold or ***Take Both***" +
                      "to take both";
        }
        else {
            display = "You are standing in the secret room.\nYou see "+ contents.get (0) +
                      "\nYou have " +String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                      String.format("$%.2f",getAmountOfMoney());
        }

        return display;
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1 or w)exit to the west or press Q to quit}";
        return exitMessage;
    }

    @Override
    public char changeStringToChar(String s) {
        char direction ='0';
        switch(s)
        {
            case "1":
            case "W":
            case "w": direction='w'; break;
            case "Q":
            case "q": direction='q'; break;
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
