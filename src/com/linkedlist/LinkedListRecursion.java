package com.linkedlist;

import com.linkedlist.LinkedList.Node;

/**
 * 
 * 
 * @author beta
 *
 *用递归的方式实现链表的增删改查操作
 */
public class LinkedListRecursion<E> {
	//定义链表节点
		public class Node{
			public E data;
			public Node next;
			public Node(E data, Node next) {
				super();
				this.data = data;
				this.next = next;
			}
			public Node(E data) {
				super();
				this.data=data;
			}
			public Node() {
				super();
			}
			@Override
			public String toString() {
				return data.toString();
			}
		}
		
		private Node dummyHead;
		private int size;
		
		public LinkedListRecursion() {
			dummyHead = new Node(null,null);
			size=0;
		}
		
		public void addFirst(E e) {
			add(0,e);
		}
		
		int count ;
		public void add(int index,E e) {
			if(index<0||index>size) {
				throw new IllegalAccessError("索引越界");
			}
			count = 0;
			addRecursion(index,e,dummyHead);
			
		}
		//链表添加的递归函数
		private void addRecursion(int index, E e,Node cur) {
			if(index == count) {
				Node node = new Node(e);
				node.next = cur.next;
				cur.next = node;
				size++;
				return ;
			}
			count++;
			addRecursion(index,e,cur.next);
		}

		public void addLast(E e) {
			add(size,e);
		}
		
		//找指定索引的节点
		//找当前节点  从虚拟节点后一个节点开始遍历
		public E get(int index) {
			if(index<0||index>=size) {
				throw new IllegalAccessError("索引越界");
			}
			
			count =0;
			return getRecursion(index,dummyHead.next);
			
		}
		//递归获取链表的元素
		private E getRecursion(int index, LinkedListRecursion<E>.Node cur) {
			if(index == count) {
				return cur.data;
			}
			count++;
			return getRecursion(index, cur.next);
		}

		public E getFirst() {
			return get(0);
		}
		
		public E getLast() {
			return get(size-1);
		}
		
		public void set(int index,E e) {
			if(index<0||index>=size) {
				throw new IllegalAccessError("索引越界");
			}
			count = 0;
			setRecursion(dummyHead.next,index,e);
			
		}
		//链表修改的递归操作
		private void setRecursion(LinkedListRecursion<E>.Node cur, int index, E e) {
			if(index == 0) {
				cur.data = e;
			}
			count++;
			setRecursion(cur.next, index, e);
		}

		public boolean contains(E e) {
			Node cur = dummyHead.next;
			if(cur.data.equals(e)) {
				return true;
			}else {
				return contaions(cur.next,e);
			}
		}
		//链表是否包含某个元素的递归函数
		private boolean contaions(LinkedListRecursion<E>.Node cur,E e) {
			if(cur==null||!cur.data.equals(e)) {
				return false;
			}else {
				return true;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(Node cur=dummyHead.next;cur!=null;cur=cur.next) {
				sb.append(cur.data).append("->");
			}
			sb.append("null");
			return sb.toString();
			
		}
		
		
		public E remove(int index) {
			if(index<0||index>=size) {
				throw new IllegalAccessError("索引越界");
			}
			
			count = 0;
			return remove(dummyHead,index);
		}
		//链表删除的递归算法
		private E remove(LinkedListRecursion<E>.Node pre, int index) {
			if(index == count) {
				E e = pre.next.data;
				pre.next = pre.next.next;
				size--;
				return e;
			}
			count++;
			return remove(pre.next,index);
		}

		public E removeFirst() {
			return remove(0);
		}
		
		public E removeLast() {
			return remove(size-1);
		}
		
		
		
		public int getSize() {
			return size;
		}
		
		public static void main(String[] args) {
			LinkedListRecursion<Integer> list = new LinkedListRecursion<>();
			for(int i=0;i<10;i++) {
				list.addFirst(i);
				System.out.println(list);
			}
			
			list.add(2, 666);
			System.out.println(list);
			
			list.remove(2);
			System.out.println(list);
			
			list.removeFirst();
			System.out.println(list);
			list.removeLast();
			System.out.println(list);
		}
}
