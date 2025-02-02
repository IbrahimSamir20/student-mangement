package org.example.studentadminstator.components;

public class CustomButton {
   Button button;

        button.setTextFill(AppStyle.textColor);
        button.setFont(Font.font(AppStyle.font18.getFamily(), FontWeight.BOLD, AppStyle.font18.getSize()));
        button.setPrefWidth(100);
        button.setFill(AppStyle.colorBlack );


      button.setOnMousePressed(e -> button.setScaleX(0.9));
      button.setOnMousePressed(e -> button.setScaleY(0.9));
      button.setOnMouseReleased(e -> button.setScaleX(1.0));
      button.setOnMouseReleased(e -> button.setScaleY(1.0));


}
