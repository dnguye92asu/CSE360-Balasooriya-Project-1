
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NotifUI {
	@FXML
	private Button okButton;
	@FXML
	private Label titleLabel;
	@FXML
	private Label messageLabel;

	// Event Listener on Button[#okButton].onAction
	@FXML
	public void close(ActionEvent event) {
		// TODO Autogenerated
		Stage stage = (Stage) okButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
}
