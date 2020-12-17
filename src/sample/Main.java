package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;
import java.util.ArrayList;

public class Main extends Application implements Serializable {

    ArrayList<Start> Games=new ArrayList<>();
    static int HighScore;
    static int Pointpool;
    public int getHighScore() {
        return HighScore;
    }

    public void setHighScore(int highScore) {
        HighScore = highScore;
    }

    public void setPointpool(int pointpool) {
        Pointpool = pointpool;
    }
    public int getPointpool() {
        return Pointpool;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Games.add(new Start());
        Games.add(new Start());
        Games.add(new Start());
        Games.add(new Start());
        Start s=new Start();
        ResumeGame r=new ResumeGame();
        s.setMainapp(this);
        r.setMainapp(this);
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
     //  Start newg = new Start();
//        newg.start(newg.ballpos,newg.baseline,newg.pointcount,newg.count);
        primaryStage.setScene(new Scene(root, 600, 800));
        primaryStage.show();
       root.requestFocus();
       //System.out.println("HELLo");
    }

    public ArrayList<Start> getStart(){
        return this.Games;
    }

    public static void main(String[] args)
    {

        launch(args);
    }
}
