package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SecretRoom extends Room {
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

        return "You are standing in the secret room.\nYou see "+ contents.get (0) +
                "\n You have " +String.format("$%.2f", user.getPersonalMoney());
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction ='0';
        switch(s)
        {
            case "1": direction='w'; break;
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
}
