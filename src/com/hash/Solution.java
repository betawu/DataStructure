package com.hash;

import java.util.Arrays;

/**
 * 
 * @author beta
 *leetcode387号问题
 */
public class Solution {
	public int firstUniqChar(String s) {
		int[] arr = new int[26];
		for(int i=0;i<s.length();i++) {
			int index = s.charAt(i)-'a';
			arr[index] = arr[index]+1;
		}
		for(int i =0 ; i<s.length();i++) {
			int index = s.charAt(i)-'a';
			if(arr[index]==1) {
				return i;
			}
		}
		return -1;
    }
	
}
