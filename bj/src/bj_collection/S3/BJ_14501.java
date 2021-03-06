package bj_collection.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] t = new int[N+2];
		int[] p = new int[N+2];
		int[] dp = new int[21];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=N+1; i++) {
			dp[i] = Math.max(max, dp[i]);
			dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
