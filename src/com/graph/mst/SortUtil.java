package com.graph.mst;

public class SortUtil {

	public static <T extends Comparable<T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}
	
	public static <T> void exch(T[] arr, int i, int j) {
		T temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static <T extends Comparable<T>> boolean isSort(T[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			if (arr[i].compareTo(arr[i + 1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
}
