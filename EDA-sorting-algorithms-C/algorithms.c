#include <math.h>
#include <limits.h>
#include "algorithms.h"

//INSERTION SORT
void insertionSort(int *A, int n){
  for (int j = 1; j < n; j++){
    int key = A[j];
    int i = j - 1;
    while (i >= 0 && A[i] > key){
      A[i + 1] = A[i];
      i = i - 1;
    }
    A[i + 1] = key;
  }
}

//MERGE SORT
void mergeSort(int *A, int n){
  _mergeSort(A, 0, n - 1);
}

void _mergeSort(int *A, int p, int r){
  if(p < r){
    int q = (int)floor((p + r) / 2.0);
    _mergeSort(A, p, q);
    _mergeSort(A, q + 1, r);
    _merge(A, p, q, r);
  }
}
	
void _merge(int *A, int p, int q, int r){
  int n1 = q - p + 1;
  int n2 = r - q;
  int L[n1 + 1];
  int R[n2 + 1];
  for(int i = 0; i < n1; i++)
    L[i] = A[p + i];
  for(int j = 0; j < n2; j++)
    R[j] = A[q + j + 1];
  L[n1] = INT_MAX;
  R[n2] = INT_MAX;
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

//QUICK SORT
void quickSort(int *A, int n){
  _quicksort(A, 0, n -1);
}

void _quicksort(int *A, int p, int r){
  if(p < r){
    int q = _partition(A, p, r);
    _quicksort(A, p, q - 1);
    _quicksort(A, q + 1, r);
  }
}

int _partition(int *A, int p, int r){
  int x = A[r];
  int i = p - 1;
  for(int j = p; j < r; j++)
    if(A[j] <= x){
      i = i + 1;
      _swap(A, i, j);
    }
  _swap(A, i + 1, r);

  return i + 1;
}

void _swap(int *v, int i, int j){
  int temp = v[i];
  v[i] = v[j];
  v[j] = temp;
}