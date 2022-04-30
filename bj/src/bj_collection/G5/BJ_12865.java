package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K;
	static int[][] dp, arr;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		dp = new int[N+1][K+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(dp());
	}
	
	public static int dp() {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				if(arr[i][0]>j) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i-1][j], arr[i][1]+dp[i-1][j-arr[i][0]]);
				}
			}
		}
		return dp[N][K];
	}
}
