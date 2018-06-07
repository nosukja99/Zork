package com.company;

import java.util.HashMap;

/* This is the user class, which will contain all variables and methods associated with user actions.*/
class User {
    // constants:
    final char [] directions = {'n','s','e','w'};

    HashMap<Integer, Room> roomLookUp = new HashMap<>();

    // constructors:
     public User()
     {
         roomLookUp.put(1, new Foyer ());
         roomLookUp.put(2, new FrontRoom ());
         roomLookUp.put(3, new Library ());
         roomLookUp.put(4, new Kitchen ());
         roomLookUp.put(5, new DiningRoom ());
         roomLookUp.put(6, new Vault ());
         roomLookUp.put(7, new Parlor ());
         roomLookUp.put(8, new SecretRoom());
     }
    // instance variables:

    // instance methods:
    public Room move ( Room currentRoom, char direction){
        HashMap<Character, Integer> directions = currentRoom.getExit();
        int roomNumber = directions.get(direction);
        return roomLookUp.get(roomNumber);
    }
}
