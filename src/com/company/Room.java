package com.company;

import java.util.HashMap;

/* This is the main abstract method for all the rooms. It shares all the attributes and features commmon to all rooms.*/
abstract class Room {


    // instance variables:

    // instance methods:
    public abstract int getRoomNumber();
    public abstract HashMap getExit();
    public abstract String displayContent (User user);
    public abstract String displayExitMessage();
    public abstract char changeStringToChar(String s);
    public abstract void setRandomAmountOfMoney();
    public abstract double getAmountOfMoney ();
    public abstract void setMoney (double money);
    public abstract void takeMoney (User user);
}
