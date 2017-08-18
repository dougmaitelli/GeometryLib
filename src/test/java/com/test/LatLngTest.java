package com.test;
import org.junit.Assert;
import org.junit.Test;

import geography.LatLng;
import geometry.Point;


public class LatLngTest {
	
	public void testDistance() {
		Double d = LatLng.distanceBetweenPoints(new LatLng(-29.687166, -51.127223), new LatLng(-29.68773, -51.127062));
		
		Assert.assertEquals(0, d, 0);
	}

	@Test
	public void testToPoint() {
		LatLng ll = new LatLng(-29.687166, -51.127223);
        Point p1 = ll.toPoint();
        LatLng ll2 = LatLng.fromPoint(p1);
        
        Assert.assertEquals(ll.getLatitude(), ll2.getLatitude(), 0.000001);
        Assert.assertEquals(ll.getLongitude(), ll2.getLongitude(), 0.000001);
	}
}
