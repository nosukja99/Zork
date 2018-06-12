package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DiningRoom extends Room{

    //constant
    public static final String ROOMNAME = "Dinning Room";
    public static final String ROOMCONTENTS = "dust and an empty box";

    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNum;
    double money;
    /**
     * constructor with no parameter
     */
    public DiningRoom()
    {
        roomNum = 5;
        contents.add("dust");
        contents.add("an empty box");
        direction.put('s', 3);
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

    @Override
    public HashMap getExit()
    {
        return direction;
    }

    @Override
    public String displayContent(User user) {
        Random rand = new Random();
        int x = rand.nextInt(contents.size());
        String display = "You are standing in the dinning room\nYou see "+contents.get(x) +
                "\nYou have " + String.format("$%.2f", user.getPersonalMoney()) + "\nAmount of money in the room: " +
                String.format("$%.2f",getAmountOfMoney());
        return display;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the south or press Q to quit}";
        return exitMessage;
    }

    @Override
    public char changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='s'; break;
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
