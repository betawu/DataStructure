package com.selectionsort;

import java.util.Arrays;

/**
 * 
 * @author beta
 *选择排序
 */
public class selectionsort{
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = arr[i];
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					i = j;
				}
			}
			swap(arr,min,i);
		}
	}

	private static void swap(int[] arr, int min, int i) {
		int temp = arr[min];
		arr[min] = arr[i];
		arr[i] = temp;
	}
	
	public static void main(String[] args) {
		int[] arr = {10,9,8,7,6,5,4,3,2,1,0};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
