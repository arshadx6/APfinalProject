package sample;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.naming.event.ObjectChangeListener;
import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Start implements Initializable {
    @FXML
    Circle BALL;
    @FXML
    ScrollPane Scroll;
    @FXML
            AnchorPane main;
    @FXML
            Text POINTS;

    double newY = 0;
   // Circle BALL = new Circle(100);
    double DistTravelled=0;
    double baseline=600;
    int pointcount=0;
    Random random=new Random();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //V.setAlignment(Pos.BOTTOM_CENTER);
        //V.getChildren().add(BALL);

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
        int[] count={1};
        ArrayList<javafx.scene.image.ImageView> starlist=new ArrayList<>();
        ArrayList<javafx.scene.image.ImageView> clrlist=new ArrayList<>();
      //  Scroll.setViewportBounds(text.getLayoutBounds());
        //Scroll.requestFocus();
        EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if(e.getCode()==KeyCode.UP){
                    Bounds bounds = Scroll.getBoundsInLocal();
                    //action details
                    KeyValue up= new KeyValue(BALL.layoutYProperty(),BALL.getLayoutY()-100, Interpolator.EASE_OUT);
                    KeyValue down=new KeyValue(BALL.layoutYProperty(),bounds.getMaxY(), Interpolator.EASE_IN);
                    //action durations
                    newY=BALL.getLayoutY();
                //    System.out.println(newY);
                    KeyFrame bounceup=new KeyFrame(Duration.seconds(0.5),up);
                    KeyFrame bouncedown=new KeyFrame(Duration.seconds(4),down);
                    DistTravelled=0;
                    if((baseline-newY)>1){
                  //      System.out.println(" base--"+baseline);
                        DistTravelled=baseline-newY;
                        baseline-=DistTravelled;

                    //    System.out.println(" Dist Travelled--"+DistTravelled);
                    //    System.out.println(" NEW Y--"+newY);
                        main.setTranslateY(main.getTranslateY()+DistTravelled);
                        POINTS.setTranslateY(POINTS.getTranslateY()-DistTravelled);

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
                            switch(2){
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
                                
                                Platform.exit();
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
                            pointcount+=1;
                            POINTS.setText("POINTS: "+pointcount);
                            break;
                        }
                    }
                    }
                    for(javafx.scene.image.ImageView I: clrlist)
                    {   if(main.getChildren().contains(I)){
                        if (BALL.getBoundsInParent().intersects(I.getBoundsInParent())) {
                           // System.out.println("intersect");
                            main.getChildren().remove(I);
//                            String temp="";
//                            for(String p : colors){
//                                if(p.equals(BALL.getFill()))
//                                {   temp=p;
//
//                            }colors.remove(p);
//                        }

                           //System.out.println(BALL.getFill().hashCode());
                          // colors.remove(colors.indexOf(ball));
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

                if(BALL.getLayoutY()>baseline+200&&count[0]!=1){
                    System.out.println("OUT OF BOUNDS");
                    Platform.exit();
                }

                }
            }
                };








//Adding event Filter
        Scroll.addEventFilter(KeyEvent.KEY_PRESSED, eventHandler);

    }



}