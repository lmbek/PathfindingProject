package files.interfaces;

import files.models.geometry.Line2D;
import files.models.geometry.Point;

public interface Geometry {
    boolean isColliding(Point point);
}