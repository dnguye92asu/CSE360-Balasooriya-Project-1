
import java.io.FileNotFoundException;
import java.util.Objects;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class staffUI {

    @FXML
    private Button loginButton;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField usernameField;

    @FXML
    void validateLogin(ActionEvent event) throws FileNotFoundException {
        Employee employee = new Employee(usernameField.getText());
        String whichEmployee = employee.checkEmployee();
        if (whichEmployee.equals("Agent")) {
            try {
                //TODO
                //open the processing agent UI
                Stage agent = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("agent.fxml")));
                agent.setTitle("Pending orders");
                agent.setScene(new Scene(root, 320, 400));
                agent.show();

                //close the login window
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else if (whichEmployee.equals("Cook")) {
            try {
                //TODO
                //open the cook UI
                Stage cook = new Stage();
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("cook.fxml")));
                cook.setTitle("Pending orders");
                cook.setScene(new Scene(root, 760, 400));
                cook.show();

                //close the login window
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
        } else {
            messageLabel.setText("Wrong credentials. Please try again");
        }
    }

}