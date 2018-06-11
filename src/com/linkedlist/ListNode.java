package com.linkedlist;

public class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; }
	
	public ListNode(int[] arr) {
		if(arr==null||arr.length==0) {
			throw new IllegalAccessError("数组为空");
		}
		
		this.val = arr[0];
		ListNode cur = this;
		for(int i = 1;i<arr.length;i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode cur = this;
		sb.append(cur.val);
		sb.append("->");
		while(cur.next!=null) {
			sb.append(cur.next.val);
			sb.append("->");
			cur = cur.next;
		}
		sb.append("null");
		return sb.toString();
	}
	
	
}
