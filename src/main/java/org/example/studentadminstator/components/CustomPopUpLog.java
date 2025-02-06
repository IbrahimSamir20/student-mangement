package org.example.studentadminstator.components;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CustomPopUpLog {
    String title;
    String message;
    private VBox container;

    public CustomPopUpLog(String title,String message){
        this.title=title;
        this.message=message;
    }

    public  VBox getContainer() {
        VBox n = new VBox ();
        Text newtext = new Text(title);
        Text newtext2 = new Text(message);
        newtext2.setText(message);
        container.getChildren().addAll(newtext,newtext2);

        return container;
    }

}
