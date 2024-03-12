package studyfx.loginpagegui.backend;

import java.io.Serial;
import java.io.Serializable;
import java.util.Scanner;

public class Create_Account implements Serializable {
    @Serial
    private static final long serialVersionUID = 2003111820040224L;
    private String name;
    private String surname;
    private String birthDay;
    private String gender;
    private String email;
    private String password;
    private byte[] salt;
    private final transient Scanner sc = new Scanner(System.in);
    Create_Account(String password){
        setPassword(password);
    }

    Create_Account(){
    }

    public void setName(String name){
        while(name.length() <= 4){
            System.out.println("The name is invalid, enter again: ");
            name = sc.nextLine();
        }
        this.name = name;
    }

    public void setSurname(String surname){
        while(surname.length() <= 4){
            System.out.println("The surname is invalid, enter again: ");
            surname = sc.nextLine();
        }
        this.surname = surname;
    }
    public void setBirthDay(String BirthDay){
        while(!isBirthdayOk(BirthDay)){
                System.out.println("Incorrect birthday, enter again in this format: yyyyMMdd ");
                BirthDay = sc.nextLine();
                isBirthdayOk(BirthDay);
        }
        BirthDay = BirthDay.substring(0,4) + "." + BirthDay.substring(4,6) + "." + BirthDay.substring(6);
        this.birthDay = BirthDay;
    }

    public void setGender(String gender){
        while(!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))){
            System.out.println("Error!! Enter Male/Female: ");
            gender = sc.nextLine();
        }
        this.gender = gender.substring(0,1).toUpperCase() + gender.substring(1);
    }

    public void setEmail(String email){
        Email_Verify verify = new Email_Verify();
        while(!verify.isEmailValis(email)){
            System.out.println("Invalid email!! Enter again: ");
            email = sc.nextLine();
        }
        this.email = email;
    }

    public void setPassword(String password){
        while(password.length() < 8){
            System.out.println("The password must be at least 8 characters: ");
            password = sc.nextLine();
        }
        GetPassword securePass = new GetPassword(password);
        this.password = securePass.generatedPass;
        this.salt = securePass.salt;
    }

    private boolean isBirthdayOk(String BirthDay){
        if(BirthDay == null || BirthDay.length() != "yyyyMMdd".length()){
            return false;
        }

        int date;
        try{
            date = Integer.parseInt(BirthDay);
        }catch (NumberFormatException e){
            System.out.println("Incorrect format");
            return false;
        }

        int year = date / 10000;
        int month = (date / 100) % 100;
        int day = date % 100;

        boolean isYearOk = (year >= 1900) && (year <= 2024);
        boolean isMonthOk = (month >= 1) && (month <= 12);
        boolean isDayOk = day <= isDayOk(month, year);
        return isYearOk && isMonthOk && isDayOk;
    }
    private int isDayOk(int month, int year){
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return 31;
            }
            case 4, 6, 9, 11 -> {
                return 30;
            }
            case 2 -> {
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            }
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }

    public String toString(){
        return "1.Name: " + name +
                "\n2.Surname: " + surname +
                "\n3.Birthday: " + birthDay +
                "\n4.Gender: " + gender +
                "\n5.Email: " + email + "\n";
    }
}

