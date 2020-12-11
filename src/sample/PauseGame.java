package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;

public class PauseGame implements Serializable {
    @FXML
    Button Resume;
    @FXML
    Button Exit;
    @FXML
    Button SaveExit;
    public void changescreen() throws IOException {
        Stage stage = (Stage) Resume.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void resumeButton() throws IOException, ClassNotFoundException { //Resume
        changescreen();
        Start s=new Start();
        File file = new File("Saved.txt");
        file=new File("Highscore.txt");
        s.loadHighScore(file);

    }


}
