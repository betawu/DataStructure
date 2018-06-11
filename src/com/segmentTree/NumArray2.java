package com.segmentTree;
/**
 * 
 * @author beta
 *给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为sumRange()
 *sumRange(0, 2) -> 1
 *sumRange(2, 5) -> -1
 *有更新操作
 */
public class NumArray2 {
	
	private SegmentTree<Integer> st;
	private Integer[] arr;
	
	public NumArray2(int[] nums) {
		arr = new Integer[nums.length];
        for(int i=0;i<nums.length;i++) {
        	arr[i]=nums[i];
        }
        st = new SegmentTree<>(arr, (a,b)->a+b);
    }
    
    public void update(int i, int val) {
        st.set(i, val);
    }
    
    public int sumRange(int i, int j) {
        return st.query(i, j);
    }
    
    
}
