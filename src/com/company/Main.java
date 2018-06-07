package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        String choice;
        int countNum=1;
        Foyer foyer= new Foyer();
        System.out.println(foyer.displayContent());
        System.out.println(foyer.displayExitMessage());
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();
        if(foyer.changeStringToChar(choice) != 'q') {
            String choice1;
            char direction = foyer.changeStringToChar(choice);
            if (direction != 0) {
                Room newRoom = user.move(foyer, direction);
                System.out.println(newRoom.displayContent());
                System.out.println(newRoom.displayExitMessage());
                choice1 = scanner.next();
                while (newRoom.changeStringToChar(choice1) != 'q') {
                    countNum++;
                    newRoom = user.move(newRoom, newRoom.changeStringToChar(choice1));
                    System.out.println(newRoom.displayContent());
                    System.out.println(newRoom.displayExitMessage());
                    System.out.println("You visited "+countNum+" rooms.");
                    choice1 = scanner.next();
                    //System.out.println("Room number: "+newRoom.getRoomNumber());
                }
            } else {
                System.out.println("That is not one of the valid options.\nPlease enter a valid option next time.");
                System.exit(-1);
            }
        }
    }
}
