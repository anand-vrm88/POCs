package org.anverm.algorithms.backtracking;
/*
 * As per solution in this algorithm may contain mirror image solutions.
 * e.g. if M is 1494, one of solutions will contain 549 and 945. 
 * Though this can be fixed with little check in solutions.
 */
public class ReverseSumDemo {
	public static void main(String[] args) {
		int m = 66666;
		int numOfDigits = numOfDigits(m);
		
		/*
		 * if msb is 1, target number can be sum of n digit number or n-1 digit number.
		 */
		if(msb(m) == 1){
			findNumber(numOfDigits, m);
			findNumber(numOfDigits - 1, m);
		} else {
			findNumber(numOfDigits, m);
		}
	}
	
	private static int numOfDigits(int m){
		int numOfDigits = 0;
		while(m != 0){
			m = m / 10;
			numOfDigits++;
		}
		return numOfDigits;
	}
	
	private static int msb(int m){
		int msb = 0;
		while(m != 0){
			msb = m;
			m = m / 10;
		}
		return msb;
	}

	private static void findNumber(int numOfDigits, int m){
		int[] coeff = generateCoefficient(numOfDigits);
		int[] result = new int[numOfDigits];
		findNumberBacktracking(coeff, m, 0, result);
	}
	
	/*
	 * if M is obtained from n digits (say a1, a2, a3,...an) number N (i.e. N + rev(N) = M),
	 * M is equal basically equal to 
	 * a1*(10^0 + 10^(n-1)) + a2*(10^1 + 10^(n-2)) + a3*(10^2 + 10^(n-3)) + ............ + an*(10^(n-1) + 10^0) 
	 * 
	 * This method generates these coefficient to each digits. 
	 */
	private static int[] generateCoefficient(int numOfDigits){
		int[] coeff = new int[numOfDigits];
		for(int i = 0; i < numOfDigits; i++){
			coeff[i] = (int) (Math.pow(10, i) + Math.pow(10, numOfDigits - i - 1));
		}
		return coeff;
	}
	
	/*
	 * Backtracking algorithm to figure out solutions.
	 * 
	 * Each digit can be either of 0 to 9. 
	 */
	private static void findNumberBacktracking(int[] coeff, int m, int index, int[] result){
		if(m == 0){
			if(index == coeff.length){
				printArray(result);
			} else {
				return;
			}
		}
		if(m < 0){
			return;
		}
		if(index == coeff.length){
			return;
		}
		for(int i = 0; i < 10; i++){
			result[index] = i;
			findNumberBacktracking(coeff, m - (i * coeff[index]), index + 1, result);
			result[index] = 0;
		}
	}
	
	private static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}
}
