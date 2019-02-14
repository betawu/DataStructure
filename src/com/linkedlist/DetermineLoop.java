package com.linkedlist;

/**
*使用快慢指针判断链表是否有循环
*/
public class DetermineLoop {
  //算法不允许产生任何实例
  private DetermineLoop(){}
  
  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
  }
  
  private static boolean HasLoop(ListNode node) {
        ListNode p = node;
        ListNode q = node;
        while (p != null && q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return true;
            }
        }
        return false;
    }
}
