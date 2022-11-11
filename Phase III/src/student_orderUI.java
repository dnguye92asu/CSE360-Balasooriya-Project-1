package com.example.project360fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.util.Queue;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class student_orderUI {


    File order;
    File orderNums = new File("C:\\Users\\Wesj2\\Desktop\\Orders.txt");
    Pizza_Order pizza;
    String orderNum = "";


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
        boolean mush = false;
        boolean ex = false;
        boolean onion = false;
        boolean olive = false;
        String type = "";

        if(mushroomButton.isSelected()){
            mush = true;
        }
        if(extraButton.isSelected()){
            ex = true;
        }
        if(onionButton.isSelected()){
            onion = true;
        }
        if(olivesButton.isSelected()){
            olive = true;
        }

        if(pepperoniButton.isSelected()){
            type = "Pepperoni";
        }
        else if(cheeseButton.isSelected()){
            type = "Cheese";
        }
        else if(vegButton.isSelected()){
            type = "Vegetable";
        }
        else{
            orderTextArea.setText("Please Select a Pizza Type!!!");
            return;
        }


        pizza = new Pizza_Order(type,mush,onion,olive,ex,orderNum);

        orderTextArea.setText(pizza.print_order());
        totalTextArea.setText("$" + String.format("%.2f",pizza.get_Price()));


        loginPopup.setVisible(true);
    }


    @FXML
    void validateLogin(ActionEvent event) throws IOException {
        boolean bool;
        messageLabel.setWrapText(true);
        Customer student = new Customer(usernameField.getText());
        pizza.set_Num(usernameField.getText());
        bool = student.checkStudent();
        //placeholder credentials
        if (bool) {
            orderTextArea.setText("Your order has been placed!!\n" + pizza.print_order());
            loginPopup.setVisible(false);
            order = new File(pizza.get_Num() + ".txt");
            FileWriter myWriter = new FileWriter(pizza.get_Num() + ".txt");
            myWriter.write(pizza.print_order());
            myWriter.close();
            FileWriter myWriter2 = new FileWriter("C:\\Users\\Wesj2\\Desktop\\Orders.txt", true);
            myWriter2.write(pizza.get_Num() + "\n");
            myWriter2.close();



        }
        else {
            messageLabel.setText("Wrong credentials, please try again");
        }
    }

}