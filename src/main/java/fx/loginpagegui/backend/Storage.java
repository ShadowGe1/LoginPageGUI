package fx.loginpagegui.backend;

import java.io.*;
import java.util.TreeMap;

public class Storage {
    private TreeMap<String, Create_Account> AccountInfo = new TreeMap<>();
    private transient String username;
    public Storage() throws ClassNotFoundException {
        loadInfo();
    }
    public void addAccount(Create_Account Acc, String username){
        if(!AccountInfo.containsKey(username)) {
            AccountInfo.put(username, Acc);
        }
    }

    public String userPassword(String username){
        return AccountInfo.get(username).getPassword();
    }

    public byte[] userSalt(String username){
        return AccountInfo.get(username).getSalt();
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
        return "";
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
