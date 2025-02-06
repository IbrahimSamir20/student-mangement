import javafx.scene.VBox;
import javafx.text.Text;
public class CustomPopUpLog {

    String title;
    String message;
    private VBox container;
    public CustomPopUpLog(String title,String message){
        this.title=title;
        this.message=message;
    }

    public VBox getContainer() {
        VBox n=new VBox;
        Text newtext =new Text();
        newtext.setText(title);

        Text newtext2 =new Text();
        newtext2.setText(message);
    container.getChildren.addAll(newtext.newtext2);


        return container;
    }

}
