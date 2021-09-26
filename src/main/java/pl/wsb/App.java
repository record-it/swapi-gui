package pl.wsb;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

class Person{
    final String name;
    final int point;

    Person(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", point=" + point +
                '}';
    }
}
public class App extends Application {
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        var ellipse = new Ellipse(100, 100, 50, 50);
        ellipse.setFill(Color.BURLYWOOD);
        ellipse.setStrokeWidth(3);
        ellipse.setStroke(Color.BLACK);
        var line = new Line(50, 20, 100,200);
        root.getChildren().addAll(ellipse, line);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}