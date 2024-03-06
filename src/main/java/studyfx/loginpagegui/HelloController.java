package studyfx.loginpagegui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Button LoginButton;

    @FXML
    private TextField myTextField;

    @FXML
    private Label myTextLabel;

    String name;

    public void login(ActionEvent e){
        name = myTextField.getText();
        System.out.println(name);
        myTextLabel.setText("Hello " + name);
    }

}
