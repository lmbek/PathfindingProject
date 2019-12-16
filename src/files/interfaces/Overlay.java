package files.interfaces;

import javafx.scene.canvas.GraphicsContext;

public interface Overlay {
    void draw(GraphicsContext graphicsContext);
    void drawEdges(GraphicsContext graphicsContext);
}
