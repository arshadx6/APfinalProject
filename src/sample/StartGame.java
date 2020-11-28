package sample;
import javafx.animation.*;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class StartGame implements Initializable {

    @FXML
    private AnchorPane canvas;
    @FXML
    ImageView Back;
    @FXML
    private Circle Ball;
    @FXML
    Button Pause;


    double newY = 0;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Arc arc = new Arc(300,150,100,100,0,90);
        arc.setStroke(Color.valueOf("FF0181"));
        arc.setStrokeWidth(20);
        arc.setFill(Color.TRANSPARENT);

        Arc arc2 = new Arc(300, 150, 100, 100, 90, 90);
        arc2.setStroke(Color.valueOf("FBE100"));
        arc2.setStrokeWidth(20);
        arc2.setFill(Color.TRANSPARENT);

        Arc arc3 = new Arc(300, 150, 100, 100, 180, 90);
        arc3.setStroke(Color.valueOf("910DFF"));
        arc3.setStrokeWidth(20);
        arc3.setFill(Color.TRANSPARENT);

        Arc arc4 = new Arc(300, 150, 100, 100, 270, 90);
        arc4.setStroke(Color.valueOf("33DBF0"));
        arc4.setStrokeWidth(20);
        arc4.setFill(Color.TRANSPARENT);
        Image image =new Image("star.png");
        ImageView star =new ImageView(image);
        star.setFitHeight(40);
        star.setFitWidth(40);
        star.setX(280);
        star.setY(120);
        Group arcs = new Group(arc, arc2, arc3, arc4);
        canvas.getChildren().add(star);
        canvas.getChildren().add(arcs);
        RotateTransition rotate = new RotateTransition();
        //Setting Axis of rotation
        rotate.setAxis(Rotate.Z_AXIS);

        rotate.setByAngle(360);

        rotate.setCycleCount(500);

        rotate.setDuration(Duration.millis(2000));
        rotate.setNode(arcs);

        //playing the transition
        rotate.play();
    }

    public void keyPressed(KeyEvent event) {
        // Ball.setTranslateX(200);
        // System.out.println("HELLO");


        if (event.getCode() == KeyCode.UP) {

            newY=newY-100;
            Ball.setTranslateY(newY);
//            while(true){
//                try {
//                    wait(200);
//                }
//                catch (Exception e){
//                    newY=newY+20;
//                    Ball.setTranslateY(newY);
//                    break;
//                }
//
//
//            }

        }

    }



    public void keyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {

        }

    }

    public void Pausescreen() throws IOException {
//        Stage stage = (Stage) canvas.getScene().getWindow();
//        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("PauseGame.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,400,500));
        //root.requestFocus();
        primaryStage.show();
    }
}






