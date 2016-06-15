package org.anverm.algorithms.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class PairSumDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 5, 7, -1, 6, 2, 3, 4, 9, -8, 11, -14, 13, 19, 20, 17, 23, 29, 31, -30};
		int sum = 6;
		Set<LinkedList<Integer>> set = pairSum(array, array.length-1, new LinkedList<Integer>(), sum);
		System.out.println("total subsets = "+set.size());
		for(LinkedList<Integer> list : set){
			System.out.println(list);
		}
	}
	
	private static Set<LinkedList<Integer>> pairSum(int[] array, int index, LinkedList<Integer> result, int sum){
		Set<LinkedList<Integer>> set = new HashSet<LinkedList<Integer>>();
		if(sum == 0){
			//System.out.println("solution = "+result);
			set.add(new LinkedList<Integer>(result));
			//return;
		}
		
		if(sum < 0 || index < 0){
			return set;
		}
		
		set.addAll(pairSum(array, index - 1, result, sum));
		LinkedList<Integer> list = new LinkedList<Integer>(result);
		list.add(array[index]);
		set.addAll(pairSum(array, index - 1, list, sum - array[index]));
		return set;
	}

}
