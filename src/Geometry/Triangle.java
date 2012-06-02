package Geometry;

import java.util.ArrayList;
import java.util.Collection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DougM
 */
public final class Triangle {

    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.setA(a);
        this.setB(b);
        this.setC(c);
    }

    /**
     * @return the a
     */
    public Point getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Point a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Point getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Point b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public Point getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Point c) {
        this.c = c;
    }

    public Double getArea() {
        return Math.abs(toMatrix().getDeterminant()) / 2;
    }
    
    public Polygon toPolygon() {
        ArrayList<Point> list = new ArrayList<Point>();
        list.add(a);
        list.add(b);
        list.add(c);
        
        return new Polygon(list);
    }

    public Matrix toMatrix() {
        Matrix matrix = new Matrix(new Double[][]{
                    {a.getX(), a.getY()},
                    {b.getX(), b.getY()},
                    {c.getX(), c.getY()}
                });
        
        return matrix;
    }

    public Point getGravityCenter() {
        return new Point((this.getA().getX() + this.getB().getX() + this.getC().getX()) / 3, (this.getA().getY() + this.getB().getY() + this.getC().getY()) / 3);
    }
}
