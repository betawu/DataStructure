package com.linkedlist;
/**
 * 
 * @author beta
 *
 *删除链表中等于给定值 val 的所有节点。
 *
 *带虚拟头节点
 */
public class Solution2 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		
		
		ListNode pre = dummyHead;
		while(pre.next!=null) {
			if(pre.next.val==val) {
				ListNode n =pre.next;
				pre.next = n.next;
				n.next = null;
			}else{
				pre = pre.next;
			}
		}
		
		
//		while(dummyHead.next!=null) {
//			if(dummyHead.next.val==val) {
//				ListNode n = dummyHead.next;
//				dummyHead.next = n.next;
//				n = null;
//			}else {
//				break;
//			}
//		}
//		
//		if(dummyHead.next==null) {
//			return null;
//		}
//		
//		ListNode n = dummyHead;
//		while(n.next!=null) {
//			if(n.next.val==val) {
//				ListNode ln = n.next;
//				n.next = ln.next;
//				ln = null;
//			}else{
//				n = n.next;
//			}
//		}
		
		
		return dummyHead.next;
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