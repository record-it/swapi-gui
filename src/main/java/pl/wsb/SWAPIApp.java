package pl.wsb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pl.wsb.model.Film;
import pl.wsb.model.Person;
import pl.wsb.model.PersonDomain;
import pl.wsb.repository.SWAPIFilmRepository;
import pl.wsb.repository.SWAPIPeopleRepository;
import pl.wsb.repository.SWFilmRepository;
import pl.wsb.repository.SWPeopleRepository;
import pl.wsb.service.SWAPIPeopleService;
import pl.wsb.service.SWPeopleService;

import java.time.LocalDate;
import java.util.Optional;


public class SWAPIApp extends Application {
    SWPeopleRepository peopleRepository = new SWAPIPeopleRepository();
    SWFilmRepository filmRepository = new SWAPIFilmRepository();
    SWPeopleService peopleService = new SWAPIPeopleService(filmRepository, peopleRepository);
    Label nameLabel = new Label("Nazwisko i imię");
    TextField name = new TextField();
    Label heightLabel = new Label("Wysokość");
    TextField height = new TextField();
    Label hairLabel = new Label("Kolor włosów");
    TextField hair = new TextField();
    Label filmsLabel = new Label("Filmy z udziałem postaci");
    ListView<Film> films = new ListView<>();
    Label createdLabel = new Label("Data utworzenia");
    DatePicker created = new DatePicker();
    VBox personForm = new VBox();
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        swapiGui(stage);
    }
    private void swapiGui(Stage stage){
        VBox root = new VBox();
        personForm.setSpacing(5);
        personForm.setPadding(new Insets(10));
        personForm.getChildren().addAll(
                nameLabel, name,
                heightLabel, height,
                hairLabel, hair,
                filmsLabel, films,
                createdLabel, created
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        Label label = new Label("Id osoby");
        TextField field = new TextField();
        Button button = new Button("Szukaj");
        TextArea info = new TextArea();
        root.getChildren().addAll(label, field, button, info, personForm);
        button.setOnAction(event -> {
            String text = field.getText();
            int id = Integer.parseInt(text);
            Optional<PersonDomain> person = peopleService.findDomainById(id);
            if (person.isPresent()){
                PersonDomain domain = person.get();
                Platform.runLater(() -> {
                    name.setText(domain.getName());
                    height.setText(Double.toString(domain.getHeight()));
                    films.getItems().clear();
                    films.getItems().addAll(domain.getFilms());
                    hair.setText(domain.getHairColor());
                    created.setValue(LocalDate.from(domain.getCreated().toLocalDateTime()));
                });

            }
//            peopleRepository.findByIdAsync(id, person -> {
//                Platform.runLater(() -> {
//                    name.setText(person.getName());
//                    height.setText(person.getHeight());
//                    hair.setText(person.getHair_color());
//                    films.getItems().clear();
//                    films.getItems().addAll(person.getFilms());
//                    created.setValue(LocalDate.from(person.getCreated().toLocalDateTime()));
//                });
//            });
        });
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
