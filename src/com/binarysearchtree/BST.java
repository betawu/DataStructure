package com.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

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
	
	//前序遍历的非递归实现
	public void preOrderNR() {
		preOrderNr(root);
	}
	
	private void preOrderNr(BST<E>.Node root) {
		Stack<Node> stack = new Stack<>();
		if(root != null) {
			stack.push(root);
		}
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			System.out.println(node.data);
			if(node.right!=null) {
				stack.push(node.right);
			}
			if(node.left!=null) {
				stack.push(node.left);
			}
		}
		
		
	}

	//中序遍历
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(BST<E>.Node node) {
		if(node == null) {
			return ;
		}
		
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}

	//后续遍历
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(BST<E>.Node node) {
		if(node == null) {
			return ;
		}
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.data);
	}

	//层序遍历
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		
		if(root != null) {
			q.add(root);
		}
		while(!q.isEmpty()) {
			Node node = q.remove();
			System.out.println(node.data);
			if(node.left!=null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
		}
		
	}
	
	
	//获取最大元素
	public Node maxmum() {
		return maxmum(root);
	}
	
	private Node maxmum(BST<E>.Node node) {
		if(node.right == null) {
			return node;
		}
		return maxmum(node.right);
	}

	//获取最小元素
	public Node minmum() {
		return minmum(root);
	}
	
	private Node minmum(BST<E>.Node node) {
		if(node.left == null) {
			return node;
		}
		return minmum(node.left);
	}

	//删除最小元素
	public E removeMin() {
		Node rs = minmum();
		root = removeMin(root);
		return rs.data;
	}
	
	private BST<E>.Node removeMin(BST<E>.Node node) {
		if(node.left == null) {
			Node ret = node.right;
			node.right = null;
			size--;
			return ret;
		}
		node.left = removeMin(node.left);
		return node;
	}
	
	//删除最大元素
	public E removeMax() {
		Node rs = maxmum();
		root = removeMax(root);
		return rs.data;
	}

	private BST<E>.Node removeMax(BST<E>.Node node) {
		if(node.right == null) {
			Node ret = node.left;
			node.left = null;
			size--;
			return ret;
		}
		node.right = removeMax(node.right);
		return node;
	}

	//删除任意元素
	public void remove(E e) {
		root = remove(root,e);
	}
	
	private BST<E>.Node remove(BST<E>.Node node, E e) {
		if(node == null) {
			return null;
		}
		
		if(e.compareTo(node.data) == -1) {
			node.left = remove(node.left,e);
		}else if(e.compareTo(node.data) == 1) {
			node.right = remove(node.right,e);
		}else {
			//如果删除节点的左子树为空
			if(node.left == null) {
				return node.right;
			}else if(node.right == null) {
				//如果删除节点的右子树为空
				return node.left;
			}else {
				//左右子树都不为空
				Node successor = minmum(node.right);
				node.right = removeMin(node.right);
				successor.left = node.left;
				successor.right = node.right;
				return successor;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		int[] arr = {5,3,6,8,4,2};
		BST<Integer> bst = new BST<>();
		for (int i : arr) {
			bst.add(i);
		}
//		
//		bst.preOrder();
//		System.out.println("---");
//		bst.preOrderNR();
//		System.out.println("---");
		
		
//		bst.inOrder();
		
//		bst.postOrder();
		
		
//		bst.levelOrder();
		
		//删除最大和最小元素测试
//		BST<Integer> b = new BST<>();
//		Random r = new Random();
//		for(int i = 0 ;i<10;i++) {
//			b.add(r.nextInt(1000));
//		}
//		List<Integer> list = new ArrayList<>();
//		while(!b.isEmpty()) {
//			list.add(b.removeMin());
//		}
//		System.out.println(list);
		
//		
//		bst.remove(6);
//		bst.inOrder();
	}
}
