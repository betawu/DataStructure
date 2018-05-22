package com.stack;

import java.util.Stack;

/**
 * 
 * @author beta
 *字符串括号的匹配
 */
public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch=='('||ch=='{'||ch=='[') {
				stack.push(ch);
			}else if(ch==')') {
				if(stack.isEmpty()) {
					return false;
				}
				Character top = stack.pop();
				if(top!='(') {
					return false;
				}
			}else if (ch=='}') {
				if(stack.isEmpty()) {
					return false;
				}
				Character top = stack.pop();
				if(top!='{') {
					return false;
				}
			}else if (ch==']') {
				if(stack.isEmpty()) {
					return false;
				}
				Character top = stack.pop();
				if(top!='[') {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		return true;
		
	}
}
