package org.example.studentadminstator.Controls;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.data.Course;
import org.example.studentadminstator.data.CoursesDB;

import java.util.ArrayList;

public class StudentPageControls extends Application {
    GridPane container = new GridPane();
    AppData data = AppData.getInstance();
    CoursesDB<Course> coursesDB = data.getCoursesDB();
    private final ChoiceBox<Pair<String, String>> coursesSelect = new ChoiceBox<>();
    private final Button openSubscriptionButton = new Button("Open Subscription");

    public EventHandler<ActionEvent> openSubscripe() {
        return event -> {
            Stage subscriptionStage = new Stage();
            GridPane subscriptionLayout = subscripe();

            Scene subscriptionScene = new Scene(subscriptionLayout, 400, 300);
            subscriptionStage.setTitle("Subscription Page");
            subscriptionStage.setScene(subscriptionScene);
            subscriptionStage.show();
        };
    }

    public GridPane subscripe() {
        final ArrayList<Course> coursesData = coursesDB.fetch();
        System.out.println(coursesData);

        GridPane.setHalignment(coursesSelect, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(coursesSelect, javafx.geometry.VPos.CENTER);

        container.add(coursesSelect, 0, 0);

        return container;
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane mainLayout = new GridPane();
        openSubscriptionButton.setOnAction(openSubscripe());

        mainLayout.add(openSubscriptionButton, 0, 0);

        Scene scene = new Scene(mainLayout, 300, 200);
        primaryStage.setTitle("Main Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
