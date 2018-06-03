package com.map;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * @author beta
 * 给定两个数组，写一个方法来计算它们的交集
 *给定 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2, 2].
 */
public class Solution {
	public int[] intersect(int[] nums1, int[] nums2) {
		TreeMap<Integer,Integer> map = new TreeMap<>();
        for (Integer i : nums1) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, 1);
			}
		}
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : nums2) {
			if(map.containsKey(i)) {
				list.add(i);
				map.put(i, map.get(i)-1);
				if(map.get(i)==0) {
					map.remove(i);
				}
			}
		}
        int[] arr =new int[list.size()];
        for(int i =0;i<list.size();i++) {
			arr[i] = list.get(i);
		}
        return arr;
    }
	
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr1 = {1};
		int[] arr2 = {1};
		solution.intersect(arr1, arr2);
	}
}
