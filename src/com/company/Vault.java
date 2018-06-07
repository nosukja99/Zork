package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Vault {

    public class Vault extends Room {
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
            direction.put('e', 8);
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
            return "You see "+ contents.get (0);
        }

        @Override
        public String displayExitMessage() {
            String exitMessage = "{You can (1)exit to the east or press Q to quit}";
            if (true) exitMessage = "{You can (1)exit to the east, (2) exit to the east (secret room) or press Q to quit}";
            return exitMessage;
        }
    }

}
