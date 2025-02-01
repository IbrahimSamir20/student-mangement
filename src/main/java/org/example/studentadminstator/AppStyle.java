package org.example.studentadminstator;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.geometry.Insets;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.image.Image;
import javafx.scene.text.FontWeight;

public class AppStyle{
    public static final Font font18 = new Font("Arial", 18);
    public static final Font font18Bold = Font.font("Arial", FontWeight.BOLD, 18); // Bold 18pt font
    public static final Font font14 = Font.font("Arial", 14); // Regular 14pt font
    public static final Font font14Bold = Font.font("Arial", FontWeight.BOLD, 14); // Bold 14pt font

    public static final Font font24 = new Font("Arial", 24);
    public static final Font font32 = new Font("Arial", 32);
    
    public static final Color colorBlack = Color.BLACK;
    public static final Color textColor = Color.WHITE;
    public static final Color errorColor = Color.RED;
    public static final FontWeight textBold = FontWeight.BOLD;
    
    public static final Border border = new Border(new BorderStroke(colorBlack, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    public static final Background background = new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY));
    public static final BackgroundImage backgroundImage = new BackgroundImage(
        new Image("file:src/main/resources/org/example/studentadminstator/images/background.jpg"),
        BackgroundRepeat.NO_REPEAT,
        BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER,
        BackgroundSize.DEFAULT
    );
    
}
