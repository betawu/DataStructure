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
			size++;
			return new Node(e);
			//对等于情况不做处理默认所有数据都不相等
		}else if(node.data.compareTo(e)==-1){
			node.right = recursionAdd(node.right, e);
		}else if(node.data.compareTo(e)==1){
			node.left = recursionAdd(node.left, e);
		}
		return node;
	}
	
	public boolean contains(E e) {
		return contains(root,e);
	}

	private boolean contains(BST<E>.Node node, E e) {
		if(node == null) {
			return false;
		}
		
		if(node.data.compareTo(e) == 0) {
			return true;
		}else if(node.data.compareTo(e) == -1) {
			return contains(node.left,e);
		}else {
			return contains(node.right,e);
		}
	}
	
	//二叉树的前序遍历
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(BST<E>.Node node) {
		if(node == null) {
			return;
		}
		
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void main(String[] args) {
		int[] arr = {5,3,6,8,4,2};
		BST<Integer> bst = new BST<>();
		for (int i : arr) {
			bst.add(i);
		}
		
		bst.preOrder();
	}
}
