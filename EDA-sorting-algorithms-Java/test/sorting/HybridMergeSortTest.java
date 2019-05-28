package sorting;

import org.junit.Assert;
import org.junit.Test;

public class HybridMergeSortTest {
	
	private HybridMergeSort sorter = new HybridMergeSort();
	
	@Test
	public void testSort_1(){
		int[] actual = {3, 6, 0, -2, 7};
		int[] expected = {-2, 0, 3, 6, 7};
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_2(){
		//checks sorting on complete already sorted array
		int[] actual = {1, 3, 5, 7};
		int[] expected = {1, 3, 5, 7};
		sorter.sort(actual);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testSort_3(){
		int n = 1000;
		int[] actual = Util.createRandomArray(n);
		sorter.sort(actual);
		Util.assertArrayIsSorted(actual);
	}
}
