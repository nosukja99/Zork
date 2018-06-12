package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import java.util.HashMap;
import java.util.Random;

public class Parlor extends Room{
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();

    int roomNum;
    double money;
    /**
     * constructor with no parameter
     */
    public Parlor()
    {
        roomNum = 7;
        contents.add("treasure chest");
        direction.put('w', 6);
        direction.put('s', 4);
        setRandomAmountOfMoney();
    }
    @Override
    public int getRoomNumber() {
        return roomNum;
    }

    @Override
    public HashMap getExit() {
        return direction;
    }

    @Override
    public String displayContent(User user) {
        String display = "You are standing in the parlor.\nYou see "+contents.get(0) +
                "\nYou have " + String.format("$%.2f", user.getPersonalMoney())+ "\nAmount of money in the room: " +
                String.format("$%.2f",getAmountOfMoney());
        return display;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west,(2) exit to the south or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='w'; break;
            case "2": direction='s'; break;
            case "Q": direction='q'; break;
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
        setMoney(0);
        user.setPersonalMoney(user.getPersonalMoney()+ getAmountOfMoney());
    }
}
