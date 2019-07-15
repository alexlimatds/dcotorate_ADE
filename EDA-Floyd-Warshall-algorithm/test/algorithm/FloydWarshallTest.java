package algorithm;

import org.junit.Test;

public class FloydWarshallTest {

	@Test
	public void testSearch(){
		double[][] W = new double[][]{
			{0, 3, 8, Double.POSITIVE_INFINITY, -4}, 
			{Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 1, 7}, 
			{Double.POSITIVE_INFINITY, 4, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, 
			{2, Double.POSITIVE_INFINITY, -5, 0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 6, 0}
		};
		
		FloydWarshall fd = new FloydWarshall();
		double[][] D = fd.search(W);
		
		double[][] expected = new double[][]{
			{0, 1, -3, 2, -4}, 
			{3, 0, -4, 1, -1}, 
			{7, 4, 0, 5, 3}, 
			{2, -1, -5, 0, -2}, 
			{8, 5, 1, 6, 0}
		};
		
		Util.assertEquals(expected, D, 0.00001);
	}
}
