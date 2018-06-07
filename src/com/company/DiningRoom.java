package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DiningRoom extends Room{
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNum;

    /**
     * constructor with no parameter
     */
    public DiningRoom()
    {
        roomNum = 5;
        contents.add("bats");
        contents.add("a empty box");
        direction.put('s', 3);
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
    public String displayContent() {
        Random rand = new Random();
        int x = rand.nextInt(contents.size());
        String display = "You are standing in the dinning room\n You see "+contents.get(x);
        return display;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the south or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction = 0;
        switch(s)
        {
            case "1": direction='w'; break;
            case "Q": direction='q'; break;
            case "q": direction='q'; break;
        }
        return direction;
    }
}
