import org.junit.Assert;
import org.junit.Test;

import Geometry.Matrix;


public class MatrixTest {
	
	@Test
	public void testDeterminant() {
		Matrix matrix = new Matrix(new Integer[][]{
                {2, 2, 1},
                {-3, 5, 14}
            });

		Assert.assertEquals(matrix.getDeterminant(), 0, 0);
	}
}
