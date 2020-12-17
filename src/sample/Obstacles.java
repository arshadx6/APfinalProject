package sample;


import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.ArrayList;

public abstract class Obstacles {
    int speed=1;
    String Pink;
    String Yellow;
    String Purple;
    String Blue;
    Image image =new Image("star.png");
    javafx.scene.image.ImageView star =new javafx.scene.image.ImageView(image);
    Obstacles(){
        star.setFitHeight(40);
        star.setFitWidth(40);
    }
    abstract void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a,int count[],AnchorPane main,int[] difficulty);

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
class Square extends Obstacles{
    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line line=new Line(200,200,400,200);
        line.setStroke(Color.valueOf("FF0181"));
        line.setStrokeWidth(20);

        Line line2=new Line(400,200,400,400);
        line2.setStroke(Color.valueOf("FBE100"));
        line2.setStrokeWidth(20);

        Line line3=new Line(200,400,400,400);
        line3.setStroke(Color.valueOf("910DFF"));
        line3.setStrokeWidth(20);

        Line line4=new Line(200,200,200,400);
        line4.setStroke(Color.valueOf("33DBF0"));
        line4.setStrokeWidth(20);
        star.setX(280);
        star.setY(800*(count[0]+1)-270);
        starlist.add(star);

        Group square = new Group(line, line2, line3, line4);
        square.setTranslateX(0);
        square.setTranslateY(800*(count[0]+1)-550);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setCycleCount(500);
        Starrotate.setNode(star);
        Starrotate.play();
        starlist.add(star);

        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);
        setSpeed(difficulty[0]/2);
        rotate.setDuration(Duration.millis(5000-speed*150));
        rotate.setNode(square);
        rotate.play();
        main.getChildren().add(square);
        main.getChildren().add(star);
        a.add(line);
        a.add(line2);
        a.add (line3);
        a.add (line4);
    }
}
class Circles extends Obstacles{

    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a,int count[],AnchorPane main,int[] difficulty) {
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


        star.setX(280);
        star.setY(800*(count[0]+1)-350);
        starlist.add(star);
        Group arcs = new Group(arc, arc2, arc3, arc4);
        arcs.setTranslateX(0);
        arcs.setTranslateY(800*(count[0]+1)-500);
        main.getChildren().add(star);
        main.getChildren().add(arcs);
        RotateTransition rotate = new RotateTransition();
        RotateTransition Starrotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
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
class DoubleVCircle extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Arc arc = new Arc(300,100,100,100,0,90);
        arc.setStroke(Color.valueOf("FF0181"));
        arc.setStrokeWidth(20);
        arc.setFill(Color.TRANSPARENT);

        Arc arc2 = new Arc(300, 100, 100, 100, 90, 90);
        arc2.setStroke(Color.valueOf("FBE100"));
        arc2.setStrokeWidth(20);
        arc2.setFill(Color.TRANSPARENT);

        Arc arc3 = new Arc(300, 100, 100, 100, 180, 90);
        arc3.setStroke(Color.valueOf("910DFF"));
        arc3.setStrokeWidth(20);
        arc3.setFill(Color.TRANSPARENT);

        Arc arc4 = new Arc(300, 100, 100, 100, 270, 90);
        arc4.setStroke(Color.valueOf("33DBF0"));
        arc4.setStrokeWidth(20);
        arc4.setFill(Color.TRANSPARENT);

        Arc arc5 = new Arc(300,300,100,100,0,90);
        arc5.setStroke(Color.valueOf("33DBF0"));
        arc5.setStrokeWidth(20);
        arc5.setFill(Color.TRANSPARENT);

        Arc arc6 = new Arc(300, 300, 100, 100, 90, 90);
        arc6.setStroke(Color.valueOf("910DFF"));
        arc6.setStrokeWidth(20);
        arc6.setFill(Color.TRANSPARENT);

        Arc arc7 = new Arc(300, 300, 100, 100, 180, 90);
        arc7.setStroke(Color.valueOf("FBE100"));
        arc7.setStrokeWidth(20);
        arc7.setFill(Color.TRANSPARENT);

        Arc arc8 = new Arc(300, 300, 100, 100, 270, 90);
        arc8.setStroke(Color.valueOf("FF0181"));
        arc8.setStrokeWidth(20);
        arc8.setFill(Color.TRANSPARENT);

        a.add(arc);
        a.add(arc2);
        a.add(arc3);
        a.add(arc4);
        a.add(arc6);
        a.add(arc7);
        a.add(arc8);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-400);
        Starrotate.setNode(star);


        Starrotate.play();

        main.getChildren().add(star);
        Group circle1 = new Group(arc, arc2, arc3, arc4);
        Group circle2=new Group (arc5,arc6,arc7,arc8);
        circle1.setTranslateY(800*(count[0]+1)-500);
        circle2.setTranslateY(800*(count[0]+1)-500);
        main.getChildren().add(circle1);
        main.getChildren().add(circle2);

        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(8000));
        rotate1.setNode(circle1);
        rotate1.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(500);
        rotate2.setDuration(Duration.millis(8000));
        rotate2.setNode(circle2);
        rotate2.play();
    }
}
class DoubleHCircle extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        //DOUBLE CIRCLE HORIZONTAL
        Arc arc = new Arc(190,150,100,100,0,90);
        arc.setStroke(Color.valueOf("FF0181"));
        arc.setStrokeWidth(20);
        arc.setFill(Color.TRANSPARENT);

        Arc arc2 = new Arc(190, 150, 100, 100, 90, 90);
        arc2.setStroke(Color.valueOf("FBE100"));
        arc2.setStrokeWidth(20);
        arc2.setFill(Color.TRANSPARENT);

        Arc arc3 = new Arc(190, 150, 100, 100, 180, 90);
        arc3.setStroke(Color.valueOf("910DFF"));
        arc3.setStrokeWidth(20);
        arc3.setFill(Color.TRANSPARENT);

        Arc arc4 = new Arc(190, 150, 100, 100, 270, 90);
        arc4.setStroke(Color.valueOf("33DBF0"));
        arc4.setStrokeWidth(20);
        arc4.setFill(Color.TRANSPARENT);

        Arc arc5 = new Arc(410,150,100,100,0,90);
        arc5.setStroke(Color.valueOf("FBE100"));
        arc5.setStrokeWidth(20);
        arc5.setFill(Color.TRANSPARENT);

        Arc arc6 = new Arc(410, 150, 100, 100, 90, 90);
        arc6.setStroke(Color.valueOf("FF0181"));
        arc6.setStrokeWidth(20);
        arc6.setFill(Color.TRANSPARENT);

        Arc arc7 = new Arc(410, 150, 100, 100, 180, 90);
        arc7.setStroke(Color.valueOf("33DBF0"));
        arc7.setStrokeWidth(20);
        arc7.setFill(Color.TRANSPARENT);

        Arc arc8 = new Arc(410, 150, 100, 100, 270, 90);
        arc8.setStroke(Color.valueOf("910DFF"));
        arc8.setStrokeWidth(20);
        arc8.setFill(Color.TRANSPARENT);

        a.add(arc);
        a.add(arc2);
        a.add(arc3);
        a.add(arc4);
        a.add(arc6);
        a.add(arc7);
        a.add(arc8);

        //rotation of circle
        Group circle1 = new Group(arc, arc2, arc3, arc4);
        Group circle2=new Group (arc5,arc6,arc7,arc8);

        circle1.setTranslateY(800*(count[0]+1)-500);
        circle2.setTranslateY(800*(count[0]+1)-500);
        main.getChildren().add(circle1);
        main.getChildren().add(circle2);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setCycleCount(500);
        Starrotate.setByAngle(360);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setNode(star);
        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-500);
        main.getChildren().add(star);
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(8000));
        rotate1.setNode(circle1);
        rotate1.play();

        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(500);
        rotate2.setDuration(Duration.millis(8000));
        rotate2.setNode(circle2);
        rotate2.play();
    }
}
class RotatingX extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line x1=new Line(250,200,250,300);
        x1.setStroke(Color.valueOf("FF0181"));
        x1.setStrokeWidth(20);

        Line x2=new Line(250,300,250,400);
        x2.setStroke(Color.valueOf("FBE100"));
        x2.setStrokeWidth(20);

        Line x3=new Line(150,300,250,300);
        x3.setStroke(Color.valueOf("910DFF"));
        x3.setStrokeWidth(20);

        Line x4=new Line(250,300,350,300);
        x4.setStroke(Color.valueOf("33DBF0"));
        x4.setStrokeWidth(20);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-300);
        main.getChildren().add(star);
        Group cross = new Group(x1, x2, x3, x4);
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(-360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(5000));
        rotate.setNode(cross);
        rotate.play();
        Starrotate.setCycleCount(500);
       // System.out.println(cross.getLayoutY());
        cross.setTranslateX(0);
        cross.setTranslateY(800*(count[0]+1)-500);
        main.getChildren().add(cross);
        a.add(x1);
        a.add(x2);
        a.add (x3);
        a.add (x4);


    }
}
class ConcCircle extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Arc cc1 = new Arc(300,150,130,130,45,90);
        cc1.setStroke(Color.valueOf("FF0181"));
        cc1.setStrokeWidth(20);
        cc1.setFill(Color.TRANSPARENT);

        Arc cc2 = new Arc(300, 150, 130, 130, 135, 90);
        cc2.setStroke(Color.valueOf("FBE100"));
        cc2.setStrokeWidth(20);
        cc2.setFill(Color.TRANSPARENT);

        Arc cc3 = new Arc(300, 150, 130, 130, 225, 90);
        cc3.setStroke(Color.valueOf("910DFF"));
        cc3.setStrokeWidth(20);
        cc3.setFill(Color.TRANSPARENT);

        Arc cc4 = new Arc(300, 150, 130, 130, 315, 90);
        cc4.setStroke(Color.valueOf("33DBF0"));
        cc4.setStrokeWidth(20);
        cc4.setFill(Color.TRANSPARENT);

        Arc cc5 = new Arc(300,150,100,100,45,90);
        cc5.setStroke(Color.valueOf("FF0181"));
        cc5.setStrokeWidth(20);
        cc5.setFill(Color.TRANSPARENT);

        Arc cc6 = new Arc(300, 150, 100, 100, 135, 90);
        cc6.setStroke(Color.valueOf("33DBF0"));
        cc6.setStrokeWidth(20);
        cc6.setFill(Color.TRANSPARENT);

        Arc cc7 = new Arc(300, 150, 100, 100, 225, 90);
        cc7.setStroke(Color.valueOf("910DFF"));
        cc7.setStrokeWidth(20);
        cc7.setFill(Color.TRANSPARENT);

        Arc cc8 = new Arc(300, 150, 100, 100, 315, 90);
        cc8.setStroke(Color.valueOf("FBE100"));
        cc8.setStrokeWidth(20);
        cc8.setFill(Color.TRANSPARENT);

        a.add(cc1);
        a.add(cc2);
        a.add(cc3);
        a.add(cc4);

        a.add(cc5);
        a.add(cc6);
        a.add(cc7);
        a.add(cc8);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setCycleCount(500);
        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-370);
        main.getChildren().add(star);
        Group bigCircle = new Group(cc1, cc2, cc3, cc4);
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(10000));
        rotate1.setNode(bigCircle);
        rotate1.play();
        main.getChildren().add(bigCircle);

        Group smallCircle = new Group(cc5, cc6, cc7, cc8);
        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(-360);
        rotate2.setCycleCount(500);
        rotate2.setDuration(Duration.millis(10000));
        rotate2.setNode(smallCircle);
        rotate2.play();
        main.getChildren().add(smallCircle);
        smallCircle.setTranslateY(800*(count[0]+1)-500);
        bigCircle.setTranslateY(800*(count[0]+1)-500);
    }
}
class XinCircle extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line x1=new Line(250,200,250,250);
        x1.setStroke(Color.valueOf("FF0181"));
        x1.setStrokeWidth(20);

        Line x2=new Line(250,200,250,150);
        x2.setStroke(Color.valueOf("FBE100"));
        x2.setStrokeWidth(20);

        Line x3=new Line(250,200,200,200);
        x3.setStroke(Color.valueOf("910DFF"));
        x3.setStrokeWidth(20);

        Line x4=new Line(250,200,300,200);
        x4.setStroke(Color.valueOf("33DBF0"));
        x4.setStrokeWidth(20);

        Arc arc = new Arc(300,200,125,125,0,90);
        arc.setStroke(Color.valueOf("FF0181"));
        arc.setStrokeWidth(20);
        arc.setFill(Color.TRANSPARENT);

        Arc arc2 = new Arc(300, 200, 125, 125, 90, 90);
        arc2.setStroke(Color.valueOf("FBE100"));
        arc2.setStrokeWidth(20);
        arc2.setFill(Color.TRANSPARENT);

        Arc arc3 = new Arc(300, 200, 125, 125, 180, 90);
        arc3.setStroke(Color.valueOf("910DFF"));
        arc3.setStrokeWidth(20);
        arc3.setFill(Color.TRANSPARENT);

        Arc arc4 = new Arc(300, 200, 125, 125, 270, 90);
        arc4.setStroke(Color.valueOf("33DBF0"));
        arc4.setStrokeWidth(20);
        arc4.setFill(Color.TRANSPARENT);

        Group cross = new Group(x1, x2, x3, x4);
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(-360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(5000));
        rotate.setNode(cross);
        rotate.play();
        main.getChildren().add(cross);
        a.add(x1);
        a.add(x2);
        a.add (x3);
        a.add (x4);

        a.add(arc);
        a.add(arc2);
        a.add(arc3);
        a.add(arc4);


        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));

        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-300);
        main.getChildren().add(star);
        //rotation of circle
        Group circle1 = new Group(arc, arc2, arc3, arc4);
        main.getChildren().add(circle1);
        cross.setTranslateY(800*(count[0]+1)-500);
        circle1.setTranslateY(800*(count[0]+1)-500);
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(8000));
        rotate1.setNode(circle1);
        rotate1.play();
    }
}
class HLine extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line hl1=new Line(0,200,200,200);
        hl1.setStroke(Color.valueOf("910DFF"));
        hl1.setStrokeWidth(20);

        Line hl2=new Line(200,200,400,200);
        hl2.setStroke(Color.valueOf("33DBF0"));
        hl2.setStrokeWidth(20);

        Line hl3=new Line(400,200,600,200);
        hl3.setStroke(Color.valueOf("FF0181"));
        hl3.setStrokeWidth(20);

        Line hl4=new Line(600,200,800,200);
        hl4.setStroke(Color.valueOf("FBE100"));
        hl4.setStrokeWidth(20);

        Line hl5=new Line(800,200,1000,200);
        hl5.setStroke(Color.valueOf("910DFF"));
        hl5.setStrokeWidth(20);

        Line hl6=new Line(1000,200,1200,200);
        hl6.setStroke(Color.valueOf("33DBF0"));
        hl6.setStrokeWidth(20);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-400);
        main.getChildren().add(star);

        Group line = new Group( hl1, hl2, hl3, hl4,hl5,hl6);
        line.setTranslateY(800*(count[0]+1)-500);
        a.add(hl3);
        a.add(hl4);
        a.add(hl5);
        a.add(hl6);
        a.add(hl1);
        a.add(hl2);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(8000));
        translateTransition.setNode(line);
        translateTransition.setByX(-600);
        translateTransition.setCycleCount(500);

        translateTransition.setAutoReverse(true);
        translateTransition.play();
        main.getChildren().add(line);
    }
}
class VLines extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line vl1=new Line(0,250,0,400);
        vl1.setStroke(Color.valueOf("910DFF"));
        vl1.setStrokeWidth(20);

        Line vl2=new Line(200,250,200,400);
        vl2.setStroke(Color.valueOf("33DBF0"));
        vl2.setStrokeWidth(20);

        Line vl3=new Line(400,250,400,400);
        vl3.setStroke(Color.valueOf("FF0181"));
        vl3.setStrokeWidth(20);

        Line vl4=new Line(600,250,600,400);
        vl4.setStroke(Color.valueOf("FBE100"));
        vl4.setStrokeWidth(20);

        Line vl5=new Line(800,250,800,400);
        vl5.setStroke(Color.valueOf("910DFF"));
        vl5.setStrokeWidth(20);

        Line vl6=new Line(1000,250,1000,400);
        vl6.setStroke(Color.valueOf("33DBF0"));
        vl6.setStrokeWidth(20);

        Line vl7=new Line(-400,300,-400,350);
        vl7.setStroke(Color.valueOf("910DFF"));
        vl7.setStrokeWidth(20);

        Line vl8=new Line(-200,300,-200,350);
        vl8.setStroke(Color.valueOf("33DBF0"));
        vl8.setStrokeWidth(20);

        Line vl9=new Line(0,300,0,350);
        vl9.setStroke(Color.valueOf("FF0181"));
        vl9.setStrokeWidth(20);

        Line vl10=new Line(200,300,200,350);
        vl10.setStroke(Color.valueOf("FBE100"));
        vl10.setStrokeWidth(20);

        Line vl11=new Line(400,300,400,350);
        vl11.setStroke(Color.valueOf("910DFF"));
        vl11.setStrokeWidth(20);

        Line vl12=new Line(600,300,600,350);
        vl12.setStroke(Color.valueOf("33DBF0"));
        vl12.setStrokeWidth(20);


        Group line1 = new Group( vl1, vl2, vl3, vl4,vl5,vl6);
        Group line2 = new Group( vl7, vl8, vl9, vl10,vl11,vl12);
        line1.setTranslateY(800*(count[0]+1)-500);
        line2.setTranslateY(800*(count[0]+1)-500);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-300);
        main.getChildren().add(star);
        a.add(vl3);
        a.add(vl4);
        a.add(vl5);
        a.add(vl6);
        a.add(vl1);
        a.add(vl2);

        a.add(vl7);
        a.add(vl8);
        a.add(vl9);
        a.add(vl10);
        a.add(vl11);
        a.add(vl12);

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(8000));
        translateTransition.setNode(line1);
        translateTransition.setByX(-600);
        translateTransition.setCycleCount(500);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        main.getChildren().add(line1);

        TranslateTransition translateTransition2 = new TranslateTransition();
        translateTransition2.setDuration(Duration.millis(6000));
        translateTransition2.setNode(line2);
        translateTransition2.setByX(600);
        translateTransition2.setCycleCount(500);
        translateTransition2.setAutoReverse(true);
        translateTransition2.play();
        main.getChildren().add(line2);
    }
}
class DoubleX extends Obstacles{

