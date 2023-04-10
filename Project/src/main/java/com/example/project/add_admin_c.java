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

public class add_admin_c
{
    @FXML
    private TextField Username1;
    @FXML
    private PasswordField Password1;
    @FXML
    private Label mylbl;

    @FXML
    private void back2(ActionEvent event) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
    @FXML
    private void done2(ActionEvent event) throws
            IOException {
        String uname = Username1.getText();
        String pword = Password1.getText();



        Connection database = null;
        String database1 = "sys";
        String Databaseuser = "root";
        String pass = "sahab123";
        String url = "jdbc:mysql://localhost:3306/sys";

        try {

            PreparedStatement p = null;
            database = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "sahab123");
            p = database.prepareStatement("insert into admin(username,password)values(?,?)");

            p.setString(1, uname);
            p.setString(2,pword);



            p.executeUpdate();
            mylbl.setText("Admin Added");


        } catch (Exception e) {
        }
    }
}
