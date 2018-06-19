package com.basicsort;

public class SortTestHelp {
	public static int[]  generateRandomArray(int n, int l, int r) {
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = (int)(Math.random()*(r-l+1)+l);
		}
		
		return arr;
	}
	
	
}
