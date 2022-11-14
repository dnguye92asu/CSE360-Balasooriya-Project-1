
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class AgentUI {
	@FXML
	private TitledPane pendingPane;
	@FXML
	private Button readyButton;
	@FXML
	private ListView<String> pendingList;
	@FXML
	private Button detailsButton;
	@FXML
	private Button okButton;
	@FXML
	private TextArea orderDetails;
	@FXML
	private AnchorPane detailsPane;

	// reads Orders.txt, lists all pending orders
	public void initialize() {
		try {
            //TODO
        	String orderNum = "";
            File orderFile = new File("Orders.txt");
            
            if (orderFile.isFile()) {
            	Scanner sc = new Scanner(orderFile);
            	while (sc.hasNextLine()) {
            		orderNum = sc.nextLine();
            		
            		File oFile = new File(orderNum + ".txt");
            		if (oFile.isFile()) {
                    	Scanner sc2 = new Scanner(oFile);
                    	String line = "";
                    	while (sc2.hasNextLine()) {
                    		line = sc2.nextLine();
                    	}
                    	line = line.substring(8);
                    	
                    	if (line.equals("New Order"))
                    		pendingList.getItems().add(orderNum);
                    	sc2.close();
            		}
            	}
            sc.close();
            }
            else {
            	
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
	}
	
	// Event Listener on Button[#readyButton].onAction
	@FXML
	public void readyOrder(ActionEvent event) {
		ObservableList<String> selected = pendingList.getSelectionModel().getSelectedItems();
		String order = selected.get(0);
		if (order != null)
		{
			try {
				File oFile = new File(order + ".txt");
				if (oFile.isFile()) {
					String oldContent = "";
	            	Scanner sc = new Scanner(oFile);
	            	while (sc.hasNextLine()) {
	            		oldContent += (sc.nextLine() + "\n");
	            	}
	            	sc.close();
	            	
	            	String newContent = oldContent.replaceAll("Status: New Order\n", "Status: Ready To Cook");
	            	
	            	FileWriter writer = new FileWriter(oFile);
	            	writer.write(newContent);
	            	writer.close();
	            	
	            	pendingList.getItems().clear();
	            	initialize();
				}
				
			} catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
	        }
		}
		
	}
	
	// Event Listener on Button[#detailsButton].onAction
	@FXML
	public void getOrderDetails(ActionEvent event) {
		ObservableList<String> selected = pendingList.getSelectionModel().getSelectedItems();
		String order = selected.get(0);
		if (order != null)
		{
			try {
	            File oFile = new File(order + ".txt");
	            //placeholder credentials
	            if (oFile.isFile()) {
	            	Scanner sc = new Scanner(oFile);
	            	String line = "";
	            	while (sc.hasNextLine()) {
	            		line += (sc.nextLine() + "\n");
	            	}
	            sc.close();
	            orderDetails.setText(line);
	            detailsPane.setVisible(true);
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            System.err.println(e.getClass().getName() + ": " + e.getMessage());
	        }
		}
	}
	
	// Event Listener on Button[#detailsButton].onAction
		@FXML
		public void closeDetails(ActionEvent event) {
			detailsPane.setVisible(false);
		}
}
