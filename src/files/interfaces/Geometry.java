package files.interfaces;

import files.models.shapes.Point;

public interface Geometry {
    boolean isColliding(Point point);
}