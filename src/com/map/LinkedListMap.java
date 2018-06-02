package com.map;
/**
 * 
 * @author beta
 *使用链表实现映射
 */
public class LinkedListMap<K,V> implements Map<K, V> {

	
	//定义节点
	private class Node{
		private K key;
		private V value;
		private Node next;
		public Node() {}
		
		public Node(K key) {
			this.key = key;
		}
		
		public Node(K key,V value) {
			this.key = key;
			this.value = value;
		}
		
		public Node(K key, V value,Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return key + ":" + value;
		}
	}
	
	private Node dummyHead = new Node();
	private int size;
	
	public Node getNode(K key) {
		Node cur = dummyHead.next;
		if(cur != null&&key!=null) {
			if(key.equals(cur.key)) {
				return cur;
			}
			cur = cur.next;
		}
		return null;
	}
	
	@Override
	public void add(K k, V v) {
		Node node = getNode(k);
		if(node == null) {
			size++;
			dummyHead.next = new Node(k,v,dummyHead.next);
		}else {
			node.value = v;
		}
	}

	@Override
	public V remove(K k) {
		Node node = getNode(k);
		if(node == null) {
			return null;
		}else {
			Node pre = dummyHead;
			while(pre != null) {
				if(pre.next == node) {
					pre.next = node.next;
					node.next = null;
					size--;
					return node.value;
				}
			}
			return null;
		}
	}

	@Override
	public V get(K k) {
		Node node = getNode(k);
		return node.value;
	}

	@Override
	public void set(K k, V v) {
		Node node = getNode(k);
		if(node == null) {
			throw new IllegalAccessError("不存在");
		}
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
