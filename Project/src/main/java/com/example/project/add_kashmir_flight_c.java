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

public class add_kashmir_flight_c {
    @FXML
    private TextField flight_name;

    @FXML
    private TextField model;

    @FXML
    private TextField total_capacity;

    @FXML
    private Label x;



    @FXML
    protected void done ( )
    {
        String fname=flight_name.getText();
        String mname=model.getText();
        String tname=total_capacity.getText();
        Connection database=null;
        String database1="sys";
        String Databaseuser="root";
        String pass="sahab123";
        String url="jdbc:mysql://localhost:3306/sys";

        try
        {
            PreparedStatement stmt=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            stmt=database.prepareStatement("insert into kashmir_flight(flight_name,flight_model,total_capacity) values(?,?,?)");

            stmt.setString(1,fname);
            stmt.setString(2,mname);
            stmt.setString(3,tname);

            stmt.executeUpdate();
            x.setText("Flight has been added");

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
