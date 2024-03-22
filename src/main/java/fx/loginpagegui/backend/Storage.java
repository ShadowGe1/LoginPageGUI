package fx.loginpagegui.backend;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

public class Storage {
    private TreeMap<String, Create_Account> AccountInfo = new TreeMap<>();
    private transient String username, password;
    private final transient Scanner sc = new Scanner(System.in);
    public Storage() throws ClassNotFoundException {
        loadInfo();
        if(!AccountInfo.containsKey("Pika2030@#")){
            Create_Account admin = new Create_Account("Pika2030@#");
            AccountInfo.put("Pika2030@#", admin);
            System.out.println(AccountInfo.containsKey("Pika2030@#"));
        }
    }
    public boolean addAccount(Create_Account Acc, String username){
        if(!AccountInfo.containsKey(username)) {
            AccountInfo.put(username, Acc);
            return true;
        }
        return false;
    }

    public void getAccount(Storage storage) {
        if(verifyUser(storage)) {
            System.out.println(AccountInfo.get(username).toString());
        }
    }

    public void deleteAccount(Storage storage){
        if(verifyUser(storage)) {
            AccountInfo.remove(username);
        }
    }

    public void toDisplay(Storage storage){
        if(verifyAdmin(storage)) {
            System.out.println(AccountInfo.toString());
        }
    }

    public String userPassword(String username){
        return AccountInfo.get(username).getPassword();
    }

    public byte[] userSalt(String username){
        return AccountInfo.get(username).getSalt();
    }

    private boolean verifyAdmin(Storage storage){
        Sign_In sign_in = new Sign_In(storage);
        System.out.println("Enter admin username: ");
        username = sc.nextLine();
        while(!"Pika2030@#".equals(username)){
            System.out.println("Incorrect admin username, enter again: ");
            username = sc.nextLine();
        }
        System.out.println("Enter admin password: ");
        password = sc.nextLine();
        while(sign_in.correctPassword(username, password)){
            System.out.println("Admin password is incorrect, enter again: ");
            password = sc.nextLine();
        }
        return true;
    }

    private boolean verifyUser(Storage storage){
        Sign_In sign_in = new Sign_In(storage);
        System.out.println("Enter your username: ");
        username = sc.nextLine();
        while (!AccountInfo.containsKey(username)){
            System.out.println("This username doesn't exist, enter again: ");
            username = sc.nextLine();
        }
        System.out.println("Enter your password: ");
        password = sc.nextLine();
        while(sign_in.correctPassword(username, password)){
            System.out.println("The password is incorrect, enter again: ");
            password = sc.nextLine();
        }
        return true;
    }

    public String verifyUserGUI(String username, String password, Storage storage){
        Sign_In sign_in = new Sign_In(storage);
        if(!AccountInfo.containsKey(username)){
            return "This username doesn't exist.";
        }

        if(sign_in.correctPassword(username, password)){
            return "Wrong password.";
        }
        this.username = username;
        return "Hello";
    }

    public boolean verifyUsername(String username){
        return AccountInfo.containsKey(username);
    }

    public String getName(){
        return AccountInfo.get(username).getName();
    }

    public String getSurname(){
        return AccountInfo.get(username).getSurname();
    }

    public String getBirthday(){
        return AccountInfo.get(username).getBirthDay();
    }

    public String getGender(){
        return AccountInfo.get(username).getGender();
    }

    public String getEmail(){
        return AccountInfo.get(username).getEmail();
    }

    public void saveInfo() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("InfoAccounts.ser")
            );
            out.writeObject(AccountInfo);
            out.close();
            System.out.println("The information was well written in the files");
        }catch (IOException e){
            System.out.println("The file cannot be opened or does not exist");
        }
    }

    public void loadInfo() throws ClassNotFoundException {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream("InfoAccounts.ser")
            );
            AccountInfo = (TreeMap<String, Create_Account>) in.readObject();
            in.close();
            System.out.println("The information was successfully extracted from the file");
        }catch (IOException e){
            System.out.println("The file cannot be opened or there is no information");
        }
    }
}
