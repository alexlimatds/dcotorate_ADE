package algorithm;

import java.util.Arrays;

public class FloydWarshall {
	public double[][] search(double[][] W){
		int n = W.length;
		double[][] D = new double[n][n];
		for(int i = 0; i < n; i++){
			D[i] = Arrays.copyOf(W[i], n);
		}
		
		for(int k = 0; k < n; k++){
			double[][] Dk = new double[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					Dk[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
			D = Dk;
		}
		
		return D;
	}
}
