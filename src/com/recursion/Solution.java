package com.recursion;

import com.linkedlist.ListNode;
import com.linkedlist.Solution2;

/**
 * 
 * @author beta
 *删除链表中等于给定值 val 的所有节点。
 */
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		
		if(head == null) {
			return null;
		}
		
		head.next = removeElements(head.next, val);
		if(head.val == val) {
			head = head.next;
		}
		
		return head;
		
	}
	
	//[1,2,6,3,4,5,6]
	public static void main(String[] args) {
		int[] arr = {1,2,6,4,3,5,6};
		ListNode head = new ListNode(arr);
		System.out.println(head);
		Solution2 solution = new Solution2();
		ListNode node = solution.removeElements(head,6);
		System.out.println(node);
	}
}

