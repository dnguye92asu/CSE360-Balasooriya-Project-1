import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class student_orderUI {

    @FXML
    private RadioButton cheeseButton;

    @FXML
    private CheckBox extraButton;

    @FXML
    private ToggleGroup group;

    @FXML
    private Button loginButton;

    @FXML
    private AnchorPane loginPopup;

    @FXML
    private Label messageLabel;

    @FXML
    private CheckBox mushroomButton;

    @FXML
    private CheckBox olivesButton;

    @FXML
    private CheckBox onionButton;

    @FXML
    private TextArea orderTextArea;

    @FXML
    private AnchorPane parentPane;

    @FXML
    private PasswordField passwordField;

    @FXML
    private RadioButton pepperoniButton;

    @FXML
    private Label pizzaTypeLabel;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Label summaryLabel;

    @FXML
    private Label toppingLabel;

    @FXML
    private TextArea totalTextArea;

    @FXML
    private TextField usernameField;

    @FXML
    private RadioButton vegButton;

    
    @FXML
    void placeOrder(ActionEvent event) {
        loginPopup.setVisible(true);
    }

    @FXML
    void validateLogin(ActionEvent event) {
        messageLabel.setWrapText(true);
        //placeholder credentials
        if (usernameField.getText().equals("asustudent") && passwordField.getText().equals("12345")) {
            messageLabel.setText("Your order has been placed!!");

            //accept order
            //TODO

        }
        else {
            messageLabel.setText("Wrong credentials, please try again");
        }
    }

}