package fx.loginpagegui;

import fx.loginpagegui.backend.Storage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class SingUpcontroller {
    @FXML
    private Button exit;
    @FXML
    private Button SignIn;
    @FXML
    private Button userVerify;
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
    private TextField password;
    @FXML
    private TextField repeatPassword;
    private Storage storage = new Storage();
    private final String red ="-fx-border-color: #e53a3a;";

    public SingUpcontroller() throws ClassNotFoundException {
    }

    public void storageReceive(Storage storage) {
       // this.storage = storage;
    }

    public void usernameVerify(){
        if(storage.verifyUsername(username.getText()) || username.getText().isEmpty()){
            username.setStyle(red);
        }
        else {
            username.setStyle("-fx-border-color: #14d014");
        }
    }
    public void date(){
        if(datePicker.getValue() == null){
            datePicker.setStyle(red);
        }
            System.out.println(datePicker.getValue());
    }

    public void exit(){
        System.exit(0);
    }
}
