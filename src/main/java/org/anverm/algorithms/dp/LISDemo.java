package org.anverm.algorithms.dp;

public class LISDemo {
	
	static int[] lis = new int[32];

	public static void main(String[] args) {
		int index = 32;
		/*int[] array = new int[index];
		for(int i = 0; i < index; i++){
			array[i] = i+1;
		} */
		
		int[] array = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		
		long start = System.currentTimeMillis();
		System.out.println(list(array, array.length));
		long end = System.currentTimeMillis();
		System.out.println("time spent = "+(end - start)/1000);
	}
	
	private static int list(int[] array, int length){
		if(length == 1){
			return 1;
		}
		
		int max = 0;
		
		for(int i = 0; i < length - 1; i++){
			if(array[i] < array[length-1]){
				if(lis[i] == 0){
					lis[i] = list(array, i+1);
				}
				if(lis[i] > max){
					max = lis[i];
				}
			}
		}
		return max + 1;
	}

}
