package com.linkedlist;
/**
 * 
 * @author beta
 *
 *删除链表中等于给定值 val 的所有节点。
 *
 *不带虚拟头节点
 */
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		//首先删除列表头部所有值为val的节点
		while(head!=null&&head.val==val) {
			ListNode n = head;
			head=head.next;
			n.next=null;
		}
		
		//为空直接返回
		ListNode cur = head;
		if(cur==null) {
			return null;
		}
		
		//删除链表中间为val的节点
		while(cur.next!=null) {
			if(cur.next.val==val) {
				ListNode n = cur.next;
				cur.next = n.next;
				n.next=null;
			}else {
				cur = cur.next;
			}
		}
		
		
		return head;
    }
	
	
	//[1,2,6,3,4,5,6]
	public static void main(String[] args) {
		int[] arr = {1,2,6,4,3,5,6};
		ListNode head = new ListNode(arr);
		System.out.println(head);
		Solution solution = new Solution();
		ListNode node = solution.removeElements(head,6);
		System.out.println(node);
	}
}
