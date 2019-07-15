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
		
		System.out.println(fw.D);
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
