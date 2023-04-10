package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import javafx . application . Application ;
import javafx . fxml . FXMLLoader ;
import javafx . scene . Scene ;
import javafx.scene.paint.Color;
import javafx . stage . Stage ;
import javafx.stage.StageStyle;

import java.io.IOException ;

public class HelloApplication extends Application {


    @Override
    public void start ( Stage stage ) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader ( HelloApplication.class.getResource ("hello-view.fxml")) ;
        Scene scene = new Scene (fxmlLoader.load(),Color.LIGHTBLUE) ;
        stage.setTitle ("SRS Travels!") ;
        stage.initStyle(StageStyle.UNDECORATED);

        stage.setScene ( scene ) ;
        stage.show () ;
    }

    public static void main ( String [] args )
    {

        launch () ;
    }
    public static String currentuser="";

}