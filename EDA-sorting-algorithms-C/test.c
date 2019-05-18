#include <stdio.h>
#include "algorithms.h"

void printArray(int *a, int n){
  for(int i = 0; i < n; i++)
    printf("%d ", a[i]);
  printf("\n");
}

int main(void){
  printf("InsertionSort\n");
  int v1[] = {3, 0, -1, 7, 2};
  insertionSort(v1, 5);
  printArray(v1, 5);
  
  printf("MergeSort\n");
  int v2[] = {9, 10, -1, 5, 3};
  mergeSort(v2, 5);
  printArray(v2, 5);
  
  printf("QuickSort\n");
  int v3[] = {0, 3, 0, -6, 1};
  quickSort(v3, 5);
  printArray(v3, 5);
}