package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectBalls {
    @FXML
    private Rectangle rect;



    public void color1() throws IOException{
        Circle X =new Circle();
        X.setRadius(10);
        X.setFill(Color.WHITE);
        Stage stage = (Stage) rect.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Start s = new Start();

        //s.setBGCOLOR("#ffadad");
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void color2() throws IOException{
        Circle X =new Circle();
        X.setRadius(10);
        X.setFill(Color.WHITE);
        Stage stage = (Stage) rect.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Start s = new Start();

       // s.setBGCOLOR("610024");
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void color3() throws IOException{
        Circle X =new Circle();
        X.setRadius(10);
        X.setFill(Color.WHITE);
        Stage stage = (Stage) rect.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Start s = new Start();

       // s.setBGCOLOR("c39800");
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
}
