package sorting;

public class HybridMergeSort implements Sorter{
	
	private final int threshold = 55;
	private InsertionSort2 insertionSorter = new InsertionSort2();
	
	public void sort(int[] A){
		mergeSort(A, 0, A.length - 1);
	}
	
	void mergeSort(int[] A, int p, int r){
		if(p < r){
			if(r - p + 1 < threshold)
				insertionSorter.sort(A, p, r);
			else{
				int q = Math.floorDiv(p + r, 2);
				mergeSort(A, p, q);
				mergeSort(A, q + 1, r);
				merge(A, p, q, r);
			}
		}
	}
	
	void merge(int[] A, int p, int q, int r){
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for(int i = 0; i < n1; i++)
			L[i] = A[p + i];
		for(int j = 0; j < n2; j++)
			R[j] = A[q + j + 1];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for(int k = p; k <= r; k++)
			if(L[i] <= R[j]){
				A[k] = L[i];
				i = i + 1;
			}
			else{
				A[k] = R[j];
				j = j + 1;
			}
	}
}
