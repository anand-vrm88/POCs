package org.anverm.algorithms.dp;

public class LCSDemo {
	static int index = 4;
	static int[][] cost = new int[index][index]; 
	
	public static void main(String[] args) {
		
		char[] a = new char[index];
		char[] b = new char[index];
		for(int i = 0; i < index; i++){
			a[i] = Character.forDigit((int)(Math.random()*10), 10);
			b[i] = Character.forDigit((int)(Math.random()*10), 10);
		}
		System.out.println("a is = "+new String(a));
		System.out.println("b is = "+new String(b));
		//System.out.println("random is = "+Math.random());
		System.out.println("lcs is = "+lcs(a, b, a.length-1, b.length-1));
		for(int i = 0; i < index; i++){
			for(int j = 0; j < index; j++){
				System.out.print(cost[i][j]+" ");		
			}
			System.out.println("");
		}
		

	}
	
	private static int lcs(char[] a, char[] b, int m, int n){
		if(m < 0 || n < 0){
			return 0;
		}
		
		if(cost[m][n] != 0){
			return cost[m][n];
		}
		
		if(a[m] == b[n]){
			cost[m][n] = 1 + lcs(a, b, m-1, n-1);
		} else{
			cost[m][n] = max(lcs(a, b, m-1, n), lcs(a, b, m, n-1));
		}
		return cost[m][n];
	}

	private static int max(int num1, int num2){
		return num1 < num2 ? num2 : num1;
	}
}
