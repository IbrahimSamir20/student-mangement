module org.example.studentadminstator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;


    opens org.example.studentadminstator.components to javafx.graphics;
    opens org.example.studentadminstator.data to javafx.base;
    opens org.example.studentadminstator to javafx.fxml;
    exports org.example.studentadminstator;
}

