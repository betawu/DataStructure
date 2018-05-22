package com.array;

public class Main {
	 public static void main(String[] args) {
		Array<Integer> arr = new Array<>();
		
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		
		
		System.out.println(arr);
		
		arr.add(1, 100);
		System.out.println(arr);
		
		arr.addFirst(-1);
		System.out.println(arr);
		
		System.out.println(arr.get(0));
		
		arr.set(0, 999);
		System.out.println(arr);
		
		System.out.println(arr.contains(999));
		
		System.out.println(arr.find(0));
		
		
		arr.removeElement(0);
		System.out.println(arr);
		
		
		arr.remove(0);
		System.out.println(arr);
	}
}
