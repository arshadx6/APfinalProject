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
import javafx.scene.paint.Color;
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
import java.util.Scanner;

class ListofSerializable implements Serializable{
    private int pointcount;

    public int getPointcount() {
        return pointcount;
    }

    private int[] difficulty;

    public int[] getDifficulty() {
        return difficulty;
    }

    private double baseline;
   private double ballpos;
    private String color;

    public String getColor() {
        return color;
    }

    private int nextobs;

    private static int Gamenumber;
    private int gameid;

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public static int getGamenumber() {
        return Gamenumber;
    }

    public static void setGamenumber(int gamenumber) {
        Gamenumber = gamenumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNextobs() {
        return nextobs;
    }

    public void setNextobs(int nextobs) {
        this.nextobs = nextobs;
    }

    private static ArrayList<Start> games = new ArrayList<>();
    public void setDifficulty(int[] difficulty) {
        this.difficulty = difficulty;
    }

    public void setBaseline(double baseline) {
        this.baseline = baseline;
    }

    public void setBallpos(double ballpos) {
        this.ballpos = ballpos;
    }

    public void setPointcount(int pointcount) {
        this.pointcount = pointcount;
    }

    public void setGame(Start game) {
        this.games.add(game);
    }

    public ArrayList<Start> getGame() {
        return games;
    }
}
public class Start implements Initializable , Serializable {
    @FXML
   private transient Circle BALL;
    @FXML
    private transient ScrollPane Scroll;
    @FXML
    private transient AnchorPane main;
    @FXML
    private transient Text POINTS;
    @FXML
    private transient Button pause;
    @FXML
    private transient ImageView pImage;
    static private Main mainapp;
    static private Start tempgame;
    public void killPlayer() throws IOException, ClassNotFoundException {
        addpoints(new File("Points.txt"),getPointcount());
        saveRevive(new File("Revive.txt"));
        changetoRevive();
    }
    private static String BGCOLOR="272727";

    public String getBGCOLOR() {
        return BGCOLOR;
    }

    public void setBGCOLOR(String BGCOLOR) {
        this.BGCOLOR = BGCOLOR;
    }

    public static Start getTempgame() {
        return tempgame;
    }

    public static void setTempgame(Start tempgame) {
        Start.tempgame = tempgame;
    }

    public void setMainapp(Main mainapp) {
        this.mainapp = mainapp;
    }

    public static Main getMainapp() {
        return mainapp;
    }

    public void setNextobs(int nextobs) {
        this.nextobs = nextobs;
    }

    private double newY = 0;
   // Circle BALL = new Circle(100);
   private double DistTravelled=0;
    private double baseline=600;
    private int pointcount=0;
    private double ballpos=0;
    private int[] difficulty={1};
    private int[] count={1};
    private Paint color;
    private int currobs=1;
    private int nextobs=1;
    public void setCurrObsNumber(int currobs) {
        this.currobs = currobs;
    }

    public int getCurrObsNumber() {
        return currobs;
    }

    public void setColor(Paint color) {
        this.color = color;
    }

    public void setDifficulty(int[] difficulty) {
        this.difficulty = difficulty;
    }

