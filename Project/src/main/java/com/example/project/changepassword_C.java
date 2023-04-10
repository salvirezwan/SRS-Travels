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

public class changepassword_C
{
    @FXML
    private TextField Username2;
    @FXML
    private PasswordField oldpass;
    @FXML
    private PasswordField newpass;

    @FXML
    private Label mylbl;

    @FXML
    protected void done1 ( ActionEvent event ) throws
            IOException
    {
        String uname=Username2.getText();
        String pword=oldpass.getText();
        String newp=newpass.getText();

        Connection database=null;
        String database1="sys";
        String Databaseuser="root";
        String pass="sahab123";
        String url="jdbc:mysql://localhost:3306/sys";
        try{

            PreparedStatement p=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            p=database.prepareStatement("select * from user_info where username = ? and password = ? ");

            p.setString(1,uname);
            p.setString(2,pword);

            ResultSet rs=p.executeQuery();

            if(rs.next())
            {
                System.out.println(uname);
                PreparedStatement q=null;
                database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
                q=database.prepareStatement("UPDATE user_info SET password = ? where username = ?");

                q.setString(1,newp);
                q.setString(2,uname);
                int rowsUpdated = q.executeUpdate();
                mylbl.setText("Password Changed");
            }
            else
            {

            }

        }
        catch(Exception e)
        {

            System.out.println(e);
        }
    }
    @FXML
    protected void back1 ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("login_Successful_Page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }


}
