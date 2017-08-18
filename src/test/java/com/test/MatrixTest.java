package com.test;
import org.junit.Assert;
import org.junit.Test;

import geometry.Matrix;


public class MatrixTest {
	
	public Matrix getTestMatrix() {
		return new Matrix(new Number[][]{
            {2, 2, 1},
            {-3, 5, 14}
        });
	}
	
	public Matrix getTestMatrix2() {
		return new Matrix(new Number[][]{
            {2, 2, 2},
            {2, 2, 2}
        });
	}
	
	@Test
	public void testDeterminant() {
		Matrix matrix = getTestMatrix();

		Assert.assertEquals(0, matrix.getDeterminant(), 0);
	}
	
	@Test
	public void testTranspose() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {2, -3},
            {2, 5},
            {1, 14}
        });

		Assert.assertEquals(result, matrix.transpose());
	}
	
	@Test
	public void testSimetric() {
		Matrix matrix = getTestMatrix();

		Assert.assertFalse(matrix.isSimetric());
	}
	
	@Test
	public void testMultiplyNumber() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {4, 4, 2},
            {-6, 10, 28}
        });

		Assert.assertEquals(result, matrix.multiply(2));
	}
	
	@Test
	public void testMultiplyMatrix() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {4, 4, 2},
            {-6, 10, 28}
        });

		Assert.assertEquals(result, matrix.multiply(getTestMatrix2()));
	}
	
	@Test
	public void testAddNumber() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {4, 4, 3},
            {-1, 7, 16}
        });

		Assert.assertEquals(result, matrix.add(2));
	}
	
	@Test
	public void testAddMatrix() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {4, 4, 3},
            {-1, 7, 16}
        });

		Assert.assertEquals(result, matrix.add(getTestMatrix2()));
	}
	
	@Test
	public void testSubNumber() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {0, 0, -1},
            {-5, 3, 12}
        });

		Assert.assertEquals(result, matrix.sub(2));
	}
	
	@Test
	public void testSubMatrix() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {0, 0, -1},
            {-5, 3, 12}
        });

		Assert.assertEquals(result, matrix.sub(getTestMatrix2()));
	}
	
	@Test
	public void testDivideNumber() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {1, 1, 0.5},
            {-1.5, 2.5, 7}
        });

		Assert.assertEquals(result, matrix.divide(2));
	}
	
	@Test
	public void testDivideMatrix() {
		Matrix matrix = getTestMatrix();
		
		Matrix result = new Matrix(new Number[][]{
            {1, 1, 0.5},
            {-1.5, 2.5, 7}
        });

		Assert.assertEquals(result, matrix.divide(getTestMatrix2()));
	}
}
