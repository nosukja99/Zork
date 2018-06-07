package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Kitchen extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();

    int roomNum;
    /**
     * constructor with no parameter
     */
    public Kitchen()
    {
        roomNum = 4;
        contents.add("bats");
        direction.put('w', 2);
        direction.put('n', 7);
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
    public String displayContent() {
        Random rand = new Random();
        int x = rand.nextInt(contents.size());
        String display = "You see "+contents.get(x);
        return display;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west, (2) exit to the north or press Q to quit}";
        return exitMessage;
    }
    @Override
    public String displayExitMessage() {
        String exitMessage = "{You can (1)exit to the west, (2) exit to the north, or press Q to quit}";
        return exitMessage;
    }
}
