package org.example.studentadminstator.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
// import org.example.studentadminstator.components.CustomButton;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.AppStyle;
import org.example.studentadminstator.components.*;
import org.example.studentadminstator.data.Course;
import org.example.studentadminstator.data.User;
import org.example.studentadminstator.data.CoursesDB;
import org.example.studentadminstator.data.UsersDB;
import org.example.studentadminstator.data.InstructorDB;
import org.example.studentadminstator.data.StudentDB;
import org.example.studentadminstator.data.Instructor;
import org.example.studentadminstator.data.Student;

// import java.beans.EventHandler;
// import java.lang.reflect.Array;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.List;


public class AdministerPage extends BorderPane {
        AppData data = AppData.getInstance();
        UsersDB<User> usersDB = data.getUsersDB();
        InstructorDB<Instructor> instructorDB = data.getInstructorDB();
        StudentDB<Student> studentDB = data.getStudentDB();
        CoursesDB<Course> coursesDB = data.getCoursesDB();
        private Stage primaryStage;
        private int index = 0;

        private EventHandler[] handlers = new EventHandler[3];

        public AdministerPage(Stage primaryStage) {
                this.primaryStage = primaryStage;
                this.setBackground(AppStyle.background);
                EventHandler<ActionEvent> onAdd = event -> {
                        if(index == 0){
                                //Add in instructor
                                Scene previousScene = primaryStage.getScene();
                                VBox instructorAddBox = new VBox();
                                CustomInput instructorInputName = new CustomInput("Enter instructor name ","Name :" );
                                CustomInput courseInput = new CustomInput("Enter Course name ","Course Name :" );
                                CustomButton submit = new CustomButton(e->{
                                instructorDB.createInstructor(new Instructor(instructorInputName.getInputValue(), instructorInputName.getInputValue(), "Instructor"));
                                coursesDB.createCourse(new Course(courseInput.getInputValue(),new Instructor(instructorInputName.getInputValue(), instructorInputName.getInputValue(), "Instructor")));
                                        primaryStage.setScene(previousScene);
                                },"Save");
                                instructorAddBox.getChildren().addAll(instructorInputName, courseInput,submit);
                                primaryStage.setScene(new Scene(instructorAddBox));
                        }else if (index == 1){
                                //Add in Student
                                Scene previousScene = primaryStage.getScene();
                                VBox studentAddBox = new VBox();
                                CustomInput studentName = new CustomInput("Enter student name","Name:");
                                CustomInput studentCourse= new CustomInput("Enter Course Name","Course:");
                                CustomInput studentGrade= new CustomInput("Enter Grade","Grade:");
                                CustomInput studentAttendance= new CustomInput("Enter Attendance","Attendance:");
                                CustomButton button = new CustomButton(e->{

                                        studentDB.createStudent(new Student(studentName.getInputValue(), studentName.getInputValue(), "Student", studentName.getInputValue()) {
                                                @Override
                                                public String getUserName() {
                                                        return "";
                                                }
                                        });
//                                if(coursesDB.getOneCourseByStudentName(studentCourse.getInputValue())){
//                                        coursesDB.updateCourseAddStudents(studentCourse.getInputValue(), new Student(studentName.getInputValue(), studentName.getInputValue(), "Student", studentName.getInputValue()));
//                                }else{
//                                        coursesDB.createCourse(new Course(studentCourse.getInputValue(), studentAttendance.getInputValue(),Integer.parseInt(studentGrade.getInputValue())));
//                                }
                                primaryStage.setScene(previousScene);
                                        },"Save");
                                studentAddBox.getChildren().addAll(studentName,studentCourse,studentGrade,studentAttendance,button);
                                primaryStage.setScene(new Scene(studentAddBox));

                        }else{
                                //Add in Course
                                Scene previousScene = primaryStage.getScene();
                                VBox courseAddBox = new VBox();
                                CustomInput courseNameInput = new CustomInput("Enter Course Name","");
                                CustomInput courseInstructorInput = new CustomInput("Enter Course Name","");
                                CustomButton button = new CustomButton(e->{
                                        coursesDB.createCourse(new Course(courseNameInput.getInputValue(), new Instructor(courseInstructorInput.getInputValue(), courseInstructorInput.getInputValue(), "Instructor")));
                               primaryStage.setScene(previousScene);
                                }, "Submit");

                                courseAddBox.getChildren().addAll(courseNameInput,courseInstructorInput,button);
                                primaryStage.setScene(new Scene(courseAddBox));
                        }
                };
                EventHandler<ActionEvent> onEdit = event -> {};
                EventHandler<ActionEvent> onBack = event -> {
                        primaryStage.setScene(new Scene(new Login(primaryStage).getGrid()));
                        primaryStage.show();
                };
                String[] labels = {"Add","Edit", "Back"};
                EventHandler[] navHandlers = {onAdd,onEdit, onBack};
                CustomButton[] buttons = {new CustomButton(),new CustomButton(), new CustomButton()};
                Navbar navbar = new Navbar("Admin Dashboard",primaryStage, labels, buttons,navHandlers);
                this.setTop(navbar);
                CustomTable<Course> courseTable = new CustomTable<>();

                VBox courseContainer = new VBox();
                courseContainer.setPadding(new Insets(10));
                courseContainer.setSpacing(10);

                Label courseLabel = new Label();
                courseContainer.getChildren().addAll(courseLabel, courseTable);
                this.setCenter(courseContainer);

                //Empty Table columns before adding new columns
                handlers[0] = e -> {
                        index = 0;
                        courseTable.deleteColumns();
                        System.out.println("Instructor clicked");
                        courseTable.addColumn("Instructor Name", "instructorName", 200);
                        courseTable.addColumn("Course", "name", 100);

                        ObservableList<Course> tableInstructor = FXCollections.observableArrayList();
                        ArrayList<Course> courses= (ArrayList<Course>) coursesDB.getAllCourses();
                        for(Course c : courses){

                                tableInstructor.add(new Course(c.getName(),c.getInstructorName()));
                        }
                        courseTable.setTableData(tableInstructor);


                };
                handlers[1] = e -> {
                        index = 1;
                        courseTable.deleteColumns();
                        System.out.println("Student clicked");
                        courseTable.addColumn("Student", "students", 200);
                        courseTable.addColumn("Course", "name", 100);
                        courseTable.addColumn("Grade", "grade", 100);
                        courseTable.addColumn("Attendance", "attendant", 100);

                        ObservableList<Course> tableStudent = FXCollections.observableArrayList();
                        ArrayList<Course> courses= (ArrayList<Course>) coursesDB.getAllCourses();
                        for (Course c : courses) {
                                if (c.getStudentsAtCourse() != null) {
                                        List<String> studentNames = new ArrayList<>();
                                        for (Student student : c.getStudentsAtCourse()) {
                                                studentNames.add(student.getStudentName());
                                        }
                                        //TODO(Nancy): Add Student to Tableview
                                        tableStudent.add(c);
                                }
                        }
                        courseTable.setTableData(tableStudent);

                };
                handlers[2] = e -> {
                        index = 2;
                        courseTable.deleteColumns();
                        System.out.println("Courses clicked");
                        courseTable.addColumn("Course", "name", 100);
                        courseTable.addColumn("Instructor", "instructor", 100);
                        courseTable.addColumn("Student", "students", 100);

                        ObservableList<Course> tableCourse = FXCollections.observableArrayList();
                        List<Course> courses= coursesDB.getAllCourses();
                        for(Course c : courses){
                                tableCourse.add(c);
                        }
                        courseTable.setTableData(tableCourse);

                };

                Sidebar sidebar = new Sidebar("dashboard",handlers);
                this.setLeft(sidebar);


        }
        //TODO: Editable Table and Add Course Button

        public BorderPane getPage() {
                return this;
        }
}