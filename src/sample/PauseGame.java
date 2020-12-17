package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class PauseGame implements Serializable {
    private static Start temp=new Start();

    public static void setTemp(Start temp) {
        PauseGame.temp = temp;
    }

    @FXML
    private Button Resume;
    @FXML
    private Button Exit;
    @FXML
    private Button SaveExit;
    @FXML
    private AnchorPane bg;
    public void changescreen() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) Resume.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        try{
            this.temp.loadRevive(new File("Revive.txt"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }

    public void exit() throws IOException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void saveandExit() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) Exit.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        this.temp.save(new File("Saved.txt"));
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }

}
