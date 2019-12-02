package files.views.environment;

import files.interfaces.Environment;
import files.models.shapes.Point;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*************
 **************  MADE BY LARS MORTEN BEK | Miniproject | Mastermind
 *************/


public class Line implements Environment {
    public int x,y,dx,dy;

    public Line(int x,int y,int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLACK);
        gc.beginPath();
        gc.moveTo(x,y);
        gc.lineTo(dx,dy);
        gc.stroke();

    }


    @Override
    public boolean isColliding(Point point) {
        return false;
    }
}