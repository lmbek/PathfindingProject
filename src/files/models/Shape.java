package files.models;

import files.interfaces.Geometry;
import javafx.scene.canvas.GraphicsContext;

public abstract class Shape implements Geometry {
    public abstract void draw(GraphicsContext graphicsContext);
}
