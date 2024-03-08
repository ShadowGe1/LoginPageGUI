package studyfx.loginpagegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField Username;

    @FXML
    private TextField Password;
    @FXML
    private Label atention;
    String username, password;

    public void login(ActionEvent e){
        if(Username.getText().isEmpty()){
            atention.setText("Enter the username pls!!!");
            return;
        }
        if(Password.getText().isEmpty()){
            atention.setText("Enter the password!!!");
            return;
        }
        atention.setText("");
        username = Username.getText();
        password = Password.getText();
        System.out.println(username);
        System.out.println(password);
    }

}
