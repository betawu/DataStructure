package com.segmentTree;
/**
 * 
 * @author beta
 *给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为sumRange()
 *sumRange(0, 2) -> 1
 *sumRange(2, 5) -> -1
 */
public class NumArray {
	
	private int[] sum;//sum[0]=0表示0个元素的和
						//sum[i+1]表示i个元素的和
	
	public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for(int i=1;i<sum.length;i++) {
        	sum[i] = sum[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}
