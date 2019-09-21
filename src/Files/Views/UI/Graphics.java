package Files.Views.UI;

import Files.Views.Elements.Canvas;
import Files.Views.Elements.Drawables.Rectangle;
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
