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

public class delete_booking_c
{
    @FXML
    private TextField id;

    @FXML
    private Label mylbl;

    @FXML
    protected void done1 ( ActionEvent event ) throws
            IOException
    {

        int n=Integer.parseInt(id.getText());

        Connection database=null;
        String database1="sys";
        String Databaseuser="root";
        String pass="sahab123";
        String url="jdbc:mysql://localhost:3306/sys";
        try{

            PreparedStatement p=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            p=database.prepareStatement("Delete  from final_booking where bookingid = ? ");

            p.setInt(1,n);


            int rowsDeleted =p.executeUpdate();
            mylbl.setText("Booking Removed");


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

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
}
