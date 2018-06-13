package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        User user = new User();
        String choice;
        HashSet<Integer> roomsVisited = new HashSet<>();
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
        Random rand = new Random();
        int randValue = rand.nextInt(8);
        int testValue = 0;
        testValue = locateLamp (user, random, testValue);
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
                testValue = locateLamp(user, randValue, testValue);
                System.out.println(newRoom.displayExitMessage());
                choice1 = scanner.next();
                while (newRoom.changeStringToChar(choice1) != 'q') {
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
                    testValue = locateLamp(user, randValue, testValue);
                    System.out.println(newRoom.displayExitMessage());
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

    private static int locateLamp(User user, int randValue, int testValue) {
        if (randValue==testValue){
            user.setHasLamp(true);
            testValue++;
        }
        else {
            testValue++;
        }
        return testValue;
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
