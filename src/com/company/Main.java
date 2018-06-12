package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        String choice;
        HashSet<Integer> roomsVisited = new HashSet<>();
        int countNum=1;
        Foyer foyer= new Foyer();
        roomsVisited.add(foyer.getRoomNumber());
        System.out.println(foyer.displayContent(user));
        System.out.println("Do you want to take the money in the room? (y/n)");
        Scanner in = new Scanner (System.in);
        String moneyChoice = in.next();
        if (moneyChoice.equalsIgnoreCase("y")){
            foyer.takeMoney(user);
        }
        Random rnd = new Random();
        int random = rnd.nextInt(8);
        int keyValue = 0;
        keyValue = robUser(user, random, keyValue);
        System.out.println(foyer.displayExitMessage());
        Scanner scanner = new Scanner(System.in);
        choice = scanner.next();
        if (choice.equalsIgnoreCase("q")) System.out.println(user.exit(roomsVisited));
        if(foyer.changeStringToChar(choice) != 'q') {
            String choice1;
            char direction = foyer.changeStringToChar(choice);
            if (direction != '0') {
                Room newRoom = user.move(foyer, direction, roomsVisited);
                System.out.println(newRoom.displayContent(user));
                System.out.println("Do you want to take the money in the room? (y/n)");
                moneyChoice = in.next();
                if (moneyChoice.equalsIgnoreCase("y")){
                    newRoom.takeMoney(user);
                }
                keyValue = robUser(user, random, keyValue);
                System.out.println(newRoom.displayExitMessage());
                choice1 = scanner.next();
                while (newRoom.changeStringToChar(choice1) != 'q') {
                    countNum++;
                    char newDirection = newRoom.changeStringToChar(choice1);
                    if (newDirection=='0') {
                        System.out.println("That is not one of the valid options.\nPlease enter a valid option next time.");
                        break;
                    }
                    newRoom = user.move(newRoom, newDirection, roomsVisited);
                    System.out.println(newRoom.displayContent(user));
                    System.out.println("Do you want to take the money in the room? (y/n)");
                    moneyChoice = in.next();
                    if (moneyChoice.equalsIgnoreCase("y")){
                        newRoom.takeMoney(user);
                    }
                    keyValue = robUser(user, random, keyValue);
                    System.out.println(newRoom.displayExitMessage());
                    System.out.println("You visited "+countNum+" rooms.");
                    choice1 = scanner.next();

                }
            }
            else if (foyer.changeStringToChar(choice) == 'q'){
                System.out.println(user.exit(roomsVisited));
            }
            else {
                System.out.println("That is not one of the valid options.\nPlease enter a valid option next time.");
                System.exit(-1);
            }
            System.out.println(user.exit(roomsVisited));
        }
    }

    public static int robUser(User user, int random, int keyValue) {
        if (random == keyValue){
            GameCharacter c = new GameCharacter();
            System.out.println(c.takeMoneyFromUser(user));
            keyValue++;
        }
        else {
            keyValue++;
        }
        return keyValue;
    }
}
