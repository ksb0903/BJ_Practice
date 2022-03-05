package bj_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int time = 0, size = 0;
		boolean[] visited = new boolean[100001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		
		outer: while(true) {
			size = q.size();
			
			for(int i=0; i<size; i++) {
				int pos = q.poll();
				if(pos==K) break outer;
				if(visited[pos]) continue;
				visited[pos] = true;
				
				if(pos+1<=100000)
					q.offer(pos+1);
				if(pos-1>=0)
					q.offer(pos-1);
				if(pos*2<=100000)
					q.offer(pos*2);
			}
			++time;
		}
		
		System.out.println(time);
	}
}
