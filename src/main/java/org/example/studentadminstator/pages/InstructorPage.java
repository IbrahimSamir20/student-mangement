package org.example.studentadminstator.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.Instructor;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InstructorPage extends BorderPane {
        
        public InstructorPage(Stage primaryStage,Instructor instructor){
                Navbar navbar = new Navbar("", primaryStage);
                this.setTop(navbar);
                this.setMinSize(1024,900);


                CustomTable<Instructor> instructorTable = new CustomTable<Instructor>();
                instructorTable.addColumn("Course", "Course", 400);
                instructorTable.addColumn("Attendance", "Attendance", 400);
                instructorTable.addColumn("Grade", "Grade", 400);

                VBox instructorContainer = new VBox();
                instructorContainer.setPadding(new Insets(10));
                instructorContainer.setSpacing(10);

                Label courseLabel = new Label("Course");
                instructorContainer.getChildren().addAll(courseLabel, instructorTable);
                this.setCenter(instructorContainer);
                
        }

        public BorderPane getPage() {
                return this;
        }
}
