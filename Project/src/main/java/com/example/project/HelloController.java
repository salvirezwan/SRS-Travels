package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onuserbuttonclicked ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("user_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
    @FXML
    protected void admin ( ActionEvent event ) throws
            IOException {
        Node root = ( Node ) event . getSource () ;
        Stage myStage = ( Stage ) root . getScene () . getWindow () ;

        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication . class.getResource ("admin_login_page.fxml") ) ;
        Scene subtractionScene = new Scene ( fxmlLoader . load ()) ;

        myStage.setScene(subtractionScene ) ;
        myStage.show () ;
    }
}