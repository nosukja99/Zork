package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        String choice;
        Foyer foyer= new Foyer();
        System.out.println(foyer.displayContent());
        System.out.println(foyer.displayExitMessage());
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();
        if(foyer.changeStringToChar(choice) != 'q') {
            String choice1;
            Room newRoom = user.move(foyer, foyer.changeStringToChar(choice));
            System.out.println(newRoom.displayContent());
            System.out.println(newRoom.displayExitMessage());
            choice1 = scanner.next();
            while(newRoom.changeStringToChar(choice1) !='q') {
                Room newRoom2 = user.move(newRoom, newRoom.changeStringToChar(choice1));
                System.out.println(newRoom2.displayContent());
                System.out.println(newRoom2.displayExitMessage());
                choice1 = scanner.next();
                //System.out.println("Room number: "+newRoom.getRoomNumber());
            }
        }
    }
}
