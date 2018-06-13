package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* This is the user class, which will contain all variables and methods associated with user actions.*/
class User {
    // constants:
    final double CHANCE_OF_BEING_FOLLOWED_BY_GHOST = 0.25;
    final char [] directions = {'n','s','e','w'};

    //instance variables
    HashMap<Integer, Room> roomLookUp = new HashMap<>();
    private double personalMoney;
    private boolean hasLamp;

    // accessors and mutators
    public double getPersonalMoney() {
        return personalMoney;
    }

    public boolean hasLamp() {
        return hasLamp;
    }

    public void setPersonalMoney(double personalMoney) {
        this.personalMoney = personalMoney;
    }

    public void setHasLamp(boolean hasLamp) {
        this.hasLamp = hasLamp;
    }

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

    // instance methods:
    public Room move (Room currentRoom, char direction, HashSet<Integer> roomsVisited){
        HashMap<GameCharacter, Integer> directions = currentRoom.getExit();
        int roomNumber = directions.get(direction);
        roomsVisited.add(roomLookUp.get(roomNumber).getRoomNumber());
        return roomLookUp.get(roomNumber);
    }

    public String exit (HashSet<Integer> roomsVisited) {
        StringBuffer roomName = new StringBuffer();
        StringBuffer roomContents = new StringBuffer();
        Object [] rooms = roomsVisited.toArray();
        for (Object room : rooms){
            roomName.append(roomLookUp.get(room).getRoomName() + "|");
            roomContents.append(roomLookUp.get(room).getContents() + "|");

        }

         if (Math.random()< CHANCE_OF_BEING_FOLLOWED_BY_GHOST) {
             return "You have visited the following (" + rooms.length + ") rooms: " + roomName +
                     "\nYou have seen the following items: " + roomContents +
                     "\nYou have " + String.format("$%.2f", getPersonalMoney())+
                     "\nYou have been followed by ghost as you exited";
         }
         else {
             return "You have visited the following (" + rooms.length + ") rooms: " + roomName +
                     "\nYou have seen the following items: " + roomContents +
                     "\nYou have " + String.format("$%.2f", getPersonalMoney())+
                     "\nYou have exited the house";
             }
     }


}
