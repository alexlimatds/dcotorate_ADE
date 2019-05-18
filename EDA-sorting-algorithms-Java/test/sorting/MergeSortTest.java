package sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {
	
	private MergeSort sorter = new MergeSort();
	
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
	public void testMerge_1(){
		int[] A = {0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 5, 7, 1, 2, 3, 6, 30, 30};
		int p = 8;
		int q = 11;
		int r = 15;
		int[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 30, 30};
		sorter.merge(A, p, q, r);
		Assert.assertArrayEquals(expected, A);
	}
}
