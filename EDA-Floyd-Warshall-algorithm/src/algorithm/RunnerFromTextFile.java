package algorithm;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class RunnerFromTextFile {
	
	public static void main(String[] args) {
		String fileName = "example1.txt";
		if(args.length == 1){
			fileName = args[0];
		}
		
		double[][] W = readAdjacencyMatrix(fileName);
		FloydWarshall fw = new FloydWarshall();
		fw.search(W);
		
		int n = W.length;
		System.out.println("Weight matrix of shortest paths:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%4.0f ", fw.D[i][j]);
			System.out.println();
		}
		System.out.println("Antecessors matrix of shortest paths:");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%4d ", fw.P[i][j]);
			System.out.println();
		}
		System.out.println("Are there negative cycles: " + fw.hasNegativeCycles());
	}
	
	private static double[][] readAdjacencyMatrix(String fileName){
		try{
			List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
			int n = Integer.parseInt(lines.get(0));
			double[][] w = new double[n][n];
			for(int i = 0; i < n; i++){
				String[] s = lines.get(i + 1).split(" ");
				for(int j = 0; j < n; j++){
					try{
						w[i][j] = Double.parseDouble(s[j]);
					}
					catch(NumberFormatException ex){
						w[i][j] = Double.POSITIVE_INFINITY;
					}
				}
			}
			
			return w;
		}
		catch(Exception ex){
			throw new IllegalArgumentException(ex);
		}
	}
}
