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
		root = recursionAdd(root, e);
	}
	
	//添加的递归算法
	private Node recursionAdd(Node node , E e) {
		if(node == null) {
			return new Node(e);
			//对等于情况不做处理默认所有数据都不相等
		}else if(node.data.compareTo(e)==-1){
			node.left = recursionAdd(root.left, e);
			return node.left;
		}else {
			node.right = recursionAdd(node.right, e);
			return node.right;
		}
	}
	
}
