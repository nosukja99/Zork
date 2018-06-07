package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Foyer extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    int roomNumber;
    /**
     * constructor with no parameter
     */
    public Foyer()
    {
        roomNumber = 1;
        contents.add("dead scorpion");
        direction.put('n',2);

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
        String display = "You are standing in the foyer of an old house.\nYou see "+contents.get(0);
        return display;

    }
}
