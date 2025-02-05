package org.example.studentadminstator.components;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.studentadminstator.AppData;
import org.example.studentadminstator.data.Instructor;
import org.example.studentadminstator.data.Student;

public class CustomPopUp<T> extends Stage {

    private String name;
    private Navbar navbar;
    private AppData appData;
    private T data;
    public CustomPopUp(Stage primaryStage,String name,T data, Navbar navbar, AppData appData) {
        this.name = name;
        this.data = data;
        this.navbar = navbar;
        this.appData = appData;

        initModality(Modality.APPLICATION_MODAL);
        initOwner(primaryStage);
        setTitle("Edit Name");

        TextField nameField = new TextField(name);
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        saveButton.setOnAction(e -> {
            String newName = nameField.getText();
            if (!newName.isEmpty()) {
                nameField.setText(newName);
                //To Handle If the edit is from instructor or from student
                if (data instanceof Student student) {
                    student.setUsername(newName);
                    student.setName(newName);
                    appData.getStudentDB().updateStudentWithoutIndex(student);
                    appData.getUsersDB().fetchOneUser(name).setUsername(newName);
                    if (navbar != null) {
                        navbar.updateStudentName(newName);
                    } else {
                        System.err.println("Navbar is null. Cannot update name.");
                    }

                } else if (data instanceof Instructor instructor) {
                    instructor.setName(newName);
                    instructor.setUsername(newName);
                    appData.getInstructorDB().updateInstructorWithoutIndex(instructor);
                    appData.getUsersDB().fetchOneUser(name).setUsername(newName);
                    if (navbar != null) {
                        navbar.updateStudentName(newName);
                    } else {
                        System.err.println("Navbar is null. Cannot update name.");
                    }

                }


                close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Name cannot be empty.");
                alert.showAndWait();
            }
        });

        cancelButton.setOnAction(e -> close());

        VBox popupContent = new VBox(10, nameField, saveButton, cancelButton);
        popupContent.setPadding(new Insets(10));
        popupContent.setAlignment(Pos.CENTER);

        setScene(new Scene(popupContent));
    }

    public void showAndWait() {
        super.showAndWait();
    }
}