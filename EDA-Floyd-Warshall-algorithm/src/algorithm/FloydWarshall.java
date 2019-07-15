package algorithm;

public class FloydWarshall {
	
	public double[][] D; //shortest path weights
	public Integer[][] P; //predecessor vertices
	
	public void search(double[][] W){
		int n = W.length;
		//initializing matrices
		D = new double[n][n];
		P = new Integer[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				D[i][j] = W[i][j];
				if(i == j || W[i][j] == Double.POSITIVE_INFINITY)
					P[i][j] = null;
				else if(i != j && W[i][j] < Double.POSITIVE_INFINITY)
					P[i][j] = i;
			}
		}
		
		for(int k = 0; k < n; k++){
			double[][] Dk = new double[n][n];
			Integer[][] Pk = new Integer[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++){
					Dk[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
					if(D[i][j] <= D[i][k] + D[k][j])
						Pk[i][j] = P[i][j];
					else
						Pk[i][j] = P[k][j];
				}
			D = Dk;
			P = Pk;
		}
	}
}
