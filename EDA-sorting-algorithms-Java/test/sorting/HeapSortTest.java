package sorting;

import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {
	
	private HeapSort sorter = new HeapSort();
	
	@Test
	public void testSort_1(){
		int[] actual = {3, 6, 0, -2, 7};
		int[] expected = {-2, 0, 3, 6, 7};
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_2(){
		int[] actual = {1, 3, 5, 7};
		int[] expected = {1, 3, 5, 7};
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_3(){
		int[] actual = {7, 5, 3, 1};
		int[] expected = {1, 3, 5, 7};
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_4(){
		int n = 1000;
		int[] actual = Util.createRandomArray(n);
		sorter.sort(actual);
		Util.assertArrayIsSorted(actual);
	}
	
	@Test
	public void testMaxHeapfy(){
		int[] actual = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] expected = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		sorter.maxHeapfy(actual, actual.length, 1);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testBuildMaxHeap(){
		int[] actual = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		int[] expected = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		sorter.buildMaxHeap(actual);
		Assert.assertArrayEquals(expected, actual);
	}
}
