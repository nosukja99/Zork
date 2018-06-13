package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Library extends Room {
    //constant
    public static final String ROOMNAME = "Library";
    public static final String ROOMCONTENTS = "spiders";

    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
    double money;
    /**
     * constructor with no parameter
     */
    public Library()
    {
        roomNumber = 3;
        contents.add("spiders");
        direction.put('e',2);
        direction.put('n',5);
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
        String display;
        if (user.hasLamp()) {
                display = "You are standing in a library.\nYou see " + contents.get(0) +
                    "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                        String.format("$%.2f", getAmountOfMoney()) + "\nThere is a scroll on the wall with a secret message: " +
                        "******Reading is Awesome******** \nType in this message to receive extra $1000.00";
        }
        else {
                display = "You are standing in a library.\nYou see " + contents.get(0) +
                    "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                    String.format("$%.2f", getAmountOfMoney());
        }
        return display;
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1 or e)exit to the east, (2 or n) exit to the north or press Q to quit}";
        return exitMessage;
    }

    @Override
    public char changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1":
            case "E":
            case "e": direction='e'; break;
            case "2":
            case "N":
            case "n": direction='n'; break;
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