    Random random=new Random();
    public void changescreen() throws IOException, ClassNotFoundException {
        Stage stage = (Stage) main.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();

        saveHighScore(new File("Highscore.txt"),getPointcount());
        saveRevive(new File("Revive.txt"));
        try{
            Parent root = FXMLLoader.load(getClass().getResource("PauseGame.fxml"));
            primaryStage.setTitle("new");
            primaryStage.setScene(new Scene(root,600,800));
            root.requestFocus();
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void changetoRevive() throws IOException, ClassNotFoundException {

        Stage stage = (Stage) main.getScene().getWindow();
        stage.close();
        Stage primaryStage =new Stage();

        saveHighScore(new File("Highscore.txt"),getPointcount());
        Parent root = FXMLLoader.load(getClass().getResource("Revive.fxml"));
        primaryStage.setTitle("new");
        primaryStage.setScene(new Scene(root,600,800));
        root.requestFocus();
        primaryStage.show();
    }
//    public void update(Circle Ball){
//        Ball.setTranslateY(getBallpos());
//    }

    public int getNextobs() {
        return nextobs;
    }

    public double getBaseline() {
        return baseline;
    }

    public void setBaseline(double baseline) {
        this.baseline = baseline;
    }

    public void setBallpos(double ballpos) {
        this.ballpos = ballpos;

    }
//    void updatepos(double baseline,double ballpos){
//        this.BALL.setTranslateY(ballpos);
//        this.main.setTranslateY(baseline);
//        this.pause.setTranslateY(baseline);
//        this.pImage.setTranslateY(baseline);
//    }

    public double getBallpos() {
        return ballpos;
    }
    public Circle getBALL(){
        return this.BALL;
    }
    public int[] getDifficulty(){
        return difficulty;
    }
    public void setPointcount(int pointcount) {
        this.pointcount = pointcount;
    }

    public int getPointcount() {
        return pointcount;
    }

    public Paint getColor() {
        return color;
    }

    public Start getGame(){
        return this;
    }
    public void start(double ballpos,double baseline,int pointcount,int[] difficulty,Paint color){

        this.setBallpos(ballpos);
        this.setBaseline(baseline);
        this.setPointcount(pointcount);
        this.setDifficulty(difficulty);
        this.setColor(getColor());
        BALL.setFill(getColor());

        System.out.println("DIFFICULT"+difficulty[0]);
        //Scroll.localToParent(BALL.getBoundsInLocal());;
       // System.out.println(pImage.getLayoutY()+"PAUSE");
        System.out.println(currobs);
        BALL.setTranslateY(ballpos);
        main.setLayoutY(getBaseline());

       // main.requestFocus();
        System.out.println(BALL.getLayoutY()+"in Start");


        //Scroll.setTranslateY();
        System.out.println(main.getLayoutY()+"MAIN LAYOUT");

        System.out.println(getBallpos()+"BALLPOS");

        Scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        String s=getBGCOLOR();
        Scroll.setStyle("-fx-background: #" + s);

        //Scroll.vvalueProperty().bind(main.heightProperty());
        Scroll.setVvalue(main.getLayoutY());

        //diff=800+main.getLayoutY();
       // Scroll.setLayoutY(main.getLayoutY());
        //Scroll.get
        Scroll.requestFocus();
       // Scene scene = new Scene(Scroll, Color.BLACK);

        System.out.println(Scroll.getLayoutY());
       // Scroll.setVvalue(BALL.getLayoutY());

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
                    System.out.println(BALL.getLayoutY()+"PRINTING FROM HERE");
                    setBallpos(BALL.getLayoutY());
//                    Circle x= new Circle();
//                    x.setLayoutY(200);
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
                        //  System.out.println(" BEFORE NEW Y"+500*difficulty[0]);
                        if(newY<=500*count[0]){
//                            System.out.println("HHELLOs and COUNT "+difficulty[0]);
//                            System.out.println("NEWY"+newY);
//                            System.out.println("500xcount"+500*difficulty[0]);
                            if(count[0]>0){
                                int[] temp=getDifficulty();
                                temp[0]+=1;
                                setDifficulty(temp);
                                count[0]=-count[0];
                            }
                            else{
                                int[] temp=getDifficulty();
                                temp[0]+=1;
                                setDifficulty(temp);
                                count[0]-=1;
                            }

                            System.out.println("CURRENT OBS NUMBER"+getCurrObsNumber());
                            System.out.println("DIFFUC"+getDifficulty()[0]);
                            switch(getNextobs()){
                                case 1: Obstacles circle=new sample.Circles();
                                    circle.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 2:Obstacles square = new sample.Square();
                                    square.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 8: Obstacles HCircles = new DoubleHCircle();
                                    HCircles.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 3:Obstacles RotatX = new RotatingX();
                                    RotatX.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 9:Obstacles Vcircles = new DoubleVCircle();
                                    Vcircles.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 10:Obstacles Xcircle = new XinCircle();
                                    Xcircle.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 5: Obstacles ConcCircle = new ConcCircle();
                                    ConcCircle.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 4:Obstacles Hline=new HLine();
                                    Hline.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 7:Obstacles Vline = new VLines();
                                    Vline.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;
                                case 6:Obstacles DoubleX = new DoubleX();
                                    DoubleX.InitiateObstacle(starlist,shapes,count,main,difficulty);
                                    break;

                            }

                            currobs=nextobs;
                            if(difficulty[0]>10){
                                nextobs=1+random.nextInt(10);
                            }
                            else if(difficulty[0]>5){
                                nextobs=1+random.nextInt(7);
                            }
                            else{
                                nextobs=1+random.nextInt(4);
                                //nextobs=1+random.nextInt(4);
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
                                        killPlayer();
                                        //changescreen();

                                    } catch (IOException | ClassNotFoundException ex) {
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
                    setColor(color);

                    if(BALL.getLayoutY()>getBaseline()+200&&count[0]!=1){
                        System.out.println("HAPPENING");
                       // System.out.println("BASERLINE"+getBaseline());
                        try {
                            killPlayer();
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }

                    }

                }
            }
        };








//Adding event Filter
        Scroll.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

    }
    public void save(File file) throws IOException, ClassNotFoundException {

        ArrayList<ListofSerializable> GAMES=new ArrayList<>();
        GAMES=checkload(file);
        System.out.println("THIS IS GAME "+GAMES.size());
        ListofSerializable objects=new ListofSerializable();
        objects.setNextobs(getCurrObsNumber());
        objects.setColor(getColor().toString());
        objects.setGameid(GAMES.size());
        ListofSerializable.setGamenumber(ListofSerializable.getGamenumber()+1);
        objects.setPointcount(getPointcount());
        objects.setDifficulty(getDifficulty());
        if(GAMES.size()<3){
            GAMES.add(objects);
        }
        else{
            GAMES.set(0,objects);
        }
//        if(GAMES.isEmpty()){
//            GAMES.add(objects);
//        }
//        else if(GAMES.size()==1){
//            GAMES.add(objects);
//        }

        System.out.println("TOTAL SAVED FILES NOW"+GAMES.size());
       // objects.setColor(BALL.getFill());
        try {
            //FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file));
            objectStream.writeObject(GAMES);
            objectStream.close();

            System.out.println("SAVED GAME");

        } catch (Exception e) {

            System.out.println("COULDNT SAVE GAME");
        }

    }
    public void loadGameDataFromFile(File file,int i) throws ClassNotFoundException, IOException {
        int count=0;
        if(file.length()>0){
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            ArrayList<ListofSerializable> objects=null;

            try{
                objects= (ArrayList<ListofSerializable>) objectStream.readObject();
                // System.out.println(objects.gameid+"GAME ID FROM LOAD");
                System.out.println("THIS HAS x GAMES");
                ListofSerializable game=objects.get(i-1);
                getGame().setNextobs(game.getNextobs());
//                    System.out.println("OBJECT"+objects.ballpos);
//                    System.out.println("OBJECTbasw"+objects.baseline);
//                    System.out.println("GET"+objects.getNextobs());
//                    System.out.println(Paint.valueOf(objects.color));
                getGame().setDifficulty(game.getDifficulty());
                System.out.println("DIFFU"+difficulty[0]);
                getGame().setPointcount(game.getPointcount());
                getGame().setBallpos(this.ballpos-100);
                getGame().BALL.setTranslateY(getBallpos());
                getGame().setColor(Paint.valueOf(game.getColor()));
                getGame().getBALL().setFill(getColor());
                getGame().POINTS.setText("POINTS : "+ pointcount);
//                    System.out.println("After SETTING");
//                    System.out.println("THIS IS POINT COUNT"+this.getPointcount());
//                    System.out.println("Ballpos"+this.getBallpos());
//                    System.out.println("COUNT"+this.difficulty[0]);
                count+=1;
            }
            catch (EOFException e){

            }
            finally {
                objectStream.close();
            }
        }

    }
    public ArrayList<ListofSerializable> checkload(File file) throws IOException, ClassNotFoundException {
        ArrayList<ListofSerializable> objects=new ArrayList<>();
        if(file.length()>0){
            FileInputStream fileStream = new FileInputStream(file);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            try{
                objects= (ArrayList<ListofSerializable>) objectStream.readObject();
            }
            finally {
                objectStream.close();
            }

        }

        return objects;
    }
    public void saveRevive(File file) throws IOException {
        ListofSerializable objects=new ListofSerializable();
        objects.setDifficulty(getDifficulty());
        objects.setPointcount(getPointcount());
        objects.setColor(getBALL().getFill().toString());
        objects.setNextobs(getCurrObsNumber());
        objects.setGameid(10);
        ObjectOutputStream objectStream=new ObjectOutputStream(new FileOutputStream(file));
        try{
            System.out.println("SAVING REVIVE");
            objectStream.writeObject(objects);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            objectStream.close();
        }
    }
    public void loadRevive(File file) throws IOException, ClassNotFoundException {
        ListofSerializable game = null;
        ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream(file));
        try{
            System.out.println("LOADING REVIVE");
            game=(ListofSerializable) objectStream.readObject();

        }
        catch (Exception e){

        }
        finally {
            objectStream.close();
        }
        getGame().setDifficulty(game.getDifficulty());
        getGame().setPointcount(game.getPointcount());
        getGame().setBallpos(this.ballpos-100);
        getGame().setNextobs(game.getNextobs());
        getGame().setColor(Paint.valueOf(game.getColor()));

        System.out.println("DIFFUCULTY"+getDifficulty()[0]);
        System.out.println("PC"+getPointcount());
        System.out.println("NEXTOBS"+getNextobs());

        getGame().POINTS.setText("POINTS : "+ this.getPointcount());
        getGame().BALL.setFill(getColor());
    }

