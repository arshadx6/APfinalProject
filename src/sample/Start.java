package sample;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class Start implements Initializable , Serializable {
    @FXML
    transient Circle BALL;
    @FXML
    transient ScrollPane Scroll;
    @FXML
    transient AnchorPane main;
    @FXML
    transient Text POINTS;
    @FXML
    transient Button pause;
    @FXML
    transient ImageView pImage;
    private Main mainapp;

    public void setMainapp(Main mainapp) {
        this.mainapp = mainapp;
    }

    double newY = 0;
   // Circle BALL = new Circle(100);
    double DistTravelled=0;
    double baseline=600;
    int pointcount=0;
    double ballpos=0;
    double uniqueid;
    int[] count={1};
    int init=1;
    int code=1;
    public void setCount(int[] count) {
        this.count = count;
    }

    Random random=new Random();
    public void changescreen() throws IOException {
        Stage stage = (Stage) main.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();
        File file = new File("Saved.txt");
        save(file,getGame());
        Parent root = FXMLLoader.load(getClass().getResource("PauseGame.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
    public void update(Circle Ball){
        Ball.setTranslateY(getBallpos());
    }
    public double getBaseline() {
        return baseline;
    }

    public void setBaseline(double baseline) {
        this.baseline = baseline;
    }

    public void setBallpos(double ballpos,String x) {
        this.ballpos = ballpos;
        update(this.BALL);
    }
    public void setBallpos(double ballpos) {
        this.ballpos = ballpos;

    }

    public double getBallpos() {
        return ballpos;
    }
    public Circle getBALL(){
        return this.BALL;
    }
    public void setPointcount(int pointcount) {
        this.pointcount = pointcount;
    }

    public int getPointcount() {
        return pointcount;
    }

    public Start getGame(){
        return this;
    }
    public void start(double ballpos,double baseline,int pointcount,int[] count){
        this.setBallpos(ballpos);
        this.setBaseline(baseline);
        this.setPointcount(pointcount);
        this.setCount(count);
        BALL.setTranslateY(ballpos);
        System.out.println(getBallpos()+"BALLPOS");

        Scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scroll.setStyle("-fx-background: #" + "3D3E3D");
        ArrayList<Shape> shapes = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        colors.add("FF0181");
        colors.add("FBE100");
        colors.add("910DFF");
        colors.add("33DBF0");
        // Scroll.getChildrenUnmodifiable().add(text);

        ArrayList<javafx.scene.image.ImageView> starlist=new ArrayList<>();
        ArrayList<javafx.scene.image.ImageView> clrlist=new ArrayList<>();
        //  Scroll.setViewportBounds(text.getLayoutBounds());
        //Scroll.requestFocus();
        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode()==KeyCode.UP){
                    System.out.println(BALL.getLayoutY());
                    setBallpos(BALL.getLayoutY());
                    Bounds bounds = Scroll.getBoundsInLocal();
//                    System.out.println("BASELINE"+getBaseline());
//                    System.out.println("BALLPOS"+getBallpos());
                    //action details
                    KeyValue up= new KeyValue(BALL.layoutYProperty(),BALL.getLayoutY()-100, Interpolator.EASE_OUT);
                    KeyValue down=new KeyValue(BALL.layoutYProperty(),bounds.getMaxY(), Interpolator.EASE_IN);
                    //action durations
                    newY=BALL.getLayoutY();
                    //    System.out.println(newY);
                    KeyFrame bounceup=new KeyFrame(Duration.seconds(0.5),up);
                    KeyFrame bouncedown=new KeyFrame(Duration.seconds(4),down);
                    DistTravelled=0;
                    if((getBaseline()-newY)>1){
                        //      System.out.println(" base--"+baseline);
                        DistTravelled=getBaseline()-newY;
                        setBaseline(getBaseline()-DistTravelled);
                        //    System.out.println(" Dist Travelled--"+DistTravelled);
                        //    System.out.println(" NEW Y--"+newY);
                        main.setTranslateY(main.getTranslateY()+DistTravelled);
                        POINTS.setTranslateY(POINTS.getTranslateY()-DistTravelled);
                        pause.setTranslateY(pause.getTranslateY()-DistTravelled);
                        pImage.setTranslateY(pImage.getTranslateY()-DistTravelled);
                        //  System.out.println(" BEFORE NEW Y"+500*count[0]);
                        if(newY<=500*count[0]){
//                            System.out.println("HHELLOs and COUNT "+count[0]);
//                            System.out.println("NEWY"+newY);
//                            System.out.println("500xcount"+500*count[0]);
                            if(count[0]>0){
                                count[0] = -count[0];
                            }
                            else{
                                count[0] = count[0] -1;
                            }
                            System.out.println(getBallpos());
                            switch(2){//1+random.nextInt(10)
                                case 1: Obstacles circle=new sample.Circle();
                                    circle.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 2:Obstacles square = new sample.Square();
                                    square.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 3: Obstacles HCircles = new DoubleHCircle();
                                    HCircles.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 4:Obstacles RotatX = new RotatingX();
                                    RotatX.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 5:Obstacles Vcircles = new DoubleVCircle();
                                    Vcircles.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 6:Obstacles Xcircle = new XinCircle();
                                    Xcircle.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 7: Obstacles ConcCircle = new ConcCircle();
                                    ConcCircle.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 8:Obstacles Hline=new HLine();
                                    Hline.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 9:Obstacles Vline = new VLines();
                                    Vline.InitiateObstacle(starlist,shapes,count,main);
                                    break;
                                case 10:Obstacles DoubleX = new DoubleX();
                                    DoubleX.InitiateObstacle(starlist,shapes,count,main);
                                    break;

                            }



                            Image clrimage =new Image("colorswitch.png");
                            javafx.scene.image.ImageView clrswitch =new javafx.scene.image.ImageView(clrimage);
                            clrlist.add(clrswitch);
                            clrswitch.setFitHeight(40);
                            clrswitch.setFitWidth(40);
                            clrswitch.setX(280);
                            clrswitch.setY(800*(count[0]+1)+50);


                            main.getChildren().add(clrswitch);


                            //Setting Axis of rotation

                        }
                    }
                    //creating actions
                    Timeline t1 = new Timeline(bounceup);
                    Timeline t2 = new Timeline(bouncedown);

                    //playing actions sequentially
                    SequentialTransition sequence = new SequentialTransition(t1,t2);
                    sequence.play();
                    for ( Shape s : shapes) {
                        Shape intersect = Shape.intersect(s, BALL);
                        if (intersect.getBoundsInLocal().getWidth() != -1) {
                            if (!s.getStroke().equals(BALL.getFill())){

                                Circle bomb = new Circle(0, BALL.getFill());
                                main.getChildren().add(bomb);
                                bomb.relocate(BALL.getLayoutX(),BALL.getLayoutY());
                                KeyValue blast=new KeyValue(bomb.radiusProperty(),800,Interpolator.EASE_IN);
                                KeyFrame explosion=new KeyFrame(Duration.seconds(2),blast);
                                Timeline t = new Timeline(explosion);
                                t.play();
                                t.setOnFinished(actionEvent -> {
                                    try {

                                        File file = new File("Saved.txt");
                                        save(file,getGame());
                                        changescreen();
                                        file=new File("Highscore.txt");
                                        saveHighScore(file,getPointcount());

                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }
                                });


                            }
                        }
                    }
                    for(javafx.scene.image.ImageView I: starlist)
                    {   if(main.getChildren().contains(I)){
                        if (BALL.getBoundsInParent().intersects(I.getBoundsInParent())) {
                            // System.out.println(starlist.indexOf(I));
                            // System.out.println("Y:"+I.getY());
                            System.out.println("intersect");
                            main.getChildren().remove(I);
                            setPointcount(getPointcount()+1);
                            POINTS.setText("POINTS: "+getPointcount());
                            break;
                        }
                    }
                    }
                    for(javafx.scene.image.ImageView I: clrlist)
                    {   if(main.getChildren().contains(I)){
                        if (BALL.getBoundsInParent().intersects(I.getBoundsInParent())) {
                            main.getChildren().remove(I);
                            Paint color=BALL.getFill();
                            Paint Ballcolour= BALL.getFill();
                            while(Ballcolour.equals(BALL.getFill())){
                                color=Paint.valueOf(colors.get(random.nextInt(4)));
                                BALL.setFill(color);
                            }

                            // colors.add(ball.toString());
//                            if(!temp.isEmpty()){
//                                colors.add(temp);
//                            }



                        }
                    }

                    }

                    if(BALL.getLayoutY()>getBaseline()+200&&count[0]!=1){
                        System.out.println("HAPPENING");
                       // System.out.println("BASERLINE"+getBaseline());
                        File file = new File("Saved.txt");
//                        save(file,getGame());
//                        try {
//                            loadGameDataFromFile(file);
//
//                        } catch (ClassNotFoundException ex) {
//                            ex.printStackTrace();
//                        } catch (IOException ex) {
//                            ex.printStackTrace();
//                        }
                        System.out.println("OUT OF BOUNDS");
                        Platform.exit();
                    }

                }
            }
        };








//Adding event Filter
        Scroll.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

    }
    public void save(File file,Start game){

        try {
            //FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file));
            objectStream.writeObject(game);
            objectStream.close();

            System.out.println("SAVED GAME");

        } catch (Exception e) {

            System.out.println("COULDNT SAVE GAME");
        }

    }
    public void saveHighScore(File file,int points){

        try {
            //FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file));


            Main m = new Main();
            if(points>m.getHighScore()){
                objectStream.writeObject(points);
                System.out.println("Updated HighScore"+points);
                m.setHighScore(points);
            }
            objectStream.close();
        } catch (Exception e) {

            System.out.println("COULDNT SAVE High Score");
        }

    }
    public int loadHighScore(File file) throws ClassNotFoundException, IOException {
        int score=0;
        if(file.length()>0){
            FileInputStream fileStream = new FileInputStream(file);

            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            try{
                score= (int) objectStream.readObject();
            }
            finally {
                objectStream.close();
            }
        }


        System.out.println("THIS IS HIGH SCORE "+ score);
        return score;

    }

    public void loadGameDataFromFile(File file) throws ClassNotFoundException, IOException {

        FileInputStream fileStream = new FileInputStream(file);
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);
        Start tempgame=null;
        try{
            tempgame= (Start) objectStream.readObject();
        }
        finally {
            objectStream.close();
        }
        System.out.println("THIS IS POINT COUNT"+tempgame.pointcount);
       // System.out.println(tempgame.code);
        //Start x=new Start();
        System.out.println("SEETINNNG");
        this.setBaseline(tempgame.baseline);
        this.setPointcount(tempgame.pointcount);
        this.setCount(tempgame.count);
        this.setBallpos(tempgame.ballpos,"sss");
        System.out.println("After SETTING");
        System.out.println("THIS IS POINT COUNT"+this.getPointcount());
        System.out.println("Ballpos"+this.getBallpos());
        System.out.println(baseline);

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //V.setAlignment(Pos.BOTTOM_CENTER);
        //V.getChildren().add(BALL);
        //Start start=new Start();
        System.out.println(this.toString());
        System.out.println("BALL POSITION "+getBallpos());
       //System.out.println(m.getHighScore());
        getGame().start(this.ballpos,this.baseline,this.pointcount,this.count);
//        int[] counts={4};
//        getGame().start(-200,200,3,counts);


    }
}