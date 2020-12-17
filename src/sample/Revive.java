package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;



import java.io.*;
import java.net.URL;
import java.time.format.TextStyle;
import java.util.ResourceBundle;

public class Revive implements Initializable ,Serializable{
    private static Start s;

    public void setS(Start s) {
        this.s = s;
    }

    public static Start getS() {
        return s;
    }

    @FXML
    private AnchorPane main;
    @FXML
    private Button Revive;
    @FXML
    private Button Exit;
    @FXML
    private Text Stars;
    @FXML
    private Text Stars1;
    @FXML
    private ImageView star;
    public void changescreen() throws IOException {
        Stage stage = (Stage) main.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void Revive() throws IOException, ClassNotFoundException {



        if(s.getpoints(new File("Points.txt"))>=10){
            Stage stage = (Stage) Revive.getScene().getWindow();
            stage.close();
            Stage primaryStage =new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
            s.addpoints(new File("Points.txt"),-10);
            try{
                s.loadRevive(new File("Revive.txt"));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            primaryStage.setTitle("new");
            primaryStage.setScene(new Scene(root,600,800));
            root.requestFocus();
            primaryStage.show();
        }
       else{
            Stage stage = (Stage) Revive.getScene().getWindow();
            stage.close();
            Stage primaryStage =new Stage();
            Parent root1 = FXMLLoader.load(getClass().getResource("NoStars.fxml"));
            primaryStage.setTitle("new");
            primaryStage.setScene(new Scene(root1,400,400));
            root1.requestFocus();
            primaryStage.show();
//            Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
//            primaryStage.setTitle("new");
//            primaryStage.setScene(new Scene(root,600,800));
//            root.requestFocus();
//            primaryStage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RotateTransition rotate = new RotateTransition();
        RotateTransition Starrotate = new RotateTransition();

        Starrotate.setAxis(Rotate.Z_AXIS);

        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));

        Starrotate.setNode(star);
        Starrotate.setCycleCount(500);
        //playing the transition
        rotate.play();
        Starrotate.play();
        main.setStyle("-fx-background: #" + "272727");
        Start s = new Start();
        try {
            Stars.setText("Total Stars = "+s.getpoints(new File("Points.txt")));

            Stars1.setText("10 Stars required to Revive");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
