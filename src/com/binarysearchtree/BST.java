package com.binarysearchtree;
/**
 * 
 * @author beta
 *二分搜索树
 *
 *不包含重复元素(如果重复可以 左子树小于等于跟节点 或者  右子树大于等于跟节点)
 *
 */
public class BST<E extends Comparable<E>> {
	
	
	
	/**
	 * 定义二分搜索树的节点
	 */
	private class Node{
		public E data;
		public Node left;
		public Node right;
		
		public Node(E data) {
			this.data=data;
		}
		public Node() {
		}
		
	}
	
	private Node root;
	private int size;
	public BST() {
		super();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	//添加元素
	public void add(E e) {
		if(root == null) {
			root = new Node(e);
			size++;
		}else if(root.data.compareTo(e)==-1) {
			recursionAdd(root.left,e);
		}else if(root.data.compareTo(e)==1) {
			recursionAdd(root.right,e);
		}else {
			return;
		}
		
	}
	
	//添加的递归算法
	private void recursionAdd(Node root , E e) {
		if(root.data == null) {
			root.data = e;
			size++;
		}else if(root.data.compareTo(e)==-1) {
			//小于根节点
			recursionAdd(root.left,e);
		}else if(root.data.compareTo(e)==1) {
			//大于根节点
			recursionAdd(root.right,e);
		}else {
			return ;
		}
	}
	
}
