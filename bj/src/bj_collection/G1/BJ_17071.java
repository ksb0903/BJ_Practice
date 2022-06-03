package bj_collection.G1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_17071 {
	static int N, K;
	static boolean visit[][];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		visit = new boolean[500001][2];
		
		if(N==K) System.out.println(0);
		else System.out.println(search());
		
		sc.close();
	}
	
	public static int search() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(N);
		visit[N][0] = true;
		int time = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			K = K + time;
			
			if(K>500000) return -1;
			if(visit[K][time%2]) return time;
			
			while(size>0) {
				int poll = q.poll();
				
				if(poll<=250000 && !visit[poll*2][(time+1)%2]) {
					visit[poll*2][(time+1)%2] = true;
					q.offer(poll*2);
				}
				
				if(poll<500000 && !visit[poll+1][(time+1)%2]) {
					visit[poll+1][(time+1)%2] = true;
					q.offer(poll+1);
				}
				
				if(poll>0 && !visit[poll-1][(time+1)%2]) {
					visit[poll-1][(time+1)%2] = true;
					q.offer(poll-1);
				}
				
				size--;
			}
			
			time++;
		}
		
		return -1;
	}
}
