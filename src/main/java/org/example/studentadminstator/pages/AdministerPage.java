package org.example.studentadminstator.pages;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.components.Sidebar;
import org.example.studentadminstator.data.Course;

import java.lang.reflect.Array;


public class AdministerPage extends BorderPane {
        Array array = new Array();
        public AdministerPage() {
                this.setStyle("-fx-background-color: black;");

                Navbar navbar = new Navbar("Admin Dashboard");
                this.setTop(navbar);

                Sidebar sidebar = new Sidebar("Dashboard",, new CustomButton(actionEvent -> {}, "Instructor"));
                this.setLeft(sidebar);

                CustomTable<Course> courseTable = new CustomTable<>();
                courseTable.addColumn("Course Name", "name", 400);

                VBox courseContainer = new VBox();
                courseContainer.setPadding(new Insets(10));
                courseContainer.setSpacing(10);

                Label courseLabel = new Label("Course");
                courseContainer.getChildren().addAll(courseLabel, courseTable);
                this.setCenter(courseContainer);
        }

        public BorderPane getPage() {
                return this;
        }
}