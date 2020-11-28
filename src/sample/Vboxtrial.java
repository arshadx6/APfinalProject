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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.security.Key;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Vboxtrial implements Initializable {
    @FXML
    Circle BALL;
    @FXML
    ScrollPane Scroll;
    @FXML
            AnchorPane main;
    @FXML
            ImageView back;
    @FXML
            Text POINTS;
    double newY = 0;
   // Circle BALL = new Circle(100);
    double DistTravelled=0;
    double baseline=600;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //V.setAlignment(Pos.BOTTOM_CENTER);
        //V.getChildren().add(BALL);

        Scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scroll.setStyle("-fx-background: #" + "3D3E3D");
        ArrayList<Shape> a = new ArrayList<>();

       // Scroll.getChildrenUnmodifiable().add(text);
        int[] count={1};
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

                            a.add(arc);
                            a.add(arc2);
                            a.add(arc3);
                            a.add(arc4);
                            arc4.setStroke(Color.valueOf("33DBF0"));
                            arc4.setStrokeWidth(20);
                            arc4.setFill(Color.TRANSPARENT);
                            Image image =new Image("star.png");
                            javafx.scene.image.ImageView star =new javafx.scene.image.ImageView(image);
                            star.setFitHeight(40);
                            star.setFitWidth(40);
                            star.setX(280);
                            star.setY(800*(count[0]+1)-350);
                            Group arcs = new Group(arc, arc2, arc3, arc4);
                            arcs.setTranslateX(BALL.getTranslateX());
//                            arcs.setTranslateY(BALL.getTranslateY());
                            arcs.setTranslateY(800*(count[0]+1)-500);
                            main.getChildren().add(star);
                            main.getChildren().add(arcs);
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
//                if(star.intersects(BALL.getLayoutBounds())){
//                   // star.
//                    System.out.println("INTERSECTING");
//                   // main.getChildren().removeAll(star);
//                }
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

//    public void keyPressed(KeyEvent event) {
//        // Ball.setTranslateX(200);
//        // System.out.println("HELLO");
//
//
//        if (event.getCode() == KeyCode.UP) {
//
//            newY = newY - 50;
//            BALL.setTranslateY(newY);
//
//
//        }
////        this.DistTravelled=0;
////        if((this.baseline-this.newY)>1){
////            System.out.println(" base--"+baseline);
////            this.DistTravelled=this.baseline-this.newY;
////            this.baseline-=this.DistTravelled;
////
////            System.out.println(" Dist Travelled--"+DistTravelled);
////            System.out.println(" NEW Y--"+newY);
////            main.setTranslateY(main.getTranslateY()+this.DistTravelled);
////            if(newY%500==0){
////                Arc arc = new Arc(300,150,100,100,0,90);
////                arc.setStroke(Color.valueOf("FF0181"));
////                arc.setStrokeWidth(20);
////                arc.setFill(Color.TRANSPARENT);
////
////                Arc arc2 = new Arc(300, 150, 100, 100, 90, 90);
////                arc2.setStroke(Color.valueOf("FBE100"));
////                arc2.setStrokeWidth(20);
////                arc2.setFill(Color.TRANSPARENT);
////
////                Arc arc3 = new Arc(300, 150, 100, 100, 180, 90);
////                arc3.setStroke(Color.valueOf("910DFF"));
////                arc3.setStrokeWidth(20);
////                arc3.setFill(Color.TRANSPARENT);
////
////                Arc arc4 = new Arc(300, 150, 100, 100, 270, 90);
////                ArrayList<Shape> a;
////                a = new ArrayList<>();
////                a.add(arc);
////                a.add(arc2);
////                a.add(arc3);
////                a.add(arc4);
////                arc4.setStroke(Color.valueOf("33DBF0"));
////                arc4.setStrokeWidth(20);
////                arc4.setFill(Color.TRANSPARENT);
////                Image image =new Image("star.png");
////                javafx.scene.image.ImageView star =new javafx.scene.image.ImageView(image);
////                star.setFitHeight(40);
////                star.setFitWidth(40);
////                star.setX(280+BALL.getTranslateX());
////                star.setY(120+BALL.getTranslateY());
////                Group arcs = new Group(arc, arc2, arc3, arc4);
////                arcs.setTranslateX(BALL.getTranslateX());
////                arcs.setTranslateY(BALL.getTranslateY());
////                main.getChildren().add(star);
////                main.getChildren().add(arcs);
////                RotateTransition rotate = new RotateTransition();
////                //Setting Axis of rotation
////                rotate.setAxis(Rotate.Z_AXIS);
////
////                rotate.setByAngle(360);
////
////                rotate.setCycleCount(500);
////
////                rotate.setDuration(Duration.millis(2000));
////                rotate.setNode(arcs);
////
////                //playing the transition
////                rotate.play();
////            }
////        }
//
//
//    }

}