    @Override
    void InitiateObstacle(ArrayList<ImageView> starlist, ArrayList<Shape> a, int[] count, AnchorPane main,int[] difficulty) {
        Line dx1=new Line(200,200,200,300);
        dx1.setStroke(Color.valueOf("FF0181"));
        dx1.setStrokeWidth(20);

        Line dx2=new Line(200,300,200,400);
        dx2.setStroke(Color.valueOf("FBE100"));
        dx2.setStrokeWidth(20);

        Line dx3=new Line(100,300,200,300);
        dx3.setStroke(Color.valueOf("910DFF"));
        dx3.setStrokeWidth(20);

        Line dx4=new Line(200,300,300,300);
        dx4.setStroke(Color.valueOf("33DBF0"));
        dx4.setStrokeWidth(20);

        Line dx5=new Line(400,200,400,300);
        dx5.setStroke(Color.valueOf("FF0181"));
        dx5.setStrokeWidth(20);

        Line dx6=new Line(400,300,400,400);
        dx6.setStroke(Color.valueOf("FBE100"));
        dx6.setStrokeWidth(20);

        Line dx7=new Line(300,300,400,300);
        dx7.setStroke(Color.valueOf("33DBF0"));
        dx7.setStrokeWidth(20);

        Line dx8=new Line(400,300,500,300);
        dx8.setStroke(Color.valueOf("910DFF"));
        dx8.setStrokeWidth(20);

        Group cross1 = new Group(dx1, dx2, dx3, dx4);
        RotateTransition rotate1 = new RotateTransition();
        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(-360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(5000));
        rotate1.setNode(cross1);
        rotate1.play();
        main.getChildren().add(cross1);
        a.add(dx1);
        a.add(dx2);
        a.add (dx3);
        a.add (dx4);

        Group cross2 = new Group(dx5, dx6, dx7, dx8);
        cross1.setTranslateY(800*(count[0]+1)-500);
        cross2.setTranslateY(800*(count[0]+1)-500);
        RotateTransition rotate2 = new RotateTransition();
        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(360);
        rotate2.setCycleCount(500);
        rotate2.setDuration(Duration.millis(5000));
        rotate2.setNode(cross2);
        rotate2.play();
        main.getChildren().add(cross2);
        a.add(dx5);
        a.add(dx6);
        a.add (dx7);
        a.add (dx8);
        RotateTransition Starrotate = new RotateTransition();
        Starrotate.setAxis(Rotate.Z_AXIS);
        Starrotate.setByAngle(360);
        Starrotate.setCycleCount(500);
        Starrotate.setDuration(Duration.millis(5000));
        Starrotate.setNode(star);

        Starrotate.play();
        starlist.add(star);
        star.setX(280);
        star.setY(800*(count[0]+1)-300);
        main.getChildren().add(star);
    }
}