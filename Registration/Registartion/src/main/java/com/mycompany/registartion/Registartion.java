package com.mycompany.registartion;

import java.util.Scanner;

public class Registartion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variables for user data
        String firstName = "";
        String lastName = "";
        String username = "";
        String password = "";
        String phoneNumber = "";
        
        Login user = null;
        boolean loggedIn = false;
        
        System.out.println("=== Welcome to the Message App ===");
        
        while (!loggedIn) {
            System.out.println("\n1.Resgister");
            System.out.println("2. Login");
            System.out.println("Choose an option: ");
            
            int choice = 0;
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
            }else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();
            
            if (choice == 1) {
                
                    //Registration
                    System.out.print("Enter first name: ");
                    firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    lastName = scanner.nextLine();
                    System.out.print("Enter a username:");
                    username = scanner.nextLine();
                    System.out.print("Enter a password: ");
                    password = scanner.nextLine();
                    System.out.print("Enter a cellphone number: ");
                    phoneNumber = scanner.nextLine();
                    
                    user = new Login(firstName, lastName,username, password, phoneNumber);
                    System.out.println(user.registerUser());
                    break;
            }else if  (choice == 2) {
                    // Login 
                    if (user == null){ 
                        System.out.println("No user registered yet. Please register first.");
                        continue;
                    }
                    System.out.print("Enter a username: ");
                    String enteredUsername = scanner.nextLine();
                    System.out.print("Enter a password: ");
                    String enteredPassword = scanner.nextLine();
                    
                    String status = user.returnLoginStatus(enteredUsername, enteredPassword);
                    System.out.println(status);
                    
                    if (status.startsWith("Welcome")) {
                        loggedIn = true;
                    }
            }else {
                    System.out.println("Invalid choice. Please enter 1 or 2");
   
                    
            }
            
        }
    }
}