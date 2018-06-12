package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Kitchen extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();

    int roomNum;
    double money;
    /**
     * constructor with no parameter
     */
    public Kitchen()
    {
        roomNum = 4;
        contents.add("bats");
        direction.put('w', 2);
        direction.put('n', 7);
        setRandomAmountOfMoney();
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
        String display = "You are standing in the kitchen.\nYou see "+ contents.get(0) +
                "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                String.format("$%.2f",getAmountOfMoney());
        return display;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west, (2) exit to the north or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='w'; break;
            case "2": direction='n'; break;
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
        user.setPersonalMoney(user.getPersonalMoney()+ getAmountOfMoney());
        setMoney(0);
    }
}
