package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1577 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, K;
	static long[][] dp;
	static int[][][] map;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		dp = new long[N+1][M+1];
		map = new int[N+1][M+1][2];
		dp[0][0] = 1;
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if(x1==x2) {
				if(y2<y1) map[x2][y2][0] = 1; //가로
				else map[x1][y1][0] = 1;
			}
			else{
				if(x2<x1) map[x2][y2][1] = 1; //세로
				else map[x1][y1][1] = 1;
			}
		}
		solve();
		System.out.println(dp[N][M]);
	}
	
	public static void solve() {
		for(int i=0; i<=N; i++) {
			for(int j=0; j<=M; j++) {
				if(i==0 && j==0) continue;
				
				if(i!=0 && j==0) {
					if(map[i-1][j][1] != 1) dp[i][j] = dp[i-1][j];
				}else if(i==0 && j!=0) {
					if(map[i][j-1][0] != 1) dp[i][j] = dp[i][j-1];
				}else {
					if(map[i-1][j][1] != 1) dp[i][j] += dp[i-1][j];
					if(map[i][j-1][0] != 1) dp[i][j] += dp[i][j-1];
				}
			}
		}
	}
}
