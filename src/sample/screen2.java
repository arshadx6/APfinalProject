package sample;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class screen2 implements Serializable {
    @FXML
    private ImageView CircleImage;
    @FXML
    private AnchorPane Back;
    @FXML
    private ImageView StartImage;
    @FXML
    private ImageView ResumeImage;
    @FXML
    private ImageView ExitImage;
    @FXML
    private ImageView HelpImage;
    @FXML
    private Button Start;
    @FXML
    private Button Resume;
    @FXML
    private Button Help;
    @FXML
    private Text HighScore;
    public void initialize() throws IOException, ClassNotFoundException {
        //Circle circle = new Circle(1);
        Back.setStyle("-fx-background: #" + "272727");
        RotateTransition rotate = new RotateTransition();
        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);
        Start s = new Start();
        //Scroll.setStyle("-fx-background: #" + "272727");
        int score=s.loadHighScore(new File("Highscore.txt"));
        HighScore.setText("High Score: "+score);
        HighScore.setFill(Color.WHITE);
    //    String x=Color.YELLOW.toString();
      //  HighScore.setFill(Paint.valueOf(x));
        // setting the angle of rotation
        rotate.setByAngle(360);

        //setting cycle count of the rotation
        rotate.setCycleCount(Integer.MAX_VALUE);

        //Setting duration of the transition
        rotate.setDuration(Duration.millis(700));

        //the transition will be auto reversed by setting this to true
        //rotate.setAutoReverse(true);

        //setting Rectangle as the node onto which the
// transition will be applied
        rotate.setNode(CircleImage);
        //playing the transition
        rotate.play();
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setCycleCount(500);
        Starrotate.setNode(HelpImage);

        Starrotate.play();

    }
    public void changescreen() throws IOException {
    Stage stage = (Stage) Start.getScene().getWindow();
    stage.close();
    Stage primaryStage =new Stage();
    Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
    primaryStage.setTitle("new");
    primaryStage.setScene(new Scene(root,600,800));
    root.requestFocus();
    primaryStage.show();
}
    public void Balls() throws IOException {
        Stage stage = (Stage) Start.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SelectBalls.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void Resumescreen() throws IOException {
        Stage stage = (Stage) Start.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ResumeGame.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void HelpScreen() throws IOException {
        Stage stage = (Stage) Start.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }

    public void exit(){
        System.exit(0);
    }
}
