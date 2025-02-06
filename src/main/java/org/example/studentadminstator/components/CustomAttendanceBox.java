package org.example.studentadminstator.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.List;

public class CustomAttendanceBox extends GridPane {

    private int numBoxes;
    private List<CheckBox> checkBoxes;
    private int selectedCount;
    private int daysInWeek = 6; // Number of days displayed (excluding Friday)

    public CustomAttendanceBox(int numBoxes) {
        this.numBoxes = numBoxes;
        this.checkBoxes = new ArrayList<>();
        this.selectedCount = 0;

        setHgap(5);
        setVgap(5);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);

        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Saturday"}; // Removed Friday
        for (int i = 0; i < daysInWeek; i++) {
            Label dayLabel = new Label(daysOfWeek[i]);
            add(dayLabel, i + 1, 0);
        }

        int week = 1;
        int row = 1;
        int col = 1;

        for (int i = 0; i < numBoxes; i++) {
            if (col == 1) {
                Label weekLabel = new Label("Week " + week);
                add(weekLabel, 0, row);
                week++;
            }

            CheckBox checkBox = new CheckBox();
            checkBox.setOnAction(e -> {
                if (checkBox.isSelected()) {
                    selectedCount++;
                } else {
                    selectedCount--;
                }
            });
            checkBoxes.add(checkBox);
            add(checkBox, col, row);

            col++;
            if (col == daysInWeek + 1) { // Check against the new number of days
                col = 1;
                row++;
            }

            if ((i + 1) % (daysInWeek * 4) == 0 && i != numBoxes - 1) { // Adjust modulus for spacing
                row++;
            }
        }
    }

    public int getSelectedCount() {
        return selectedCount;
    }

    public GridPane getGridPane() {
        return this;
    }
}

