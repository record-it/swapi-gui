package pl.wsb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class SWAPIApp extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        swapiGui(stage);
    }
    private void swapiGui(Stage stage){
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        Label label = new Label("Id osoby");
        TextField field = new TextField();
        Button button = new Button("Szukaj");
        TextArea info = new TextArea();
        root.getChildren().addAll(label, field, button, info);

        Scene scene = new Scene(root, 400, 600);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Swapi gui");
        stage.show();
    }


    private void graphicsDemo(Stage stage) {
        Group root = new Group();
        Rectangle rectangle = new Rectangle(100,100,200,300);
        rectangle.setOnMouseClicked(event -> {
            rectangle.setFill(Color.BLUE);
        });
        root.getChildren().add(rectangle);
        Circle circle = new Circle(300, 200, 50);
        circle.setFill(Color.CYAN);
        circle.setStroke(Color.BURLYWOOD);
        circle.setStrokeWidth(5.5);
        root.getChildren().add(circle);
        circle.setOnMouseClicked(event -> {
            new Thread(() -> {
                final double startX = circle.getCenterX();
                final double startY = circle.getCenterY();
                for(int i = 0; i < 100; i++){
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final double delta = i;
                    Platform.runLater(() -> {
                        circle.setCenterX(startX + delta);
                        circle.setCenterY(startY + delta);
                    });

                }
            }).start();
        });

        Scene scene = new Scene(root, 600, 400);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Swapi gui");
        stage.show();
    }
}
