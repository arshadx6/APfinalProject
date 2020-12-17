package sample;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResumeGame implements Initializable {
    @FXML
    Button Back;
    @FXML
    Text Player1;
    @FXML
    Text Player2;
    @FXML
    Text Player3;
    @FXML
    Button b1;
    @FXML
    Button b2;
    @FXML
    Button b3;
    @FXML
    Text Saved;
    @FXML
    AnchorPane bg;
    @FXML
    ImageView bImage;
   static Start s;
   static Main mainapp;

    public void setMainapp(Main mainapp) {
        this.mainapp = mainapp;
    }

    public static Main getMainapp() {
        return mainapp;
    }

    public void setS(Start s) {
        this.s = s;
    }

    public void changescreen() throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void changeStart1() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();

        File file = new File("Saved.txt");
        Stage primaryStage =new Stage();


        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
        this.s.loadGameDataFromFile(file,1);
    }
    public void changeStart2() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();

        File file = new File("Saved.txt");
        Stage primaryStage =new Stage();


        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
        this.s.loadGameDataFromFile(file,2);
    }
    public void changeStart3() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.close();

        File file = new File("Saved.txt");
        Stage primaryStage =new Stage();


        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));

        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
        this.s.loadGameDataFromFile(file,3);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(500));
        translateTransition.setNode(bImage);
        translateTransition.setByX(-20);
        translateTransition.setCycleCount(500);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        ResumeGame x= new ResumeGame();
        bg.setStyle("-fx-background: #" + "272727");
        Saved.setFont(Font.font("Verdana",30));
        Saved.setText("0 Saved Games");
        Saved.setFill(Color.WHITE);
//        Player1.setFont(Font.font("Verdana",15));
//        Player2.setFont(Font.font("Verdana",15));
//        Player3.setFont(Font.font("Verdana",15));
//        Player1.setText("-");
//        Player1.setFill(Color.WHITE);
//        Player2.setText("-");
//        Player2.setFill(Color.WHITE);
//        Player3.setText("-");
//        Player3.setFill(Color.WHITE);
//        try {
//            changeStart();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Start s=new Start();
        File file = new File("Saved.txt");
        ArrayList<ListofSerializable> games=null;
        int players=0;
        try {
            games=s.checkload(file);
            players=games.size();
            System.out.println(players+"THIS IS NO OF SAVE FILES");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        if(players==1){
            Saved.setText(players +" Saved Game");
        }
        else{
            Saved.setText(players+" Saved Games");
        }

        for(int i=1;i<=players;i++){
            if(i==1){
                Player1.setFill(Color.WHITE);
                Player1.setText("PLAYER 1 SAVE AVAILABLE");
            }
            if(i==2){
                Player2.setFill(Color.WHITE);
                Player2.setText("PLAYER 2 SAVE AVAILABLE");
            }
            if(i==3){
                Player3.setFill(Color.WHITE);
                Player3.setText("PLAYER 3 SAVE AVAILABLE");
            }
        }
    }

}
