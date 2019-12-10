package files.models.geometry;

public class Vector {
    private double x, y, z;

    public Vector(double x, double y){
        this(x,y,0);
    }

    public Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
