package com.AVLTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.binarysearchtree.BST;

/**
 * 
 * @author beta
 *avl平衡二叉树O
 *
 *不包含重复元素(如果重复可以 左子树小于等于跟节点 或者  右子树大于等于跟节点)
 *
 */
public class AVLTree<E extends Comparable<E>> {
	
	
	
	/**
	 * 定义二分搜索树的节点
	 */
	private class Node{
		public E data;
		public Node left;
		public Node right;
		//高度
		public int height;
		
		public Node(E data) {
			this.data=data;
			this.height=1;
		}
		public Node() {
		}
		
	}
	
	private Node root;
	private int size;
	public AVLTree() {
		super();
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	
	//获取树的高度
	private int getHeight(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
	
	//获取树的平衡因子
	private int getBalanceFactor(Node node) {
		return getHeight(node.left) - getHeight(node.right);
	}
	
	//判断是否是二分搜索树
	public boolean isBST() {
		ArrayList<E> list = new ArrayList<>();
		inOrder(root,list);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).compareTo(list.get(i+1))>0) {
				return false;
			}
		}
		return true;
	}
	
	private void inOrder(Node node,ArrayList<E> list) {
		if(node == null) {
			return ;
		}
		inOrder(node.left,list);
		list.add(node.data);
		inOrder(node.right,list);
	}
	
	//判断是不是平衡二叉树
	public boolean isBanlance() {
		return isBanlance(root);
	}

	private boolean isBanlance(AVLTree<E>.Node node) {
		
		
		if(Math.abs(getHeight(node.left)-getHeight(node.right))>2) {
			return false;
		}
		if(node.left!=null&&node.right!=null) {
			if(!isBanlance(node.left)) {
				return false;
			}else if(!isBanlance(node.right)) {
				return false;
			}
		}
		
		
		return true;
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
		
		//更新树高度
		node.height = Math.max(getHeight(node.left),getHeight(node.right))+1;
		
		//维护平衡
		//当前节点左侧不平衡getBalanceFactor(node)>1
		//当前节点左子树的左子树多添加了一个节点导致不平衡getBalanceFactor(node.left)>=0
		//LL情况
		//右旋转
		if(getBalanceFactor(node)>1&&getBalanceFactor(node.left)>=0) {
			return rightRotate(node);
		}
		
		//RR情况
		if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)<=0) {
			return leftRotate(node);
		}
		
		//LR 先对左子树进行左旋转 然后对右子树进行右旋转
		if(getBalanceFactor(node)>1&&getBalanceFactor(node.left)<0) {
			node.left = leftRotate(node.left);
			return leftRotate(node);
		}
		
		//RL 先对右子树进行右旋转 然后进行左旋转
		if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)>0) {
			node.right = rightRotate(node.right);
			return rightRotate(node);
		}
		
		return node;
	}
	
	
	//向右旋转
	// 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
	private Node rightRotate(Node y) {
		Node x = y.left;
		Node t3 = x.right;
		
		//右旋转
		x.right = y;
		y.left  = t3;
		
		//维护高度
		y.height  = Math.max(getHeight(y.left),getHeight(y.right))+1;
		x.height = Math.max(getHeight(x.left),getHeight(x.right))+1;
		
		return x;
	}
	
	//向左旋转
	// 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
	private Node leftRotate(Node y) {
		Node x = y.right;
		Node t2 = x.left;
		
		//左旋转
		x.left = y;
		y.right = t2;
		
		//维护高度
		y.height = Math.max(getHeight(y.left), getHeight(y.right))+1;
		x.height = Math.max(getHeight(x.left), getHeight(x.right))+1;
		
		return x;
	}
	
	public boolean contains(E e) {
		return contains(root,e);
	}

	private boolean contains(Node node, E e) {
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

	private void preOrder(Node node) {
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
	
	private void preOrderNr(Node root) {
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
	
	private void inOrder(Node node) {
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
	
	private void postOrder(Node node) {
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

	//获取最小元素
	public Node minmum() {
		return minmum(root);
	}
	
	private Node minmum(Node node) {
		if(node.left == null) {
			return node;
		}
		return minmum(node.left);
	}

	

	//删除任意元素
	public void remove(E e) {
		root = remove(root,e);
	}
	
	private Node remove(Node node, E e) {
		if(node == null) {
			return null;
		}
		
		Node rs = null;
		if(e.compareTo(node.data) == -1) {
			node.left = remove(node.left,e);
			rs = node;
		}else if(e.compareTo(node.data) == 1) {
			node.right = remove(node.right,e);
			rs = node;
		}else {
			//如果删除节点的左子树为空
			if(node.left == null) {
				rs = node.right;
			}else if(node.right == null) {
				//如果删除节点的右子树为空
				rs = node.left;
			}else {
				//左右子树都不为空
				Node successor = minmum(node.right);
				node.right = remove(node.right,successor.data);
				successor.left = node.left;
				successor.right = node.right;
				rs = successor;
			}
		}
		
		if(rs == null) {
			return null;
		}
		
		if(getBalanceFactor(rs)>1&&getBalanceFactor(rs.left)>=0) {
			rs = rightRotate(rs);
		}
		
		//RR情况
		if(getBalanceFactor(rs)<-1&&getBalanceFactor(rs.right)<=0) {
			return leftRotate(rs);
		}
		
		//LR 先对左子树进行左旋转 然后对右子树进行右旋转
		if(getBalanceFactor(rs)>1&&getBalanceFactor(rs.left)<0) {
			rs.left = leftRotate(rs.left);
			return leftRotate(rs);
		}
		
		//RL 先对右子树进行右旋转 然后进行左旋转
		if(getBalanceFactor(rs)<-1&&getBalanceFactor(rs.right)>0) {
			rs.right = rightRotate(rs.right);
			return rightRotate(rs);
		}
		return rs;
	}

	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		AVLTree<Integer> t = new AVLTree<>();
		for (int i : arr) {
			t.add(i);
		}
		System.out.println(t.isBanlance());
		t.levelOrder();
//		t.inOrder();
//		t.preOrder();
	}
	
}
