package fx.loginpagegui.backend;

import java.io.Serial;
import java.io.Serializable;

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

    public Create_Account(){
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setBirthDay(String BirthDay){
        BirthDay = BirthDay.substring(0,4) + "." + BirthDay.substring(5,7) + "." + BirthDay.substring(8);
        this.birthDay = BirthDay;
    }

    public void setGender(String gender){
        this.gender = gender.substring(0,1).toUpperCase() + gender.substring(1);
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        GetPassword securePass = new GetPassword(password);
        this.password = securePass.generatedPass;
        this.salt = securePass.salt;
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

