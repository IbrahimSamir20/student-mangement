package org.example.studentadminstator.components;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Navbar extends HBox {
        
        private String username ;
        Text text ;

        public Navbar(String username){
              this.username=username;
              this.text=new Text("Hi, 👋");  
        }

        VBox vbox = new VBox();
        vbox.getChildren()




}
