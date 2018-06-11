package com.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author beta
 *leetcode 677号问题
 */
public class MapSum {
	/** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for(int i=0;i<key.length();i++) {
        	char c = key.charAt(i);
        	if(cur.next.get(c) == null){
        		cur.next.put(c, new Node());
        	}
        	cur = cur.next.get(c);
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for(int i=0;i<prefix.length();i++) {
        	char c = prefix.charAt(i);
        	if(cur.next.get(c) == null) {
        		return 0;
        	}
        	cur = cur.next.get(c);
        }
        
        return sum(cur);
    }
    
    private int sum(Node cur) {
    	int rs = cur.value;
    	for(Character c:cur.next.keySet()) {
        	rs+=sum(cur.next.get(c));
        }
    	return rs;
	}

	private class Node{
    	public int value;
    	public Map<Character,Node> next;
    	
    	public Node() {
    		this.next = new HashMap<>();
    	}
    	
    	public Node(int value) {
    		this.next = new HashMap<>();
    		this.value = value;
    	}
    }
    
    private Node root;
    
    public static void main(String[] args) {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		ms.insert("app", 2);
		int i = ms.sum("apple");
		System.out.println(i);
	}
}
