package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FrontRoom extends Room {
    //constant
    public static final String ROOMNAME = "Front Room";
    public static final String ROOMCONTENTS = "a piano";

    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
    double money;
    /**
     * constructor with no parameter
     */
    public FrontRoom()
    {
        roomNumber = 2;
        contents.add("a piano");
        direction.put('s',1);
        direction.put('w',3);
        direction.put('e',4);
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
        if (user.hasLamp()){
            display = "You are standing in a front room.\nYou see " + contents.get(0) +
                    "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                    String.format("$%.2f", getAmountOfMoney());
        }
        else {
            display = "You are standing in a front room.\nYou see " + contents.get(0) +
                    "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                    String.format("$%.2f", getAmountOfMoney());
        }
        return display;
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1 or s)exit to the south, (2 or w) exit to the west,(3 or e) exit to the east or press Q to quit}";
        return exitMessage;
    }

    @Override
    public char changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1":
            case "S":
            case "s": direction='s'; break;
            case "2":
            case "W":
            case "w": direction='w'; break;
            case "3":
            case "E":
            case "e": direction='e'; break;
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
