package fx.loginpagegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoController {
    @FXML
    private Label hello;
    @FXML
    private Label name;
    @FXML
    private Label surname;
    @FXML
    private Label birthday;
    @FXML
    private Label gender;
    @FXML
    private Label email;
    @FXML
    private Button exit;
    @FXML
    private Button back;

    public void displayInfo(String username, String name, String surname, String birthday, String gender, String email){
        hello.setText("Hello, " + username);
       this.name.setText(name);
       this.surname.setText(surname);
       this.birthday.setText(birthday);
       this.gender.setText(gender);
       this.email.setText(email);
    }

    public void backToLogIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogInInterface.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(){
        System.exit(0);
    }
}
