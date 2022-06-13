package bj_collection.S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_15988 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	static long[] dp = new long[1000001];
	static final int MOD = 1000000009;

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			if(dp[n]!=0) {
				bw.write(dp[n] + "\n");
			}else {
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;
				
				for(int i=4; i<=n; i++) {
					dp[i] = (dp[i-3] + dp[i-2] + dp[i-1]) % MOD;
				}
				
				bw.write(dp[n] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}
