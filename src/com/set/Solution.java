package com.set;

import java.util.TreeSet;

/**
 * 
 * @author beta
 *莫斯密码
 */
public class Solution {
	public int uniqueMorseRepresentations(String[] words) {
		String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for (String s : words) {
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<s.length();i++) {
				sb.append(code[s.charAt(i)-'a']);
			}
			set.add(sb.toString());
		}
        return set.size();
    }
}
