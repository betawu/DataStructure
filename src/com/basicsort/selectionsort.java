package com.basicsort;

import java.util.Arrays;

/**
 * 
 * @author beta
 *选择排序
 */
public class selectionsort{
	public static void sort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int min = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min]) {
					min = j;
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
		int[] arr = SortTestHelp.generateRandomArray(10, 10, 100);
		System.out.println(Arrays.toString(arr));
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
