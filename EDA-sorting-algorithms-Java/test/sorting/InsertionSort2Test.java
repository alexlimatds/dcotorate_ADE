package sorting;

import org.junit.Assert;
import org.junit.Test;

public class InsertionSort2Test {
	
	private InsertionSort2 sorter = new InsertionSort2();
	
	@Test
	public void testSort_1(){
		//checks sorting on the complete array
		int[] actual = {3, 6, 0, -2, 7};
		int[] expected = {-2, 0, 3, 6, 7};
		sorter.sort(actual, 0, actual.length - 1);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_2(){
		//checks sorting on complete already sorted array
		int[] actual = {1, 3, 5, 7};
		int[] expected = {1, 3, 5, 7};
		sorter.sort(actual, 0, actual.length - 1);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_3(){
		//checks sorting on subarray (left edge)
		int[] actual = {0, 3, -2, 10, 11, 0, 2, 8};
		int[] expected = {-2, 0, 3, 10, 11, 0, 2, 8};
		sorter.sort(actual, 0, 2);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_4(){
		//checks sorting on subarray (right edge)
		int[] actual = {0, 3, -2, 10, 11, 0, 2, 8};
		int[] expected = {0, 3, -2, 10, 0, 2, 8, 11};
		sorter.sort(actual, 4, 7);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_5(){
		//checks sorting on subarray (middle)
		int[] actual = {0, 3, -2, 10, 11, 0, 2, 8};
		int[] expected = {0, -2, 3, 10, 11, 0, 2, 8};
		sorter.sort(actual, 1, 4);
		Assert.assertArrayEquals(expected, actual);
	}
}
