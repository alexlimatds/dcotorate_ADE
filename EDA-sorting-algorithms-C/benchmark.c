#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/time.h>
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
  
  for(int i = 0; i < n_size; i++){
    printf("input of size %d\n", n[i]);
    for(int j = 1; j < 6; j++){
      int *input = copyArray(data, n[i]);
      struct timeval stop, start;
      gettimeofday(&start, NULL);
      sortFunction(input, n[i]);
      gettimeofday(&stop, NULL);
      long time = ((stop.tv_sec * 1e6 + stop.tv_usec) - (start.tv_sec * 1e6 + start.tv_usec)) / 1000; //time in ms
      fprintf(file, "%d;%d;%ld\n", n[i], j, time);
      free(input);
    }
  }
  
  fclose(file);
}

int main(void){
  int n[] = {1000, 5000, 10000, 50000, 
				100000, 500000, 1000000};
  int n_size = 7;
  
  int maxN = n[n_size - 1];
  int data[maxN];
  for(int i = 0; i < maxN; i++){
    data[i] = rand() % (maxN / 10);
  }
  
  runBattery(n, n_size, data, maxN, quickSort, "QuickSort");
  runBattery(n, n_size, data, maxN, mergeSort, "MergeSort");
  runBattery(n, n_size, data, maxN, insertionSort, "InsertionSort");
  
  return 0;
}
