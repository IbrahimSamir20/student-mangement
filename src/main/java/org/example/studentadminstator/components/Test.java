package org.example.studentadminstator.components;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Test {
    String username;
    String password;
    private VBox container;
    public Test(String username, String password){
        this.username=username;
        this.password=password;
    }

    public VBox getContainer(){
        Text newText = new Text();
        System.out.println(username);
container.getChildren();
        return container;
    }

    public void print (){
        System.out.println("username is "+ username + "password is " + password);
    }

}
