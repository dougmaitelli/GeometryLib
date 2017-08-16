import org.junit.Assert;
import org.junit.Test;

import Geometry.Circle;
import Geometry.Line;
import Geometry.LineSegment;
import Geometry.Point;


public class CircleTest {
	
	public Circle getTestCircle() {
		return new Circle(new Point(3, 5), 3);
	}

	@Test
	public void testCircleArea() {
		Circle circle = getTestCircle();
		
		Assert.assertEquals(28.2743, circle.getArea(), 0.0001);
	}
	
	@Test
	public void testCirclePerimeter() {
		Circle circle = getTestCircle();
		
		Assert.assertEquals(18.8495, circle.getPerimeter(), 0.0001);
	}
	
	@Test
	public void testLinePositionInside() {
		Circle circle = getTestCircle();
		
		Line s = new Line(1, 0);
		
		Assert.assertTrue(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineOutside(s));
		Assert.assertFalse(circle.isLineBelong(s));
	}
	
	@Test
	public void testLinePositionOutside() {
		Circle circle = getTestCircle();
		
		Line s = new Line(1, -10);
		
		Assert.assertTrue(circle.isLineOutside(s));
		Assert.assertFalse(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineBelong(s));
	}
	
	@Test
	public void testLinePositionBelong() {
		Circle circle = getTestCircle();
		
		Line s = new Line(0, 2);
		
		Assert.assertTrue(circle.isLineBelong(s));
		Assert.assertFalse(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineOutside(s));
	}
	
	@Test
	public void testLineSegmentPositionInside() {
		Circle circle = getTestCircle();
		
		LineSegment s = new LineSegment(new Point(0, 4), new Point(6, 4));
		
		Assert.assertTrue(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineOutside(s));
		Assert.assertFalse(circle.isLineBelong(s));
	}
	
	@Test
	public void testLineSegmentPositionOutside() {
		Circle circle = getTestCircle();
		
		LineSegment s = new LineSegment(new Point(6, 2), new Point(10, 2));
		
		Assert.assertTrue(circle.isLineOutside(s));
		Assert.assertFalse(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineBelong(s));
	}
	
	@Test
	public void testLineSegmentPositionBelong() {
		Circle circle = getTestCircle();
		
		LineSegment s = new LineSegment(new Point(0, 2), new Point(6, 2));
		
		Assert.assertTrue(circle.isLineBelong(s));
		Assert.assertFalse(circle.isLineInside(s));
		Assert.assertFalse(circle.isLineOutside(s));
	}
	
	@Test
	public void testPointPositionInside() {
		Circle circle = getTestCircle();
		
		Point p = new Point(2, 4);
		
		Assert.assertTrue(circle.isPointInside(p));
		Assert.assertFalse(circle.isPointOutside(p));
		Assert.assertFalse(circle.isPointBelong(p));
	}
	
	@Test
	public void testPointPositionOutside() {
		Circle circle = getTestCircle();
		
		Point p = new Point(2, 8);
		
		Assert.assertTrue(circle.isPointOutside(p));
		Assert.assertFalse(circle.isPointInside(p));
		Assert.assertFalse(circle.isPointBelong(p));
	}
	
	@Test
	public void testPointPositionBelong() {
		Circle circle = getTestCircle();
		
		Point p = new Point(3, 2);
		
		Assert.assertTrue(circle.isPointBelong(p));
		Assert.assertFalse(circle.isPointInside(p));
		Assert.assertFalse(circle.isPointOutside(p));
	}
	
}
