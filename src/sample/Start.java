package sample;

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
        ArrayList<Shape> a = new ArrayList<>();
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
                    System.out.println(newY);
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

                        System.out.println(" BEFORE NEW Y"+500*count[0]);
                        if(newY<=500*count[0]){
                            System.out.println("HHELLOs and COUNT "+count[0]);
                            System.out.println("NEWY"+newY);
                            System.out.println("500xcount"+500*count[0]);
                            if(count[0]>0){
                                count[0] = -count[0];
                            }
                            else{
                                count[0] = count[0] -1;
                            }


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
                            a.add(arc);
                            a.add(arc2);
                            a.add(arc3);
                            a.add(arc4);

                            Image image =new Image("star.png");

                            javafx.scene.image.ImageView star =new javafx.scene.image.ImageView(image);
                            star.setFitHeight(40);
                            star.setFitWidth(40);
                            star.setX(280);
                            star.setY(800*(count[0]+1)-350);
                            starlist.add(star);
                            Image clrimage =new Image("colorswitch.png");
                            javafx.scene.image.ImageView clrswitch =new javafx.scene.image.ImageView(clrimage);
                            clrlist.add(clrswitch);
                            clrswitch.setFitHeight(40);
                            clrswitch.setFitWidth(40);
                            clrswitch.setX(280);
                            clrswitch.setY(800*(count[0]+1)-50);
                            Group arcs = new Group(arc, arc2, arc3, arc4);
                            arcs.setTranslateX(BALL.getTranslateX());
//                            arcs.setTranslateY(BALL.getTranslateY());
                            arcs.setTranslateY(800*(count[0]+1)-500);
                            main.getChildren().add(star);
                            main.getChildren().add(arcs);
                            main.getChildren().add(clrswitch);
                            RotateTransition rotate = new RotateTransition();
                            RotateTransition Starrotate = new RotateTransition();
                            //Setting Axis of rotation
                            rotate.setAxis(Rotate.Z_AXIS);
                            Starrotate.setAxis(Rotate.Z_AXIS);
                            rotate.setByAngle(360);
                            Starrotate.setByAngle(360);
                            rotate.setCycleCount(500);
                            Starrotate.setDuration(Duration.millis(5000));
                            rotate.setDuration(Duration.millis(5000));
                            rotate.setNode(arcs);
                            Starrotate.setNode(star);
                            //playing the transition
                            rotate.play();
                            Starrotate.play();
                        }
                    }
                    //creating actions
                    Timeline t1 = new Timeline(bounceup);
                    Timeline t2 = new Timeline(bouncedown);

                    //playing actions sequentially
                    SequentialTransition sequence = new SequentialTransition(t1,t2);
                    sequence.play();
                    for ( Shape s : a) {
                        Shape intersect = Shape.intersect(s, BALL);
                        if (intersect.getBoundsInLocal().getWidth() != -1) {
                            if (!s.getStroke().equals(BALL.getFill())){
                                Platform.exit();
                            }
                        }
                    }
                    for(javafx.scene.image.ImageView I: starlist)
                    {
                        if (BALL.getBoundsInParent().intersects(I.getBoundsInParent())) {
                            System.out.println("intersect");
                            main.getChildren().remove(I);
                            pointcount+=1;
                            POINTS.setText("POINTS: "+pointcount);
                        }

                    }
                    for(javafx.scene.image.ImageView I: clrlist)
                    {
                        if (BALL.getBoundsInParent().intersects(I.getBoundsInParent())) {
                            System.out.println("intersect");
                            main.getChildren().remove(I);
                            BALL.setFill(Paint.valueOf(colors.get(random.nextInt(4))));
                        }

                    }

                if(BALL.getLayoutY()-100>baseline&&count[0]!=1){
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