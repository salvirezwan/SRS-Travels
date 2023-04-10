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
import java.sql.ResultSet;

public class admin_login_page_c
{

    @FXML
    private TextField Username1;
    @FXML
    private PasswordField Password1;
    @FXML
    private Label text;

    @FXML
    protected void done ( ActionEvent event ) throws
            IOException
    {
        String uname=Username1.getText();
        String pword=Password1.getText();
        Connection database=null;
        String database1="sys";
        String Databaseuser="root";
        String pass="sahab123";
        String url="jdbc:mysql://localhost:3306/sys";
        try{

            PreparedStatement p=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            p=database.prepareStatement("select * from admin where username = ? and password = ? ");

            p.setString(1,uname);
            p.setString(2,pword);

            ResultSet rs=p.executeQuery();

            if(rs.next())
            {
                Node root = ( Node ) event . getSource () ;
                Stage myStage = ( Stage ) root . getScene () . getWindow () ;

                FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_page.fxml") ) ;
                Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

                myStage.setScene(subtractionScene ) ;
                myStage.show () ;
            }
            else
            {
                text.setText("Invalid Username or Password!!!");
            }

        }
        catch(Exception e)
        {
            text.setText("INVALID");
            System.out.println(e);
        }
    }
    @FXML
    protected void Back ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("hello-view.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }

}
