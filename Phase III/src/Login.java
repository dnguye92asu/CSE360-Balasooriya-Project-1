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
import javafx.stage.Stage;

public class Login extends Application {

    private StackPane mainPane = new StackPane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label role = new Label("What's your role at ASU's Pizza"); // ask to display appropriate UI
        Button studentButton = new Button("Student");
        Button staffButton = new Button("Staff");

        StackPane.setAlignment(role, Pos.CENTER);
        StackPane.setMargin(studentButton, new Insets(50, 60, 0, 0));
        StackPane.setMargin(staffButton, new Insets(50, -60, 0, 0));

        mainPane.getChildren().addAll(role, studentButton, staffButton);
        primaryStage.setTitle("ASU Pizza");
        primaryStage.setScene(new Scene(mainPane, 200, 200));
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
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("staff.fxml")));
                    staffUI.setTitle("Pending orders");
                    staffUI.setScene(new Scene(root, 760, 400));
                    staffUI.show();
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