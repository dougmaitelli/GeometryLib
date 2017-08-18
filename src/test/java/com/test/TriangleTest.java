package com.test;
import org.junit.Assert;
import org.junit.Test;

import geometry.Point;
import geometry.Triangle;


public class TriangleTest {

    @Test
    public void testArea() {
        Triangle t = new Triangle(new Point(0, 0), new Point(1, 2), new Point(3, 8));

        Assert.assertEquals(1, t.getArea(), 0);
    }
}
