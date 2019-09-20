package Files.Views;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MyCanvas {

    public MyCanvas(){
        Canvas canvas = new Canvas();
        canvas.setHeight(300);
        canvas.setWidth(300);
        Rectangle rectangle = new Rectangle(100, 100, 100, 100);
        Text text = new Text();
        text.setText("hi");
        canvas.getGraphicsContext2D();
    }
}
