package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;

public class Main extends Application implements Serializable {
    Start game=new Start();
    static int HighScore;

    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("2ndScreen.fxml"));
        primaryStage.setTitle("Hello World");
     //  Start newg = new Start();
//        newg.start(newg.ballpos,newg.baseline,newg.pointcount,newg.count);
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
       root.requestFocus();
       //System.out.println("HELLo");
    }

    public Start getStart(){
        return this.game;
    }

    public static void main(String[] args)
    {

        launch(args);
    }
}
