package org.example.studentadminstator.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.Student;
import org.example.studentadminstator.data.StudentDB;

public class StudentPage extends BorderPane {

       private GridPane gridPane = new GridPane();
       private Navbar navbar = new Navbar("Student");
      
       public StudentPage(Stage primaryStage,Student student){
          gridPane.setVgap(15);
          gridPane.setHgap(15);
          gridPane.setPadding(new Insets(10, 10, 10, 10));
           gridPane.getChildren().add(navbar);



       
           Navbar navbar = new Navbar("Student");
           this.setTop(navbar);
           this.setMinSize(1024,900);


            CustomTable<Student> studentTable = new CustomTable<Student>();
            studentTable.addColumn("Course", "Course", 400);
            studentTable.addColumn("Attendance", "Attendance", 400);
            studentTable.addColumn("Grade", "Grade", 400);

            VBox studentContainer = new VBox();
            studentContainer.setPadding(new Insets(10));
            studentContainer.setSpacing(10);

            Label courseLabel = new Label("Course");
            studentContainer.getChildren().addAll(courseLabel, studentTable);
            this.setCenter(studentContainer);
            //ADD Course button
        }

    public BorderPane getPage() {
        return this;
    }

}
