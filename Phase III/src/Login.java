import java.util.Objects;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Login extends Application {

    private StackPane mainPane = new StackPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label role = new Label("Welcome to ASU Pizza!\nLogin as..."); // ask to display appropriate UI
        role.setTranslateY(-32);
        role.setTextAlignment(TextAlignment.CENTER);
        
        Button studentButton = new Button("Student");
        studentButton.setMinWidth(69);
        studentButton.setTranslateX(-39);
        studentButton.setTranslateY(0);
        
        
        Button staffButton = new Button("Staff");
        staffButton.setMinWidth(69);
        staffButton.setTranslateX(39);
        staffButton.setTranslateY(0);
        
        Button statusButton = new Button("Check Order Status Here");
        statusButton.setTranslateY(30);
        
        //StackPane.setAlignment(role, Pos.TOP_CENTER);
        
        //StackPane.setMargin(studentButton, new Insets(50, 70, 0, 0));
        //StackPane.setMargin(staffButton, new Insets(50, 0, 0, 70));

        mainPane.getChildren().addAll(role, studentButton, staffButton, statusButton);
        primaryStage.setTitle("ASU Pizza");
        primaryStage.setScene(new Scene(mainPane, 200, 200));
        primaryStage.setResizable(false);
        
        primaryStage.show();

        studentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // display pizza order UI as a new Window
                // uses fxml file via SceneBuilder

                try {
                    Stage orderUI = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("student_order.fxml")));
                    orderUI.setTitle("Welcome to ASU's Pizza");
                    orderUI.setScene(new Scene(root, 600, 400));
                    orderUI.resizableProperty().setValue(Boolean.FALSE);
                    orderUI.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                }

            }
        });

        staffButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //open the UI for staff members
                try {
                    //TODO
                    Stage staffUI = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("staffLogin.fxml")));
                    staffUI.setTitle("Pending orders");
                    staffUI.setScene(new Scene(root, 200, 134));
                    staffUI.resizableProperty().setValue(Boolean.FALSE);
                    staffUI.show();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                }
            }
        });
        
        statusButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //open the UI for staff members
                try {
                    //TODO
                    Stage statusUI = new Stage();
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chkStatus.fxml")));
                    statusUI.setTitle("Order Status");
                    statusUI.setScene(new Scene(root, 320, 320));
                    statusUI.resizableProperty().setValue(Boolean.FALSE);
                    statusUI.show();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                    System.err.println(e.getClass().getName() + ": " + e.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}