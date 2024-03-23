package fx.loginpagegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import fx.loginpagegui.backend.Storage;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Button LoginButton;
    @FXML
    private Button exit;
    @FXML
    private Button singUp;
    @FXML
    private TextField Username;
    @FXML
    private TextField Password;
    @FXML
    private Label atention;
    private Stage stage;
    private Parent root;
    Storage storage = new Storage();

    public LogInController() throws ClassNotFoundException {
    }

    public void login(ActionEvent e) throws IOException {
        if(Username.getText().isEmpty()){
            atention.setText("Enter the username");
            return;
        }
        if(Password.getText().isEmpty()){
            atention.setText("Enter the password");
            return;
        }
        atention.setText("");
        String s = storage.verifyUserGUI(Username.getText(), Password.getText(), storage);
        atention.setText(s);
        if(s.isEmpty()){
            displayInfo(e);
        }

    }

    public void displayInfo(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InfoInterface.fxml"));
        root = fxmlLoader.load();

        InfoController infoController = fxmlLoader.getController();
        infoController.displayInfo(Username.getText(), storage.getName(), storage.getSurname(), storage.getBirthday(), storage.getGender(), storage.getEmail());
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void singUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SingUpInterface.fxml"));
        root = fxmlLoader.load();

        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void exit(){
        System.exit(0);
    }
}
