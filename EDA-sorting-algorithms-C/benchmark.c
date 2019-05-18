#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "algorithms.h"

int* copyArray(int *A, int n){
  int *v = malloc(sizeof (int) * n);
  for(int i = 0; i < n; i++)
    v[i] = A[i];
  
  return v;
}

void runBattery(int *n, int n_size, int *data, int data_size, void (*sortFunction)(int *, int), char *sorterName){
  printf("%s\n", sorterName);
  
  char *fileName[4 + strlen(sorterName)];
  strcpy(fileName, sorterName);
  strcat(fileName, ".txt");
  FILE *file = fopen(fileName, "w");
  fprintf(file, "N;execution number;time in nanosecs\n");
  
  for(int i = 0; i < n_size; i++){
    printf("input of size %d\n", n[i]);
    for(int j = 1; j < 10; j++){
      int *input = copyArray(data, n[i]);
      struct timespec stop, start;
      int clock1 = clock_gettime(CLOCK_REALTIME, &start);
      sortFunction(input, n[i]);
      int clock2 = clock_gettime(CLOCK_REALTIME, &stop);
      if(clock1 != 0 || clock2 != 0)
        printf("WARNING: clock error at %dth execution.", j);
      long time = (stop.tv_sec * 1e9 + stop.tv_nsec) - (start.tv_sec * 1e9 + start.tv_nsec); //time in nanosecs
      fprintf(file, "%d;%d;%ld\n", n[i], j, time);
      free(input);
    }
  }
  
  fclose(file);
}

int main(void){
  //the values in n must be in ascending order
  int n[] = {10, 20, 30, 50, 100, 200, 300, 700, 1000, 5000, 10000, 50000};
  int n_size = 12; //ATTENTION: sync this value if you change the size of the n array
  
  int maxN = n[n_size - 1];
  int data[maxN];
  for(int i = 0; i < maxN; i++){
    data[i] = rand() % (maxN / 10);
  }
  
  runBattery(n, n_size, data, maxN, quickSort, "QuickSort");
  runBattery(n, n_size, data, maxN, mergeSort, "MergeSort");
  runBattery(n, n_size, data, maxN, heapSort, "HeapSort");
  runBattery(n, n_size, data, maxN, insertionSort, "InsertionSort");
  
  return 0;
}
