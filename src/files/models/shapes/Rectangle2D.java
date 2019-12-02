package files.models.shapes;
import files.interfaces.Geometry;
import files.models.Shape;
import javafx.scene.canvas.GraphicsContext;

public class Rectangle2D extends Shape {
    private Point A, B, C, D;
    private Line2D AB, BD, CD, AC;
    private Point position;
    private Point size;
    private Triangle2D firstHalf;
    private Triangle2D secondHalf;

    public Rectangle2D(double x, double y, double width, double height) {
        A = new Point(x,y);
        B = new Point(x+width,y);
        C = new Point(x,y+height);
        D = new Point(x+width,y+height);
        AB = new Line2D(A,B);
        BD = new Line2D(B,D);
        CD = new Line2D(C,D);
        AC = new Line2D(A,C);
        firstHalf = new Triangle2D(A, B, C);
        secondHalf = new Triangle2D(D, B, C);

        this.position = A;
        this.size = new Point(width, height);
    }

    public boolean isColliding(Point obj) {
        return firstHalf.isColliding(obj) || secondHalf.isColliding(obj);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }
}
