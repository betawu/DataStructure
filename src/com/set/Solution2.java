package com.set;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 * @author beta
 *给定两个数组，写一个函数来计算它们的交集。
 *给定 num1= [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 */
public class Solution2 {
	public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer i : nums1) {
			set.add(i);
		}
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer i : nums2) {
			if(set.contains(i)) {
				list.add(i);
				set.remove(i);
			}
		}
        int[] arr = new int[list.size()];
        for (int i =0 ;i<list.size();i++) {
        	arr[i] = list.get(i);
		}
        return arr;
    }
}
