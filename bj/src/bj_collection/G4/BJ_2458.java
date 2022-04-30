package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2458 {
	static int N, M;
	static final int INF = 10000000;
	static int[][] graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				
				graph[i][j] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int cnt = 0;
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
				}
			}
		}
		
		for(int k=1; k<=N; k++) {
			int sum = 0;
			for(int i=1; i<=N; i++){
				if(graph[k][i]!=INF && graph[k][i]!=0) {
					sum++;
				}
				if(graph[i][k]!=INF && graph[i][k]!=0) {
					sum++;
				}
			}
			
			if(sum==N-1) cnt++;
		}
		
		return cnt;
	}
}
