package com.test;

import org.junit.Assert;
import org.junit.Test;

import geometry.Point;
import geometry.Polygon;


public class PolygonTest {

    public Polygon getTestPolygon() {
        Polygon poly = new Polygon();

        poly.add(new Point(0, 0));
        poly.add(new Point(1, 2));
        poly.add(new Point(3, 8));
        poly.add(new Point(2, 10));

        return poly;
    }

    @Test
    public void testPolygonArea() {
        Polygon poly = getTestPolygon();

        Assert.assertEquals(8, poly.getArea(), 0);
    }

    @Test
    public void testPerimeter() {
        Polygon poly = getTestPolygon();

        Assert.assertEquals(20.9947, poly.getTotalLength(), 0.0001);
    }

    @Test
    public void testDistanceBetweenPoints() {
        Polygon poly = getTestPolygon();

        double tt = poly.distanceBetweenPoints(poly.getPoint(2), poly.getPoint(1));

        Assert.assertEquals(6.3245, tt, 0.0001);
    }

    @Test
    public void testPointInside() {
        Polygon poly = getTestPolygon();

        Point p = new Point(2, 8);

        Assert.assertTrue(poly.isPointInside(p));
        Assert.assertFalse(poly.isPointOutside(p));
        Assert.assertFalse(poly.isPointBelong(p));
    }

    @Test
    public void testPointOutside() {
        Polygon poly = getTestPolygon();

        Point p = new Point(4, 6);

        Assert.assertTrue(poly.isPointOutside(p));
        Assert.assertFalse(poly.isPointInside(p));
        Assert.assertFalse(poly.isPointBelong(p));
    }

    @Test
    public void testPointBelong() {
        Polygon poly = getTestPolygon();

        Point p = new Point(0.5, 1);

        Assert.assertTrue(poly.isPointBelong(p));
        Assert.assertFalse(poly.isPointInside(p));
        Assert.assertFalse(poly.isPointOutside(p));
    }
}
