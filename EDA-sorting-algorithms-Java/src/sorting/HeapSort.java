package sorting;

public class HeapSort implements Sorter {

	@Override
	public void sort(int[] A) {
		buildMaxHeap(A);
		int heapSize = A.length;
		for(int i = A.length - 1; i >= 1; i--){
			swap(A, 0, i);
			heapSize--;
			maxHeapfy(A, heapSize, 0);
		}
	}
	
	void buildMaxHeap(int[] A){
		for(int i = Math.floorDiv(A.length, 2); i >= 0; i--)
			maxHeapfy(A, A.length, i);
	}
	
	void maxHeapfy(int[] A, int heapSize, int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if(l < heapSize && A[l] > A[i])
			largest = l;
		else
			largest = i;
		if(r < heapSize && A[r] > A[largest])
			largest = r;
		if(largest != i){
			swap(A, i, largest);
			maxHeapfy(A, heapSize, largest);
		}
	}
	
	private int left(int i){
		return 2 * (i + 1) - 1;
	}
	
	private int right(int i){
		return 2 * (i + 1);
	}
	
	private void swap(int[] v, int i, int j){
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}
}
