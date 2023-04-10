package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import java.util.Random;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class kashmir_booking_page_c implements Initializable
{
    @FXML
    protected void Back ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("destination_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private ChoiceBox<String> flights;
    @FXML
    private ChoiceBox<String> cars;

    @FXML
    private ChoiceBox<String> rooms;

    @FXML
    private TextField passenger;

    @FXML
    private Label l;


    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/sys", "root", "sahab123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try {
            rs = stmt.executeQuery("SELECT * FROM kashmir_hotel");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true)
        {
            try {
                if (!rs.next()) break;
                myChoiceBox.getItems().addAll(rs.getString(1));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            rs = stmt.executeQuery("SELECT * FROM kashmir_flight");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while(true)
        {
            try {
                if (!rs.next()) break;
                flights.getItems().addAll(rs.getString(1));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            rs = stmt.executeQuery("SELECT * FROM kashmir_car");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while(true)
        {
            try {
                if (!rs.next()) break;
                cars.getItems().addAll(rs.getString(1));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        rooms.getItems().add("1");
        rooms.getItems().add("2");
        rooms.getItems().add("3");


    }

    @FXML
    protected void add() {
        String hotel_name = myChoiceBox.getValue();
        String flight_name = flights.getValue();
        String car_name = cars.getValue();
        String r_num=rooms.getValue();
        String tot_pass=passenger.getText();
        int a=Integer.parseInt(tot_pass);
        Connection database = null;
        Random rand = new Random();
        int randomNumber = rand.nextInt(100000);
        String cuser=HelloApplication.currentuser;



        try
        {
            PreparedStatement stmt=null;
            database= DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root","sahab123");
            stmt=database.prepareStatement("insert into final_booking(bookingid,Name,Hotel,Rooms,Flight,Car,Total_Passenger) values(?,?,?,?,?,?,?)");


            stmt.setInt(1,randomNumber);
            stmt.setString(2,cuser);
            stmt.setString(3,hotel_name);
            stmt.setString(4,r_num);
            stmt.setString(5,flight_name);
            stmt.setString(6,car_name);
            stmt.setInt(7,a);

            l.setText("Successfully booked!");
            stmt.executeUpdate();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
