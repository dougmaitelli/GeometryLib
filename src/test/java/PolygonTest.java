import org.junit.Assert;
import org.junit.Test;

import Geometry.Point;
import Geometry.Polygon;


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
		
		double tt1 = Point.distanceBetweenPoints(new Point(3, 8), new Point(2, 10));
        double tt2 = Point.distanceBetweenPoints(new Point(2, 10), new Point(0, 0));
        double tt3 = Point.distanceBetweenPoints(new Point(0, 0), new Point(1, 2));
        
        double tt4 = poly.distanceBetweenPoints(new Point(3, 8), new Point(1, 2));
        
        Assert.assertEquals(tt4, tt1 + tt2 + tt3, 0);
	}
}
