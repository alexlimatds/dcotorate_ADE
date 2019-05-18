package sorting;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Benchmark {
	
	public static void main(String[] args) {
		//tamanhos das entradas
		int[] n = {10, 20, 30, 50, 
				100, 200, 300, 700, 
				1_000, 5_000, 10_000, 50_000};
		
		int[] data = Util.createRandomArray(n[n.length -1]);
		
		try{
			runBattery(new MergeSort(), n, data);
			runBattery(new QuickSort(), n, data);
			runBattery(new HeapSort(), n, data);
			runBattery(new InsertionSort(), n, data);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	static void runBattery(Sorter sorter, int[] n, int[] data) throws IOException{
		int maxN = n[n.length - 1]; //maxN must be the last element in data
		if(maxN > data.length)
			throw new IllegalArgumentException("data size lower than max input size");
		
		String sorterName = sorter.getClass().getSimpleName();
		String txt = "n;case number;time in nanosecs\n";
		
		System.out.println(sorterName);
		
		for(int ni : n){
			System.out.println("input of size " + ni);
			for(int i = 1; i <= 10; i++){
				int[] input = Arrays.copyOf(data, ni);
				long time = runCase(input, sorter);
				txt += String.format("%d;%d;%d\n", ni, i, time);
			}
		}
		
		PrintWriter fileWriter = new PrintWriter(new FileWriter(sorterName + ".txt"));
		fileWriter.print(txt);
		fileWriter.close();
	}
	
	static long runCase(int[] v, Sorter sorter){
		long start = System.nanoTime();
		sorter.sort(v);
		long stop = System.nanoTime();
		return stop -start;
	}
}
