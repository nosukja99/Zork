package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class FrontRoom extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
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
    public String displayContent() {
        String display = "You are standing in a front room.\nYou see "+contents.get(0);
        return display;
    }

    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the south, (2) exit to the west,(3) exit to the east or press Q to quit}";
        return exitMessage;
    }

    @Override
    public Character changeStringToChar(String s) {
        char direction = '0';
        switch(s)
        {
            case "1": direction='s'; break;
            case "2": direction='w'; break;
            case "3": direction='e'; break;
            case "Q": direction='q'; break;
            case "q": direction='q'; break;
        }
        return direction;
    }

}
