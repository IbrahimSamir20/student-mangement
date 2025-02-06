package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.components.CustomPopUp;
import org.example.studentadminstator.components.CustomTable;
import org.example.studentadminstator.components.Navbar;
import org.example.studentadminstator.data.*;
import java.util.ArrayList;

public class StudentPage extends BorderPane {
    AppData appData = AppData.getInstance();
    CoursesDB<Course> coursesDB = appData.getCoursesDB();
    InstructorDB<Instructor> instructorDB = appData.getInstructorDB();

       public StudentPage(Stage primaryStage,Student student){
           EventHandler<ActionEvent> onEdit = event -> {
               CustomPopUp popup = new CustomPopUp(primaryStage, student.getName(),student, (Navbar) this.getTop(), appData);
               popup.showAndWait();
           };

           EventHandler<ActionEvent> onBack = event -> {
               primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
               primaryStage.show();
           };

           String[] labels = {"Edit", "Back"};

           EventHandler[] navHandlers = {onEdit, onBack};

           CustomButton[] buttons = {new CustomButton(), new CustomButton()};

           Navbar navbar = new Navbar(student.getName(), primaryStage, labels, buttons,navHandlers);

           this.setTop(navbar);

           this.setMinSize(1024,900);

            this.setBackground(AppStyle.background);

            CustomTable<Course> studentTable = new CustomTable<Course>();

            studentTable.addColumn("Name", "name", 250);
            studentTable.addColumn("Attendance", "attendant", 250);
            studentTable.addColumn("Grade", "grade", 250);

           ObservableList<Course> tableCourses = FXCollections.observableArrayList();
           ArrayList<Course> courses= coursesDB.fetch();
           System.out.print(courses);
           //Adding data to tableview list
           for(Course course : courses){
               tableCourses.add(course);
           }

           studentTable.setTableData(tableCourses);
           VBox studentContainer = new VBox();
            studentContainer.setSpacing(10);
           studentContainer.setPadding(new Insets(10));
            this.setCenter(studentContainer);
           studentContainer.getChildren().add(studentTable);


       }



    public BorderPane getPage() {
        return this;
    }

}
