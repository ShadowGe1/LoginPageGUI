package fx.loginpagegui;

import fx.loginpagegui.backend.Create_Account;
import fx.loginpagegui.backend.Email_Verify;
import fx.loginpagegui.backend.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SingUpcontroller {
    @FXML
    private Button exit;
    @FXML
    private Button SignIn;
    @FXML
    private Button userVerify;
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton male;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatPassword;
    @FXML
    private Label incorrectPass;
    @FXML
    private Label notSelectedGender;
    private String birthdayModify;
    private final Storage storage = new Storage();
    private final String red = "-fx-border-color: #e53a3a";
    private final String green = "-fx-border-color: #14d014";
    public SingUpcontroller() throws ClassNotFoundException {
    }

    public boolean usernameVerify(){
        if(storage.verifyUsername(username.getText()) || username.getText().length() <= 4){
            username.setStyle(red);
            return false;
        }
        else {
            username.setStyle(green);
            return true;
        }
    }

    public boolean nameVerify(){
        if(name.getText().length() <= 3){
            name.setStyle(red);
            return false;
        }
        else {
            name.setStyle(green);
            return true;
        }
    }

    public boolean surnameVerify(){
        if(surname.getText().length() <= 3){
            surname.setStyle(red);
            return false;
        }
        else {
            surname.setStyle(green);
            return true;
        }
    }

    public String setGender(){
        if(male.isSelected()){
            return male.getText();
        }
        else if(female.isSelected()){
            return female.getText();
        }
        else {
            notSelectedGender.setText("Select your gender!");
            return "";
        }
    }

    public boolean emailVerify(){
        Email_Verify emailVerify = new Email_Verify();
        if(!emailVerify.isEmailValis(email.getText())){
            email.setStyle(red);
            return false;
        }
        else {
            email.setStyle(green);
            return true;
        }
    }

    public boolean date(){
        if(datePicker.getValue() == null){
            datePicker.setStyle(red);
            return false;
        }
        else {
            datePicker.setStyle(green);
            birthdayModify = String.valueOf(datePicker.getValue());
            return true;
        }
    }

    public boolean passwordVerify(){
        if(password.getText().length() <= 7){
            password.setStyle(red);
            incorrectPass.setText("Minimum 8 characters!");
            return false;
        }
        else {
            incorrectPass.setText("");
            password.setStyle(green);
            if (!password.getText().equals(repeatPassword.getText())) {
                repeatPassword.setStyle(red);
                return false;
            }
            else {
                repeatPassword.setStyle(green);
                return true;
            }
        }
    }

    public void singIn(ActionEvent event) throws IOException {
        if(usernameVerify() && nameVerify() && surnameVerify() && !(setGender().isEmpty()) && emailVerify() && date() && passwordVerify()){
            Create_Account newAcc = new Create_Account();
            newAcc.setName(name.getText());
            newAcc.setSurname(surname.getText());
            newAcc.setGender(setGender());
            newAcc.setBirthDay(birthdayModify);
            newAcc.setEmail(email.getText());
            newAcc.setPassword(password.getText());
            storage.addAccount(newAcc, username.getText());
            storage.saveInfo();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInInterface.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void exit(){
        System.exit(0);
    }
}
