package bj_collection.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_1918 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] infix = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		StringBuilder postfix = new StringBuilder();
		
		for(int i=0; i<infix.length; i++) {
			switch(infix[i]) {
			case '(':
				stack.push(infix[i]);
				break;
			case ')':
				while(stack.peek()!='(') {
					postfix.append(stack.pop());
				}
				stack.pop();
				break;
			case '*':
			case '/':
				while(!stack.isEmpty() && (stack.peek()=='*' || stack.peek()=='/')) {
					postfix.append(stack.pop());
				}
				stack.push(infix[i]);
				break;
			case '+':
			case '-':
				while(!stack.isEmpty() && (stack.peek()=='+' || stack.peek()=='-' || stack.peek()=='*' || stack.peek()=='/')) {
					postfix.append(stack.pop());
				}
				stack.push(infix[i]);
				break;
			default:
				postfix.append(infix[i]);
				break;
			}
		}
		while(!stack.isEmpty()) {
			postfix.append(stack.pop());
		}
		System.out.println(postfix.toString());
	}
}
