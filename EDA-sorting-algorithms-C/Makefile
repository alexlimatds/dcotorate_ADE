benchmark: algorithms.o benchmark.c
	gcc benchmark.c algorithms.o -o benchmark -lm
	./benchmark

test: algorithms.o test.c
	gcc test.c algorithms.o -o test -lm
	./test

algorithms.o: algorithms.c
	gcc -c algorithms.c
