package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2533 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] dp;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		solve(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	
	public static void solve(int n) {
		visited[n] = true;
		dp[n][0] = 0;
		dp[n][1] = 1;
		
		for(int i: graph.get(n)) {
			if(visited[i]) continue;
			solve(i);
			dp[n][0] += dp[i][1];
			dp[n][1] += Math.min(dp[i][0], dp[i][1]);
		}
	}
}
