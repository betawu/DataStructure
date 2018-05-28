package com.recursion;


/**
 * 
 * @author beta
 *递归求arr[]的和
 */
public class Sum {
	public static int getArrSum(int[] arr) {
		return getSum(arr,0);
	}

	//求arr从l索引开始到结束的和
	private static int getSum(int[] arr, int l) {
		if(l==arr.length) {
			return 0;
		}
		int sum = arr[l]+getSum(arr,l+1);
		
		return sum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1};
		
		System.out.println(Sum.getArrSum(arr));
	}
	
	
}