    public void saveHighScore(File file,int points) throws IOException, ClassNotFoundException {


            //FileOutputStream fileStream = new FileOutputStream(file);



        Main m = new Main();
            Start s =new Start();
            int temp=s.loadHighScore(new File("Highscore.txt"));
            System.out.println("READING SCORE"+temp);
            if(points>temp){
                FileWriter mywriter=new FileWriter(file);
                mywriter.write(Integer.toString(points));
                mywriter.close();
                System.out.println("Updated HighScore"+points);
                m.setHighScore(points);
            }



    }
    public void addpoints(File file,int points) throws IOException {
            int existing=getpoints(file);
        try {
            //FileOutputStream fileStream = new FileOutputStream(file);
            ObjectOutputStream objectStream = new ObjectOutputStream(new FileOutputStream(file));
            objectStream.writeObject(existing+points);
            objectStream.close();

            System.out.println("Added Points");

        } catch (Exception e) {

            System.out.println("COULDNT ADD POINTS");
        }
    }
    public int getpoints(File file) throws IOException {
        int points=0;
        if(file.length()>0){
            FileInputStream fileStream = new FileInputStream(file);

            ObjectInputStream objectStream = new ObjectInputStream(fileStream);

            try{
                points= (int) objectStream.readObject();

            }
            catch (Exception e){

            }
            finally {
                objectStream.close();
            }
        }


        System.out.println("THIS IS STAR TOTAL "+ points);
        return points;

    }

