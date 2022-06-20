package bj_collection.S5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			q.offer(i);
		}
		
		Queue<Integer> res = new LinkedList<>();
		int idx = 1;
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(idx%K==0) {
				res.offer(poll);
			}else {
				q.offer(poll);
			}
			
			idx++;
		}
		
		System.out.print("<");
		
		for(int i=0; i<N-1; i++) {
			System.out.print(res.poll() + ", ");
		}
		
		System.out.print(res.poll() + ">");
	}
}
