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
        roomNumber = 3;
        contents.add("spiders");
        direction.put('e',2);
        direction.put('n',5);

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
}
