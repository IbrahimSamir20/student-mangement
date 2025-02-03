package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.components.Sidebar;
import org.example.studentadminstator.data.Course;
import org.example.studentadminstator.AppStyle;

public class Administer {
    private BorderPane root;
    private Scene scene;

    public Administer() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: black;");

        Navbar navbar = new Navbar();
        root.setTop(navbar);
        //TODO: (Nancy) Check the new SideBar Parameters
        Sidebar sidebar = new Sidebar("Dashboard", new CustomButton(actionEvent -> {},"Instructor" ));
        root.setLeft(sidebar);

        CustomTable<Course> courseTable = new CustomTable<>();
        courseTable.addColumn("Course Name", "name", 400);
        courseTable.setTableData(getSampleData());

        VBox courseContainer = new VBox();
        courseContainer.setPadding(new Insets(10));
        courseContainer.setSpacing(10);

        Label courseLabel = new Label("Course");
        courseLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: white;");


        courseContainer.getChildren().addAll(courseLabel,  courseTable);
        root.setCenter(courseContainer);

        // Scene
        scene = new Scene(root, 800, 600);
    }

    public Scene getScene() {
        return scene;
    }

    private ObservableList<Course> getSampleData() {
        return FXCollections.observableArrayList(
                new Course("JavaFX Basics"),
                new Course("Advanced Java"),
                new Course("UI/UX Design")
        );
    }
}
