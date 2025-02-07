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
import org.example.studentadminstator.data.Student;

import java.util.ArrayList;

public class StudentPageControls extends Application {
    GridPane container = new GridPane();
    AppData data = AppData.getInstance();
    CoursesDB<Course> coursesDB = data.getCoursesDB();
    private final ChoiceBox<Pair<String, String>> coursesSelect = new ChoiceBox<>();
    private final Button openSubscriptionButton = new Button("Open Subscription");
    private Student student;
    private String value ;
    public StudentPageControls(Student student){
        this.student = student;
    }
    public EventHandler<ActionEvent> openSubscripe() {
        return event -> {
            Stage subscriptionStage = new Stage();

            coursesSelect.getItems().clear();
            GridPane subscriptionLayout = subscripe(subscriptionStage);

            Scene subscriptionScene = new Scene(subscriptionLayout, 400, 300);
            subscriptionStage.setTitle("Subscription Page");
            subscriptionStage.setScene(subscriptionScene);
            subscriptionStage.show();
        };
    }

    public GridPane subscripe(Stage stage) {
        final ArrayList<Course> coursesData = (ArrayList<Course>) coursesDB.getAllCourses();

        System.out.println("Courses Data: " + coursesData);

        for (Course course : coursesData) {
            coursesSelect.getItems().add(new Pair<>(course.getName(), null));
        }

        if (!coursesSelect.getItems().isEmpty()) {
            coursesSelect.setValue(coursesSelect.getItems().get(0));
        }

        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveSelection(stage));

        GridPane.setHalignment(coursesSelect, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(coursesSelect, javafx.geometry.VPos.CENTER);

        container.add(coursesSelect, 0, 0);
        container.add(saveButton, 0, 1);

        return container;
    }

    private void saveSelection(Stage stage) {
        Pair<String, String> selectedCourse = coursesSelect.getValue();
        if (selectedCourse != null) {
           Course course = coursesDB.getOneCourseByStudentName(selectedCourse.getValue(),this.student.getStudentName());
           course.addStudentToCourse(this.student);
           value = selectedCourse.getValue();
           System.out.println("Course is saved successfully " + selectedCourse.getKey() + " Instructor " + selectedCourse.getValue());
            stage.close();
        } else {
            System.out.println("choese course before save");
        }
    }
    public String getValue(){
        return value;
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
