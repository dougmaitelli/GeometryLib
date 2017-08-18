package com.test;
import org.junit.Assert;
import org.junit.Test;

import geometry.Point;
import geometry.Polyline;


public class PolylineTest {

    public Polyline getTestPolyline() {
        Polyline polyline = new Polyline();
        polyline.add(new Point(2, 2));
        polyline.add(new Point(4, 4));
        polyline.add(new Point(2, 6));
        polyline.add(new Point(0, 4));

        return polyline;
    }

    @Test
    public void testDistanceBetweenPointsStartEnd() {
        Polyline polyline = getTestPolyline();

        Assert.assertEquals(8.4852, polyline.distanceBetweenPoints(polyline.getPoint(0), polyline.getPoint(3)), 0.0001);
    }

    @Test
    public void testDistanceBetweenPointsEndStart() {
        Polyline polyline = getTestPolyline();

        Assert.assertEquals(8.4852, polyline.distanceBetweenPoints(polyline.getPoint(3), polyline.getPoint(0)), 0.0001);
    }

    @Test
    public void testDistanceBetweenPointsMidEnd() {
        Polyline polyline = getTestPolyline();

        Assert.assertEquals(5.6568, polyline.distanceBetweenPoints(polyline.getPoint(1), polyline.getPoint(3)), 0.0001);
    }

    @Test
    public void testDistanceBetweenPointsMidMid() {
        Polyline polyline = getTestPolyline();

        Assert.assertEquals(2.8284, polyline.distanceBetweenPoints(polyline.getPoint(1), polyline.getPoint(2)), 0.0001);
    }

}
