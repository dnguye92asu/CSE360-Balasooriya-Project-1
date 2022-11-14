
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class checkUI {

    @FXML
    private Button loginButton;
    
    @FXML
    private Button refreshButton;

    @FXML
    private Label messageLabel;

    @FXML
    private TextField usernameField;
    
    @FXML
    private TextArea orderField;
    
    @FXML
    private AnchorPane popupPane;

    @FXML
    void validateLogin(ActionEvent event) throws IOException {
        try {
            //TODO
        	String orderNum = usernameField.getText();
            File oFile = new File(orderNum + ".txt");
            //placeholder credentials
            if (oFile.isFile()) {
            	Scanner sc = new Scanner(oFile);
            	String line = "";
            	while (sc.hasNextLine()) {
            		line += (sc.nextLine() + "\n");
            	}
            sc.close();
            orderField.setText(line);
            popupPane.setVisible(false);
            }
            else {
                messageLabel.setText("No order found...");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

}