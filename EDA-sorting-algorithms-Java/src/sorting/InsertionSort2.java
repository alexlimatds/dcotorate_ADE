package sorting;

/**
 * This implementation is able to sort subarrays. It was 
 * designed to be used by hybrid implementations of 
 * QuickSort and MergeSort.
 */
public class InsertionSort2{
	
	/**
	 * 
	 * @param A array to be sorted.
	 * @param p start index of the considered subarray (inclusive).
	 * @param q end index of the considered subarray (inclusive).
	 */
	void sort(int[] A, int p, int q){
		if(p > q)
			throw new IllegalArgumentException("p > q");
		for (int j = p + 1; j <= q; j++){
			int key = A[j];
			int i = j - 1;
			while (i >= p && A[i] > key){
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;
		}
	}
}
