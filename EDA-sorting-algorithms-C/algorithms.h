#ifndef ALGORITHMS_H
#define ALGORITHMS_H

void insertionSort(int *, int);

void _merge(int *, int, int, int);
void _mergeSort(int *, int, int);
void mergeSort(int *, int);

void quickSort(int *, int);
void _quicksort(int *, int, int);
int _partition(int *, int, int);
void _swap(int *, int, int);

void heapSort(int *, int);
void _buildMaxHeap(int *, int);
void _maxHeapfy(int *, int , int);
#endif