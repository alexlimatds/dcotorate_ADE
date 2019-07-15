package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class FloydWarshallTest {

	@Test
	public void testSearch_1(){
		double[][] W = new double[][]{
			{0, 3, 8, Double.POSITIVE_INFINITY, -4}, 
			{Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 1, 7}, 
			{Double.POSITIVE_INFINITY, 4, 0, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY}, 
			{2, Double.POSITIVE_INFINITY, -5, 0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 6, 0}
		};
		
		FloydWarshall fw = new FloydWarshall();
		fw.search(W);
		
		double[][] expectedW = new double[][]{
			{0, 1, -3, 2, -4}, 
			{3, 0, -4, 1, -1}, 
			{7, 4, 0, 5, 3}, 
			{2, -1, -5, 0, -2}, 
			{8, 5, 1, 6, 0}
		};
		Integer[][] expectedP = new Integer[][]{
			{null, 2, 3, 4, 0}, 
			{3, null, 3, 1, 0}, 
			{3, 2, null, 1, 0}, 
			{3, 2, 3, null, 0}, 
			{3, 2, 3, 4, null}
		};
		
		Util.assertEquals(expectedW, fw.D, 0.00001);
		Util.assertEquals(expectedP, fw.P);
		Assert.assertFalse(fw.hasNegativeCycles());
	}
	
	@Test
	public void testSearch_2(){
		double[][] W = new double[][]{
			{0, 5, 4, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, 0, Double.POSITIVE_INFINITY, 3}, 
			{Double.POSITIVE_INFINITY, -6, 0, Double.POSITIVE_INFINITY}, 
			{Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 2, 0} 
		};
		
		FloydWarshall fw = new FloydWarshall();
		fw.search(W);
		
		Assert.assertTrue(fw.hasNegativeCycles());
	}
}
