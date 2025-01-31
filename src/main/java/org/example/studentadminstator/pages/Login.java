package org.example.studentadminstator.pages;
import org.example.studentadminstator.AppStyle;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.Alert;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Login extends VBox {
    private GridPane grid = new GridPane();
    private Text errorText = new Text();
    private Label usernameLabel = new Label();
    private TextField usernameField = new TextField();
    private Label passwordLabel = new Label();
    private PasswordField passwordField = new PasswordField();
    private Button loginButton = new Button();

    public Login(Stage primaryStage) {
        
        grid.setVgap(15);
        grid.setHgap(15);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10, 10, 10, 10));
        
        // Set the background using the BackgroundImage
        Background background = new Background(AppStyle.backgroundImage);
        grid.setBackground(background);

        
        
        usernameLabel.setTextFill(AppStyle.textColor);
        usernameLabel.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        usernameField.setFont(AppStyle.font18);
        usernameField.setPrefWidth(300);

        passwordLabel.setTextFill(AppStyle.textColor);
        passwordLabel.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        passwordField.setFont(AppStyle.font18);
        passwordField.setPrefWidth(300);
        loginButton.setTextFill(AppStyle.textColor);
        loginButton.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        loginButton.setPrefWidth(100);
        loginButton.setTextFill(AppStyle.textColor);

        usernameField.setPromptText("Enter your username");
        passwordField.setPromptText("Enter your password");
        
        grid.add(usernameLabel, 0, 0, 1, 1);
        grid.add(usernameField, 0, 1, 1, 1);
        grid.add(passwordLabel, 0, 2, 1, 1);
        grid.add(passwordField, 0, 3, 1, 1);
        grid.add(loginButton, 0, 4, 1, 1);
        
        loginButton.setOnAction(e -> {
            if (usernameField.getText().equals("ibrahim") && passwordField.getText().equals("Doaa26102018")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Login successful");
                alert.show();
                
        
    
            } else if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()) {
               Text errorText = new Text("Please enter your username and password");
               errorText.setFont(AppStyle.font18);
               errorText.setFill(AppStyle.errorColor);
               grid.add(errorText, 0, 5, 1, 1);
               
               
            }
        });
    }
    public GridPane getGrid(){
        return grid;
    }
}

