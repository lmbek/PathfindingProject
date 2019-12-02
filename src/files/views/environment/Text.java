package files.views.environment;

import files.interfaces.Environment;
import files.models.shapes.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/*************
 **************  MADE BY LARS MORTEN BEK | Miniproject | Mastermind
 *************/


public class Text implements Environment {

    public String text;
    public int x,y,size;
    public Color color;
    public FontWeight weight;
    public String fontName = "Verdana";


    public Text (String text, int x, int y, int size, Color color) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    public Text (String text, int x, int y, int size, Color color, FontWeight weight, String fontName) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.weight = weight;
        this.fontName = fontName;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        if(weight!=null) {
            gc.setFont(Font.font("Verdana", weight, size));
        } else {
            gc.setFont(Font.font(fontName, FontWeight.NORMAL, size));
        }
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText(text, x, y);


    }

    @Override
    public boolean isColliding(Point point) {
        return false;
    }
}