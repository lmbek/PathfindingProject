package files.models;

import javafx.scene.shape.TriangleMesh;

import java.util.ArrayList;

public class Environment {
    ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

    public void addRectangle(){
        rectangles.add();
    }
}



class Rectangle {
    Vector position;
    Vector size;

    Rectangle (double x, double y, double width, double height){
        this.position = new Vector(x,y);
        this.size = new Vector(width, height);
    }
}

class Triangle {
    Line a, b, c;

    Triangle (Line a, Line b, Line c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    boolean isColliding (){
        if(){

        }
    }
}

class Line {
    Vector p1, p2;

    Line (Vector p1, Vector p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    boolean isLeftOfLine(Vector point){
        if(0 < (point.getX()-p1.getX())*(p2.getY()-p1.getY())-(point.getY()-p1.getY())*(p2.getX()-p1.getX()) ){
            return true;
        } else return false;
    }

    boolean isRightOfLine(Vector point){
        if(0 > (point.getX()-p1.getX())*(p2.getY()-p1.getY())-(point.getY()-p1.getY())*(p2.getX()-p1.getX()) ){
            return true;
        } else return false;
    }

    boolean isExactlyOnLine(Vector point){
        if(0 == (point.getX()-p1.getX())*(p2.getY()-p1.getY())-(point.getY()-p1.getY())*(p2.getX()-p1.getX()) ) {
            return true;
        } else return false;
    }

}

class Vector {
    private double x, y, z;

    Vector(double x){
        this(x,0,0);
    }

    Vector(double x, double y){
        this(x,y,0);
    }

    Vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.y = z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}