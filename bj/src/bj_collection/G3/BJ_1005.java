package bj_collection.G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1005 {
	
	static int N, K, W, time[], dp[], entry[];
	static ArrayList<ArrayList<Integer>> list;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			time = new int[N+1];
			entry = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<>());
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list.get(from).add(to);
				entry[to]++;
			}
			
			W = Integer.parseInt(br.readLine());
			
			solve();
			bw.write(dp[W] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void solve() {
		dp = new int[N+1];
		q = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(entry[i]==0) {
				q.offer(i);
				dp[i] = time[i];
			}
		}
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int next: list.get(poll)) {
				dp[next] = Math.max(dp[poll] + time[next], dp[next]);
				
				entry[next]--;
				
				if(entry[next]==0) {
					q.offer(next);
				}
			}
		}
	}
}
