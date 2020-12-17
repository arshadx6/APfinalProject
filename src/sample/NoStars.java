package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoStars implements Initializable {
    @FXML
    private AnchorPane Back;
    public void changescreen() throws IOException{
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();


        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));

        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Back.setStyle("-fx-background: #" + "272727");

    }
}
