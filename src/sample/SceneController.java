package sample;
import javafx.animation.PathTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class SceneController {
    @FXML
    private Button Animate;
    public void initialize(){
        Circle circle = new Circle(100);
        PathTransition transition=new PathTransition();
        transition.setNode(Animate);
        transition.setDuration(Duration.seconds(3));
        transition.setPath(circle);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();
    }
}
