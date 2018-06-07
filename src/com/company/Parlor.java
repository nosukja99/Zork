package com.company;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashMap;
import java.util.Random;

public class Parlor extends Room{
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();

    int roomNum;
    /**
     * constructor with no parameter
     */
    public Parlor()
    {
        roomNum = 7;
        contents.add("bats");
        direction.put('w', 6);

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
    public String displayContent() {
        Random rand = new Random();
        int x = rand.nextInt(contents.size());
        String display = "You see "+contents.get(x);
        return display;
    }
}
