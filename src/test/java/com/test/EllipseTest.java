package com.test;

import org.junit.Assert;
import org.junit.Test;

import geometry.Ellipse;
import geometry.Line;
import geometry.LineSegment;
import geometry.Point;


public class EllipseTest {

    public Ellipse getTestEllipse() {
        return new Ellipse(new Point(3, 5), 3, 5);
    }

    @Test
    public void testEllipseArea() {
        Ellipse ellipse = getTestEllipse();

        Assert.assertEquals(47.1238, ellipse.getArea(), 0.0001);
    }


    @Test
    public void testLinePositionInside() {
        Ellipse ellipse = getTestEllipse();

        Line s = new Line(1, 0);

        Assert.assertTrue(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineOutside(s));
        Assert.assertFalse(ellipse.isLineBelong(s));
    }

    @Test
    public void testLinePositionOutside() {
        Ellipse ellipse = getTestEllipse();

        Line s = new Line(1, -10);

        Assert.assertTrue(ellipse.isLineOutside(s));
        Assert.assertFalse(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineBelong(s));
    }

    @Test
    public void testLinePositionBelong() {
        Ellipse ellipse = getTestEllipse();

        Line s = new Line(0, 2);

        Assert.assertTrue(ellipse.isLineBelong(s));
        Assert.assertFalse(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineOutside(s));
    }

    @Test
    public void testLineSegmentPositionInside() {
        Ellipse ellipse = getTestEllipse();

        LineSegment s = new LineSegment(new Point(0, 4), new Point(6, 4));

        Assert.assertTrue(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineOutside(s));
        Assert.assertFalse(ellipse.isLineBelong(s));
    }

    @Test
    public void testLineSegmentPositionOutside() {
        Ellipse ellipse = getTestEllipse();

        LineSegment s = new LineSegment(new Point(6, 2), new Point(10, 2));

        Assert.assertTrue(ellipse.isLineOutside(s));
        Assert.assertFalse(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineBelong(s));
    }

    @Test
    public void testLineSegmentPositionBelong() {
        Ellipse ellipse = getTestEllipse();

        LineSegment s = new LineSegment(new Point(0, 10), new Point(6, 10));

        Assert.assertTrue(ellipse.isLineBelong(s));
        Assert.assertFalse(ellipse.isLineInside(s));
        Assert.assertFalse(ellipse.isLineOutside(s));
    }

    @Test
    public void testPointPositionInside() {
        Ellipse ellipse = getTestEllipse();

        Point p = new Point(2, 4);

        Assert.assertTrue(ellipse.isPointInside(p));
        Assert.assertFalse(ellipse.isPointOutside(p));
        Assert.assertFalse(ellipse.isPointBelong(p));
    }

    @Test
    public void testPointPositionOutside() {
        Ellipse ellipse = getTestEllipse();

        Point p = new Point(2, 10);

        Assert.assertTrue(ellipse.isPointOutside(p));
        Assert.assertFalse(ellipse.isPointInside(p));
        Assert.assertFalse(ellipse.isPointBelong(p));
    }

    @Test
    public void testPointPositionBelong() {
        Ellipse ellipse = getTestEllipse();

        Point p = new Point(6, 5);

        Assert.assertTrue(ellipse.isPointBelong(p));
        Assert.assertFalse(ellipse.isPointInside(p));
        Assert.assertFalse(ellipse.isPointOutside(p));
    }
}
