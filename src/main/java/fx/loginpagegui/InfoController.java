package fx.loginpagegui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    private ImageView exit;

    public void displayInfo(String username, String name, String surname, String birthday, String gender, String email){
        hello.setText("Hello, " + username);
       this.name.setText(name);
       this.surname.setText(surname);
       this.birthday.setText(birthday);
       this.gender.setText(gender);
       this.email.setText(email);
    }

    public void exit(){
        System.exit(0);
    }
}
