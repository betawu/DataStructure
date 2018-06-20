package com.hash;
/**
 * 
 * @author beta
 *实现hash表
 *java8之前解决hash冲突是链表
 *之后一开始是链表 冲突到一定程度转成红黑树
 */

import java.util.Hashtable;
import java.util.TreeMap;

public class HashTable <K,V>{
	private int M;
	private TreeMap<K, V>[] arr;
	private int size;
	public HashTable(int m) {
		this.M = m;
		arr = new TreeMap[m];
		for (TreeMap<K, V> treeMap : arr) {
			treeMap = new TreeMap<>();
		}
	}
	public HashTable() {
		this(97);
	}
	
	private int hash(K k) {
		return Math.abs(k.hashCode())%M;
	}
	
	public void add(K k,V v) {
		TreeMap<K,V> t = arr[hash(k)];
		if(t.containsKey(k)) {
			t.put(k, v);
		}else {
			t.put(k, v);
			size++;
		}
	}
	
	public V remove(K k) {
		TreeMap<K,V> t = arr[hash(k)];
		V rs = null;
		if(t.containsKey(k)) {
			rs = t.remove(k);
		}
		return rs;
	}
	
	public void set(K k,V v) {
		arr[hash(k)].put(k, v);
	}
	
	public boolean contains(K k) {
		return arr[hash(k)].containsKey(k);
	}
	
	public V get(K k) {
		return arr[hash(k)].get(k);
	}
}
