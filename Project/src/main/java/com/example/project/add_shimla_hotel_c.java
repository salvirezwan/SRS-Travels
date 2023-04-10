package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;

import java.sql.*;

public class add_shimla_hotel_c {
    @FXML
    private TextField hotel_name;

    @FXML
    private TextField location_name;

    @FXML
    private TextField category_name;

    @FXML
    private Label x;
    @FXML
    protected void done ( )
    {
        String hname=hotel_name.getText();
        String lname=location_name.getText();
        String cname=category_name.getText();
        Connection database=null;
        String database1="sys";
        String Databaseuser="root";
        String pass="sahab123";
        String url="jdbc:mysql://localhost:3306/sys";

        try
        {
            PreparedStatement stmt=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            stmt=database.prepareStatement("insert into shimlahotel(hotel,location,category) values(?,?,?)");

            stmt.setString(1,hname);
            stmt.setString(2,lname);
            stmt.setString(3,cname);

            stmt.executeUpdate();
            x.setText("Hotel has been added");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void Back ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
}
