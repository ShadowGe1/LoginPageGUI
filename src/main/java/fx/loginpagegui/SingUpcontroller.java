package fx.loginpagegui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class SingUpcontroller {
    @FXML
    private Button exit;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button Hey;

    public void date(){
        System.out.println(datePicker.getValue());
    }

    public void exit(){
        System.exit(0);
    }
}
