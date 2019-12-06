package files.models;

import files.interfaces.Geometry;
import files.models.geometry.Line2D;
import files.models.geometry.Point;
import javafx.scene.canvas.GraphicsContext;

public abstract class Shape implements Geometry {
    public abstract void draw(GraphicsContext graphicsContext);
    public abstract Line2D[] getLines();
    public abstract Point[] getPoints();
}
