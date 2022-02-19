package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ_16637 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<Character> list = new ArrayList<>();
	static boolean[] operator;
	static int N, max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		/*연산자 subset을 짬, 단, 첫 번째 연산자는 제외
		 * i번째 연산자가 선택됐으면 i+1번째 연산자도 제외*/
		N = Integer.parseInt(br.readLine());
		operator = new boolean[N/2];
		String s = br.readLine();
		for(int i=0; i<N; i++) {
			list.add(s.charAt(i));
		}
		
		subset(0);
		System.out.println(max);
	}
	
	public static void subset(int cnt) {
		if(cnt==N/2) {
			ArrayList<Character> copy = (ArrayList<Character>)list.clone();
			for(int i=(N/2)-1; i>=0; i--) {
				if(operator[i]==true) {
					copy.add(2*i+3, ')');
					copy.add(2*i, '(');
				}
			}
			String postfix = makePostfix(copy);
			int res = getResult(postfix);
			max = Math.max(res, max);
			return;
		}
		
		if(cnt==0 || operator[cnt-1]==true) {
			operator[cnt] = false;
			subset(cnt+1);
		}else {
			operator[cnt] = true;
			subset(cnt+1);
			operator[cnt] = false;
			subset(cnt+1);
		}
	}
	
	public static int getResult(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0, size=postfix.length(); i<size; i++) {
			if(postfix.charAt(i)=='+') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			}else if(postfix.charAt(i)=='-') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			}else if(postfix.charAt(i)=='*') {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}else {
				stack.push((int)(postfix.charAt(i)-'0'));
			}
		}
		
		return stack.pop();
	}
	
	public static String makePostfix(ArrayList<Character> infix) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		
		for(int i=0, size=infix.size(); i<size; i++) {
			if(infix.get(i)=='(') {
				stack.push('(');
			}else if(infix.get(i)==')') {
				while(!stack.isEmpty() && stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}else if(infix.get(i)=='*'||infix.get(i)=='+'||infix.get(i)=='-'){
				while(!stack.isEmpty() && stack.peek()!='(') {
					sb.append(stack.pop());
				}
				stack.push(infix.get(i));
			}else {
				sb.append(infix.get(i));
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
	}
}
