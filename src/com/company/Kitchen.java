package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Kitchen extends Room {
    HashMap<Character, Integer> direction = new HashMap<>();
    ArrayList<String> contents = new ArrayList<>();
    final static char [ ] directions = {'n', 's','e','w' };

    /**
     * constructor with no parameter
     */
    public Kitchen()
    {
        final int roomNum = 4;
        contents.add("bats");
        direction.put('w', 2);
        direction.put('n', 7);
    }

    public HashMap getDirection()
    {
        return direction;
    }

    @Override
    public String displayContent() {
        String display = "You see "+contents.get(0);
        return display;
    }
}
