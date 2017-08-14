import org.junit.Assert;
import org.junit.Test;

import Geometry.Point;
import Geometry.Polyline;


public class PolylineTest {
	
	public Polyline getTestPolyline() {
		Polyline polyline = new Polyline();
		polyline.add(new Point(0, 0));
		polyline.add(new Point(1, 2));
		polyline.add(new Point(3, 8));
		
		return polyline;
	}

	@Test
	public void testDistanceBetweenPoints() {
		Polyline polyline = getTestPolyline();
		
		Assert.assertEquals(polyline.distanceBetweenPoints(polyline.getPoint(0), polyline.getPoint(2)), 8.5606, 0.0001);
	}

}
