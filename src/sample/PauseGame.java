package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class PauseGame {
    @FXML
    Button Resume;
    @FXML
    Button Exit;
    @FXML
    Button SaveExit;
    public void resumeButton() throws IOException { //Resume
        Stage stage = (Stage) Resume.getScene().getWindow();
        stage.close();

    }


}
