import org.junit.Assert;
import org.junit.Test;

import Geometry.Circle;
import Geometry.Line;
import Geometry.Point;
import Geometry.Position;


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
	public void testLinePosition() {
		Circle circle = getTestCircle();
		
		Line s = new Line(0.5, 0);
		
		Assert.assertEquals(Position.INSIDE, circle.getLinePosition(s));
	}
}
