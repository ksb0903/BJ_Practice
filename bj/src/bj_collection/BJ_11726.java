package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, r=10007;
	static int[] dp;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		dp = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-2] + dp[i-1])%10007;
		}
		System.out.println(dp[N]%10007);
	}
}
