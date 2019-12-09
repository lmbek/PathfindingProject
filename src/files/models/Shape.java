package files.models;

import files.interfaces.Environment;
import files.interfaces.Overlay;
import files.models.geometry.Line2D;
import files.models.geometry.Point;
import javafx.scene.canvas.GraphicsContext;

public abstract class Shape implements Environment, Overlay {
    public abstract void draw(GraphicsContext graphicsContext);
    public abstract Line2D[] getLines();
    public abstract Point[] getPoints();
}
