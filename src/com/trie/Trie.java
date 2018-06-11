package com.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author beta
 *字典树
 */
public class Trie {
	
	//节点
	private class Node{
		private boolean isWord;
		private Map<Character,Node> next;
		
		public Node() {
			this.isWord=false;
			this.next = new HashMap<>();
		}
		public Node(boolean isWord) {
			this.isWord = isWord;
		}
	}
	
	private Node root;
	private int size;
	
	
	
	public Trie() {
		super();
		this.root = new Node();
	}

	public int getSize() {
		return size;
	}
	
	public void insert(String word) {
		Node cur = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			
			if(cur.next.get(c) == null) {
				cur.next.put(c, new Node());
			}
			cur = cur.next.get(c);
		}
		
		if(!cur.isWord) {
			size++;
			cur.isWord = true;
		}
		
	}
	
	public boolean search(String word) {
		Node cur = root;
		for(int i=0;i<word.length();i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null) {
				return false;
			}
			cur =cur.next.get(c);
		}
		return cur.isWord;
	}
	
	
	//搜索trie是否包含某个字符串开头的单词
	public boolean startsWith(String preFix) {
		Node cur = root;
		for(int i=0;i<preFix.length();i++) {
			char c = preFix.charAt(i);
			if(cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
//		trie.add("asdf");
//		System.out.println(trie.contains("a"));
//		System.out.println(trie.contains("asdf"));
//		System.out.println(trie.isPreFix("aas"));
		trie.insert("ad");
		trie.insert("add");
		System.out.println(trie.startsWith("a"));
	}
	
	
}
