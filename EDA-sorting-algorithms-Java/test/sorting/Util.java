package sorting;

import java.util.Random;

import org.junit.Assert;

public class Util {
	
	public static int[] createRandomArray(int n){
		Random rand = new Random();
		int[] A = new int[n];
		for(int i = 0; i < n; i++)
			A[i] = rand.nextInt(n / 10);
		
		return A;
	}
	
	public static void assertArrayIsSorted(int[] A){
		int n = A.length;
		for(int i = 0; i < n - 1; i++)
			if(A[i] > A[i + 1])
				Assert.fail(String.format("%dth item (%d) greater than the following element (%d).", i, A[i], A[i+1]));
	}
}
