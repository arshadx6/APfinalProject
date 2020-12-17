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

public class Controller implements Initializable {
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Arc arc = new Arc(300,150,100,100,0,90);
//        arc.setStroke(Color.valueOf("FF0181"));
//        arc.setStrokeWidth(20);
//        arc.setFill(Color.TRANSPARENT);
//
//        Arc arc2 = new Arc(300, 150, 100, 100, 90, 90);
//        arc2.setStroke(Color.valueOf("FBE100"));
//        arc2.setStrokeWidth(20);
//        arc2.setFill(Color.TRANSPARENT);
//
//        Arc arc3 = new Arc(300, 150, 100, 100, 180, 90);
//        arc3.setStroke(Color.valueOf("910DFF"));
//        arc3.setStrokeWidth(20);
//        arc3.setFill(Color.TRANSPARENT);
//
//        Arc arc4 = new Arc(300, 150, 100, 100, 270, 90);
//        arc4.setStroke(Color.valueOf("33DBF0"));
//        arc4.setStrokeWidth(20);
//        arc4.setFill(Color.TRANSPARENT);
//        Group arcs = new Group(arc, arc2, arc3, arc4);
//        RotateTransition rotate = new RotateTransition();
//        rotate.setAxis(Rotate.Z_AXIS);
//        arcs.setTranslateY(350);
//        arcs.setTranslateX(0);
//        rotate.setByAngle(360);
//
//        rotate.setCycleCount(500);
//        main.getChildren().add(arcs);
//        rotate.setDuration(Duration.millis(5000));
//        rotate.setNode(arcs);
//
//        //playing the transition
//        rotate.play();
    }
}
