package com.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author beta
 *leetcode 211问题
 */
public class WordDictionary {
	
	//节点
	private class Node{
		
		private boolean isWord;
		private Map<Character,Node> next;
		
		public Node() {
			this.isWord = false;
			this.next = new HashMap<>();
		}
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			this.next = new HashMap<>();
		}
	}
	
	private Node root ;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        this.root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for(int i=0;i<word.length();i++) {
        	char c = word.charAt(i);
        	if(cur.next.get(c) == null) {
        		cur.next.put(c, new Node());
        	}
        	cur = cur.next.get(c);
        }
        
        if(!cur.isWord) {
        	cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root,word,0);
    }

	private boolean match(Node node, String word, int index) {
		
		if(index == word.length()) {
			return node.isWord;
		}
		
		char c = word.charAt(index);
		if( c != '.') {
			if(node.next.get(c) == null) {
				return false;
			}
			return match(node.next.get(c),word,index+1);
		}else {
			for (Character ch : node.next.keySet()) {
//				这样写万一第一个没有匹配到而第二个可以匹配到就会返回false
//				return match(node.next.get(ch), word, index+1);
				if(match(node.next.get(ch), word, index+1)) {
					return true;
				}
			}
			return false;
		}
	}
}
