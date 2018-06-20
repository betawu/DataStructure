package com.basicsort;

import java.util.Arrays;

/**
 * 
 * @author beta
 *冒泡排序
 */
public class BubbleSort {
	public static void sort(int[] arr) {
		for(int j=0;j<arr.length;j++) {
			for(int i=arr.length-1;i>j;i--) {
				if(arr[i]<arr[i-1]) {
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	public static void main(String[] args) {
//		int[] arr = SortTestHelp.generateRandomArray(10, 1, 100);
		int[] arr = {10,9,8,7,6,5,4,3,2,1};
		Arrays.toString(arr);
		sort(arr);
	}
}
