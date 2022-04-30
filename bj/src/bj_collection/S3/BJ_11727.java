package bj_collection.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11727 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int r = 10007;
	static int[] dp = new int[1001];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1]%r + dp[i-2]*2%r;
		}
		System.out.println(dp[N]%r);
	}
}
