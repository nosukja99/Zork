package com.company;

import java.util.HashMap;

/* This is the main abstract method for all the rooms. It shares all the attributes and features commmon to all rooms.*/
abstract class Room {

    public abstract int getRoomNumber();
    // instance variables:
    public abstract HashMap getExit();
    // instance methods:
    public abstract String displayContent ();
    public abstract String displayExitMessage();
}
