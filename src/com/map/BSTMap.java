package com.map;
/**
 * 
 * @author beta
 *基于二分搜索树实现map映射
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K, V>{

	//定义节点
	private class Node{
		private Node left;
		private Node right;
		private K key;
		private V value;
		public Node(K key,V value){
			this.key = key;
			this.value = value;
		}
		public Node() {}
	}
	
	private Node root = new Node();
	private int size;
	
	public Node getNode(Node node,K key) {
		if(node == null) {
			return null;
		}else if(node.key.compareTo(key) == -1) {
			return getNode(node.left, key);
		}else if(node.key.compareTo(key) == 1) {
			return getNode(node.right, key);
		}else {
			return node;
		}
	}
	
	@Override
	public void add(K k, V v) {
		root = add(root ,k,v);
	}

	private BSTMap<K, V>.Node add(BSTMap<K, V>.Node node, K k, V v) {
		if(node == null) {
			size++;
			return new Node(k,v);
		}else if(node.key.compareTo(k) == -1){
			node.left = add(node.left,k,v);
		}else if(node.key.compareTo(k) == 1) {
			node.right = add(node.right,k,v);
		}else {
			node.value = v;
		}
		return node;
	}

	@Override
	public V remove(K k) {
		Node rs = getNode(root, k);
		if(rs == null) {
			return null;
		}
		Node node = remove(root,k);
		return rs.value;
	}
	
	private BSTMap<K, V>.Node remove(BSTMap<K, V>.Node node,K k) {
		if(node.key.compareTo(k) == -1) {
			node.left = remove(node.left, k);
		}else if(node.key.compareTo(k) == 1) {
			node.right = remove(node.right, k);
		}else {
			if(node.left == null) {
				size--;
				return node.right;
			}else if(node.right == null) {
				size--;
				return node.left;
			}else {
				BSTMap<K, V>.Node min = minmum(node.right);
				remove(node.right, min.key);
				min.left = node.left;
				min.right = node.right;
				return min;
			}
		}
		return null;
	}

	public K minmum() {
		if(isEmpty()) {
			throw new IllegalAccessError("为空");
		}
		Node node = minmum(root);
		return node.key;
	}

	private BSTMap<K, V>.Node minmum(BSTMap<K, V>.Node node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}
	
	public void removeMin() {
		root = removeMin(root);
	}

	private BSTMap<K, V>.Node removeMin(BSTMap<K, V>.Node node) {
		if(node.left == null) {
			return node.right;
		}else {
			return removeMin(node.left);
		}
	}

	@Override
	public V get(K k) {
		Node node = getNode(root, k);
		return node.value;
	}

	@Override
	public void set(K k, V v) {
		Node node = getNode(root, k);
		node.value = v;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	public static void main(String[] args) {
		LinkedListMap<Integer,Integer> m = new LinkedListMap<>();
		m.add(1, 2);
		m.add(2, 2);
		m.add(2, 3);
		System.out.println(m.get(2));
		System.out.println(m.size());
		m.set(2, 4);
		System.out.println(m.get(2));
		System.out.println(m.remove(2));
	}

}
