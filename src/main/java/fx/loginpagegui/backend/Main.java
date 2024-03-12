package fx.loginpagegui.backend;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Storage storage = new Storage();
        String condition = "no";
        String name, surname, gender, birthday, email, password, username;
        int menu;
        while(condition.equalsIgnoreCase("no")) {
            for (String s : Arrays.asList("Menu:", "1. Log in", "2. Sing up", "3. Delete account", "4. Display all accounts", "5. Exit")) {
                System.out.println(s);
            }
            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1 -> storage.getAccount(storage);
                case 2 -> {
                    Create_Account newAcc = new Create_Account();
                    System.out.println("Enter your name: ");
                    name = sc.nextLine();
                    newAcc.setName(name);
                    System.out.println("Enter your surname: ");
                    surname = sc.nextLine();
                    newAcc.setSurname(surname);
                    System.out.println("Enter your birthday: ");
                    birthday = sc.nextLine();
                    newAcc.setBirthDay(birthday);
                    System.out.println("Enter your gender: ");
                    gender = sc.nextLine();
                    newAcc.setGender(gender);
                    System.out.println("Enter your email: ");
                    email = sc.nextLine();
                    newAcc.setEmail(email);
                    System.out.println("Enter your password: ");
                    password = sc.nextLine();
                    newAcc.setPassword(password);
                    System.out.println("Enter your username: ");
                    username = sc.nextLine();
                    while (!storage.addAccount(newAcc, username)) {
                        System.out.println("This username already exists, enter again");
                        username = sc.nextLine();
                    }
                    System.out.println("Account created successfully");
                }
                case 3 -> {
                    storage.deleteAccount(storage);
                    System.out.println("Account deleted successfully");
                }
                case 4 -> {
                    System.out.println("All accounts: ");
                    storage.toDisplay(storage);
                }
                case 5 -> {
                    condition = "yes";
                    storage.saveInfo();
                }
                default -> System.out.println("The entered option does not exist");
            }
        }
    }
}