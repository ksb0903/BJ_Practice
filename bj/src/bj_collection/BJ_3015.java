package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_3015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static long res;
	static int[] people;
	
	public static void main(String[] args) throws IOException{
		Stack<int[]> stack = new Stack<>();
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		for(int i=0; i<N; i++) {
			people[i] = Integer.parseInt(br.readLine());
		}
		
		stack.push(new int[] {people[0], 1});
		for(int i=1; i<N; i++) {
			while(!stack.isEmpty() && stack.peek()[0]<people[i]) {
				res += stack.pop()[1];
			}
			
			if(stack.isEmpty()) stack.push(new int[] {people[i], 1});
			else {
				if(stack.peek()[0]==people[i]) {
					int sameCnt = stack.pop()[1];
					res += sameCnt;
					
					if(!stack.isEmpty()) res++;
					
					stack.push(new int[] {people[i], sameCnt+1});
				}else {
					stack.push(new int[] {people[i], 1});
					res++;
				}
			}
		}
		
		System.out.println(res);
	}
}
