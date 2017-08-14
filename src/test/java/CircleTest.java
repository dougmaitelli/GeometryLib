import org.junit.Assert;
import org.junit.Test;

import Geometry.Circle;
import Geometry.Point;


public class CircleTest {
	
	public Circle getTestCircle() {
		return new Circle(new Point(3, 5), 3);
	}

	@Test
	public void testCircleArea() {
		Circle circle = getTestCircle();
		
		Assert.assertEquals(circle.getArea(), 28.2743, 0.0001);
	}
	
	@Test
	public void testCirclePerimeter() {
		Circle circle = getTestCircle();
		
		Assert.assertEquals(circle.getPerimeter(), 18.8495, 0.0001);
	}
}
