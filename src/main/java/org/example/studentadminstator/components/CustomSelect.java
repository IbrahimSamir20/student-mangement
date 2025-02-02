package org.example.studentadminstator.components;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.example.studentadminstator.AppStyle;

public class CustomSelect extends VBox{
    private Label label;
    private ToggleGroup toggleGroup;
    private Label errorMessage;

    public CustomSelect(String groupLabel, String... options) {
        label = new Label(groupLabel);
        label.setFont(AppStyle.font18Bold);
        label.setTextFill(AppStyle.textColor);
        toggleGroup = new ToggleGroup();
        HBox optionsBox = new HBox(10);
        optionsBox.setAlignment(Pos.CENTER_LEFT);

        for (String option : options) {
            RadioButton radioButton = new RadioButton(option);
            radioButton.setToggleGroup(toggleGroup);
            radioButton.setTextFill(AppStyle.textColor);
            radioButton.setFont(AppStyle.font14Bold);
            optionsBox.getChildren().add(radioButton);
        }
        errorMessage = new Label("You must select an option.");
        errorMessage.setTextFill(AppStyle.errorColor);
        errorMessage.setVisible(false);
        errorMessage.setFont(AppStyle.font14);
        toggleGroup.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal != null) {
                clearErrorMessage();
            }else {
                setErrorMessage();
            }
        });
        setSpacing(5);
        setPadding(new Insets(10));
        getChildren().addAll(label, optionsBox, errorMessage);
    }

    public String getSelectedOption() {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        return (selectedRadioButton != null) ? selectedRadioButton.getText() : null;
    }

    public void setSelectedOption(String option) {
        for (javafx.scene.Node node : ((HBox)getChildren().get(1)).getChildren()) {
            RadioButton radioButton = (RadioButton) node;
            if (radioButton.getText().equals(option)) {
                radioButton.setSelected(true);
                break;
            }
        }
    }

    public Label getLabel() {
        return label;
    }
    //Add Indication to show that he must select the option
    public Boolean isValid() {
        boolean isValid = toggleGroup.getSelectedToggle() != null;
        errorMessage.setVisible(!isValid);
        return isValid;
    }
    public void setErrorMessage(){
        this.errorMessage.setVisible(true);
    }

    public void clearErrorMessage(){
        this.errorMessage.setText("");
        this.errorMessage.setVisible(false);
    }
}


