package files.interfaces;

import javafx.scene.canvas.GraphicsContext;

public interface Environment extends Geometry {
    void draw(GraphicsContext graphicsContext);
}
