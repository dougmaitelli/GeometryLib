import org.junit.Assert;
import org.junit.Test;

import geometry.Line;
import geometry.LineSegment;
import geometry.Point;
import geometry.Rectangle;


public class RectangleTest {
	
	public Rectangle getTestRectangle() {
		return new Rectangle(new Point(3, 5), new Point(8, 10));
	}
	
	@Test
	public void testCenter() {
		Rectangle rectangle = getTestRectangle();
		
		Assert.assertEquals(new Point(5.5, 7.5), rectangle.getCenter());
	}

	@Test
	public void testArea() {
		Rectangle rectangle = getTestRectangle();
		
		Assert.assertEquals(25, rectangle.getArea(), 0.0001);
	}
	
	@Test
	public void testLinePositionInside() {
		Rectangle rectangle = getTestRectangle();
		
		Line s = new Line(1, 1);
		
		Assert.assertTrue(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineOutside(s));
		Assert.assertFalse(rectangle.isLineBelong(s));
	}
	
	@Test
	public void testLinePositionOutside() {
		Rectangle rectangle = getTestRectangle();
		
		Line s = new Line(1, -10);
		
		Assert.assertTrue(rectangle.isLineOutside(s));
		Assert.assertFalse(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineBelong(s));
	}
	
	@Test
	public void testLinePositionBelong() {
		Rectangle rectangle = getTestRectangle();
		
		Line s = new Line(1, -3);
		
		Assert.assertTrue(rectangle.isLineBelong(s));
		Assert.assertFalse(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineOutside(s));
	}
	
	@Test
	public void testLineSegmentPositionInside() {
		Rectangle rectangle = getTestRectangle();
		
		LineSegment s = new LineSegment(new Point(0, 0), new Point(8, 10));
		
		Assert.assertTrue(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineOutside(s));
		Assert.assertFalse(rectangle.isLineBelong(s));
	}
	
	@Test
	public void testLineSegmentPositionOutside() {
		Rectangle rectangle = getTestRectangle();
		
		LineSegment s = new LineSegment(new Point(3, 0), new Point(5, 4));
		
		Assert.assertTrue(rectangle.isLineOutside(s));
		Assert.assertFalse(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineBelong(s));
	}
	
	@Test
	public void testLineSegmentPositionBelong() {
		Rectangle rectangle = getTestRectangle();
		
		LineSegment s = new LineSegment(new Point(3, 0), new Point(10, 7));
		
		Assert.assertTrue(rectangle.isLineBelong(s));
		Assert.assertFalse(rectangle.isLineInside(s));
		Assert.assertFalse(rectangle.isLineOutside(s));
	}
	
	@Test
	public void testPointPositionInside() {
		Rectangle rectangle = getTestRectangle();
		
		Point p = new Point(4, 6);
		
		Assert.assertTrue(rectangle.isPointInside(p));
		Assert.assertFalse(rectangle.isPointOutside(p));
		Assert.assertFalse(rectangle.isPointBelong(p));
	}
	
	@Test
	public void testPointPositionOutside() {
		Rectangle rectangle = getTestRectangle();
		
		Point p = new Point(10, 7);
		
		Assert.assertTrue(rectangle.isPointOutside(p));
		Assert.assertFalse(rectangle.isPointInside(p));
		Assert.assertFalse(rectangle.isPointBelong(p));
	}
	
	@Test
	public void testPointPositionBelong() {
		Rectangle rectangle = getTestRectangle();
		
		Point p = new Point(8, 6);
		
		Assert.assertTrue(rectangle.isPointBelong(p));
		Assert.assertFalse(rectangle.isPointInside(p));
		Assert.assertFalse(rectangle.isPointOutside(p));
	}
}
