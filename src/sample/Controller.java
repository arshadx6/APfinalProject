package sample;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private Button Start;
    @FXML
    private AnchorPane main;
    public void changescreen() throws IOException{
        Stage stage = (Stage) Start.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        primaryStage.show();
    }

}
