package com.company;

import java.util.ArrayList;
import java.util.HashMap;

    public class Vault extends Room {
        public static final double CHANCE_OF_FINDING_SECRET_ROOM = 0.25;
        HashMap<Character, Integer> direction = new HashMap<>();
        ArrayList<String> contents = new ArrayList<>();
        int roomNum;

        /**
         * constructor with no parameter
         */
        public Vault()
        {
            roomNum = 6;
            contents.add("3 walking skeletons");
            direction.put('e', 7);
            direction.put('c', 8);
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
            return "You see "+ contents.get(0);
        }

        @Override
        public String displayExitMessage() {
            String exitMessage = "{You can (1)exit to the east or press Q to quit}";
            if (Math.random()<CHANCE_OF_FINDING_SECRET_ROOM) exitMessage = "{You can (1)exit to the east, (2) exit to the east (secret room) or press Q to quit}";
            return exitMessage;
        }

        @Override
        public Character changeStringToChar(String s) {
            char direction = 0;
            switch(s)
            {
                case "1": direction='e'; break;
                case "2": direction='c'; break;
                case "Q": direction='q'; break;
                case "q": direction='q'; break;
            }
            return direction;
        }
    }


