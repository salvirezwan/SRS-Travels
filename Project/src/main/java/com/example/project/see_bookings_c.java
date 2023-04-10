package com.example.project;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.io.IOException;
import java.sql.ResultSet;


public class see_bookings_c implements Initializable {
    public TableView<modelclass> tableview;
    public TableColumn<modelclass, String> flight;
    public TableColumn<modelclass, String> car;
    public TableColumn<modelclass, String> hotel;

    public TableColumn<modelclass, String> name;

    public TableColumn<modelclass, Integer> room;
    public TableColumn<modelclass, Integer> bookid;
    public TableColumn<modelclass, Integer> totpass;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        flight.setCellValueFactory(new PropertyValueFactory<>("Mflight"));
        car.setCellValueFactory(new PropertyValueFactory<>("Mcar"));
        hotel.setCellValueFactory(new PropertyValueFactory<>("Mhotel"));
        name.setCellValueFactory(new PropertyValueFactory<>("Name1"));
        bookid.setCellValueFactory(new PropertyValueFactory<>("Bookingid1"));
        totpass.setCellValueFactory(new PropertyValueFactory<>("Totalpassenger1"));
        room.setCellValueFactory(new PropertyValueFactory<>("Rooms1"));


        Connection database = null;
        String database1 = "sys";
        String Databaseuser = "root";
        String pass = "sahab123";
        String url1 = "jdbc:mysql://localhost:3306/sys";
        try {

            PreparedStatement p = null;
            database = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "sahab123");
            p = database.prepareStatement("select * from final_booking");


            ResultSet rs = p.executeQuery();
            ObservableList<modelclass> observableList = FXCollections.observableArrayList(
            );
            while (rs.next())
            {
                int a=rs.getInt("bookingid");
                String nm=rs.getString("Name");
                String f=rs.getString("Flight");
                String h=rs.getString("Hotel");
                String c=rs.getString("Car");
                int r=rs.getInt("Rooms");
                int tpass=rs.getInt("Total_Passenger");
              observableList.add(new modelclass(a,nm,h,r,f,c,tpass));
                tableview.setItems(observableList);

            }
        }
        catch (Exception e) {

            System.out.println(e);
        }
    }
    @FXML
    protected void Back3 ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
    }




