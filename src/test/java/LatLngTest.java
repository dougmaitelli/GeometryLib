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
        Assert.assertEquals(ll, ll2);
	}
}
