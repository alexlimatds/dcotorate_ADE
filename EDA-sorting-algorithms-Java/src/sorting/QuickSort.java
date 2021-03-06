package sorting;

public class QuickSort implements Sorter{
	
	public void sort(int[] A){
		quicksort(A, 0, A.length -1);
	}
	
	void quicksort(int[] A, int p, int r){
		if(p < r){
			int q = partition(A, p, r);
			quicksort(A, p, q - 1);
			quicksort(A, q + 1, r);
		}
	}
	
	int partition(int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		for(int j = p; j < r; j++)
			if(A[j] <= x){
				i = i + 1;
				swap(A, i, j);
			}
		swap(A, i + 1, r);
		
		return i + 1;
	}
	
	private void swap(int[] v, int i, int j){
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}
}
