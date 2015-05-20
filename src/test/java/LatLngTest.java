import org.junit.Assert;
import org.junit.Test;

import Geography.LatLng;
import Geometry.Point;


public class LatLngTest {

	@Test
	public void testToPoint() {
		LatLng ll = new LatLng(-29.687166, -51.127223);
        Point p1 = ll.toPoint();
        LatLng ll2 = LatLng.fromPoint(p1);
        
        Assert.assertEquals((double) ll.getLatitude(), (double) ll2.getLatitude(), 0.000001);
        Assert.assertEquals((double) ll.getLongitude(), (double) ll2.getLongitude(), 0.000001);
	}
}
