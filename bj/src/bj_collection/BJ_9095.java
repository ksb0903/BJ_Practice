package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_9095 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			if(N==1) {
				bw.write("1"+"\n");
				continue;
			}
			if(N==2) {
				bw.write("2"+"\n");
				continue;
			}
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i=4; i<=N; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			bw.write(String.valueOf(dp[N]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