    public int loadHighScore(File file) throws ClassNotFoundException, IOException {
        int score=0;
        if(file.length()>0){
           Scanner myreader=new Scanner(file);

            try{
                String temp= myreader.next();
                score=Integer.valueOf(temp);

                myreader.close();
                return score;

            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

        return score;

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //V.setAlignment(Pos.BOTTOM_CENTER);
        //V.getChildren().add(BALL);
        //Start start=new Start();
        //System.out.println(this.toString());

        POINTS.setFill(Color.WHITE);
        //POINTS.setTranslateY(400);
       //System.out.println(m.getHighScore());
       // BALL.setTranslateY(400);
        ListofSerializable x= new ListofSerializable();
        ResumeGame s=new ResumeGame();
        x.setGame(this);
        s.setS(this);
        Revive rev= new Revive();
        rev.setS(this);
        System.out.println(BALL.getLayoutY()+"ssssssss");
        System.out.println("BALL POSITION "+x.getGame().get(0).getBallpos());
        ArrayList<String> colors = new ArrayList<>();
        colors.add("FF0181");
        colors.add("FBE100");
        colors.add("910DFF");
        colors.add("33DBF0");
        Paint color=Paint.valueOf(colors.get(random.nextInt(4)));
        getGame().setColor(color);
       // BALL.setFill(getColor());
        PauseGame.setTemp(this);
        setTempgame(getGame());
        getGame().start(ballpos,baseline,pointcount,difficulty,color);

//        int[] counts={4};
//        getGame().start(-200,200,3,counts);


    }
}