import org.junit.Assert;
import org.junit.Test;

import Geometry.Ellipse;
import Geometry.Line;
import Geometry.Point;
import Geometry.Position;


public class EllipseTest {
	
	public Ellipse getTestEllipse() {
		return new Ellipse(new Point(3, 5), 3, 5);
	}

	@Test
	public void testEllipseArea() {
		Ellipse ellipse = getTestEllipse();
		
		Assert.assertEquals(47.1238, ellipse.getArea(), 0.0001);
	}
	
	@Test
	public void testLinePosition() {
		Ellipse ellipse = getTestEllipse();
		
		Line s = new Line(0.5, 0);
		
		Assert.assertEquals(ellipse.getLinePosition(s), Position.INSIDE);
	}
}
