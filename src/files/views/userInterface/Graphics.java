package files.views.userInterface;

import files.views.elements.Canvas;
import files.views.elements.drawables.Rectangle;
import javafx.scene.text.Text;

public class Graphics {

    public Graphics(){
        Canvas canvas = new Canvas();
        canvas.setHeight(300);
        canvas.setWidth(300);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        Text text = new Text();
        text.setText("hi");
        //canvas.getGraphicsContext2D();
    }
}
