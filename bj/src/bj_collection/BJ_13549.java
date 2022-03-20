package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_13549 {
	static int visit[] = new int[100001];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Arrays.fill(visit, -1);
		bfs(N, K);
		System.out.println(visit[K]);
	}
	
	public static void bfs(int n, int k) {
		LinkedList<Integer> dq = new LinkedList<>();
		dq.offer(n);
		visit[n] = 0;
		
		while(!dq.isEmpty()) {
			int poll = dq.poll();
			
			if(poll==k) return;
			
			if(poll<=50000 && visit[poll*2]==-1) {
				dq.addFirst(poll*2);
				visit[poll*2] = visit[poll];
			}
			
			if(poll>0 && visit[poll-1]==-1) {
				dq.offer(poll-1);
				visit[poll-1] = visit[poll] + 1;
			}
			
			if(poll<100000 && visit[poll+1]==-1) {
				dq.offer(poll+1);
				visit[poll+1] = visit[poll] + 1;
			}
		}
	}
}
