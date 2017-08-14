import org.junit.Assert;
import org.junit.Test;

import Geometry.Line;
import Geometry.Point;
import Geometry.Position;
import Geometry.Rectangle;


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
	public void testLinePosition() {
		Rectangle rectangle = getTestRectangle();
		
		Line s = new Line(1, 1);
		
		Assert.assertEquals(Position.INSIDE, rectangle.getLinePosition(s));
	}
}
