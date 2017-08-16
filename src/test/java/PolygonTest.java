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
        
        double tt = poly.distanceBetweenPoints(new Point(3, 8), new Point(1, 2));
        
        Assert.assertEquals(tt1 + tt2 + tt3, tt, 0.0001);
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
