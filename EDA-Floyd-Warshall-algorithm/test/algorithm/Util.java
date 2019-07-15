package algorithm;

import org.junit.Assert;

public class Util {
	public static void assertEquals(
			double[][] expected, 
			double[][] actual, 
			double delta){
		if(expected.length != actual.length)
			throw new IllegalArgumentException("Matrizes com quantidade de linhas diferentes");
		for(int i = 0; i < expected.length; i++){
			for(int j = 0; j < expected[i].length; j++){
				if(expected[i].length != actual[i].length)
					throw new IllegalArgumentException("Matrizes com quantidade de colunas diferentes na linha " + i);
				double diff = Math.abs(expected[i][j] - actual[i][j]);
				if(diff > delta)
					Assert.fail(
							"Esperado: "+ expected[i][j] + 
							" ; Recebido: " + actual[i][j] + 
							" ; Linha "+ i +", coluna " + j);
			}
		}
	}
}
