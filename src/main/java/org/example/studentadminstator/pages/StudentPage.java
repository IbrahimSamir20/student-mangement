package org.example.studentadminstator.pages;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.Student;
import org.example.studentadminstator.data.StudentDB;

public class StudentPage extends VBox {
       private GridPane gridPane = new GridPane();
       private Navbar navbar = new Navbar("Student");
       public StudentPage(Stage primaryStage){
           gridPane.setVgap(15);
           gridPane.setHgap(15);
           gridPane.setPadding(new Insets(10, 10, 10, 10));
           gridPane.getChildren().add(navbar);

            CustomTable<Student> studentTable = new CustomTable<Student>();
            studentTable.addColumn("Course", "Course", 50);
            studentTable.addColumn("Attendance", "Attendance", 50);
            studentTable.addColumn("Grade", "Grade", 50);

           gridPane.add(studentTable, 0, 0);
            this.getChildren().add(gridPane);
                
        }

       public GridPane getGrid () {


        return gridPane;

}

}
