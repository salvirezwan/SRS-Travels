package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class signup_page_c
{
    @FXML
    private TextField Username1;
    @FXML
    private TextField name;
    @FXML
    private TextField age;
    @FXML
    private TextField gender;
    @FXML
    private TextField email;
    @FXML
    private PasswordField Password1;
    @FXML
    private Label l;
    @FXML
    private void back(ActionEvent event) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("user_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
    @FXML
    private void signup(ActionEvent event) throws
            IOException {
        String uname = Username1.getText();
        String pword = Password1.getText();
        String gender1 = gender.getText();
        String email1 = email.getText();
        String name1 = name.getText();

        int age1 = Integer.parseInt(age.getText());
        Connection database = null;
        String database1 = "sys";
        String Databaseuser = "root";
        String pass = "sahab123";
        String url = "jdbc:mysql://localhost:3306/sys";

        try {

            PreparedStatement p = null;
            database = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "sahab123");
            p = database.prepareStatement("insert into user_info(Name,Age,Gender,Email,username,password)values(?,?,?,?,?,?)");

            p.setString(1, name1);
            p.setInt(2, age1);
            p.setString(3, gender1);
            p.setString(4, email1);
            p.setString(5, uname);
            p.setString(6, pword);

            p.executeUpdate();
            l.setText("Registered Successfully!");


        } catch (Exception e) {

        }
    }
}

