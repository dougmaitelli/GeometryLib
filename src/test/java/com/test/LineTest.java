package com.test;
import org.junit.Assert;
import org.junit.Test;

import geometry.Line;
import geometry.Point;


public class LineTest {

    @Test
    public void testLineAngle() {
        Line l1 = new Line(new Point(1, 3), new Point(3, 4));
        Assert.assertEquals(45, (double) l1.getAngle(), 0);
    }
}
