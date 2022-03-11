package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_11066 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] sums = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
			}
			
			int dp[][] = new int[N+1][N+1];
			for(int i=1; i<=N; i++) {
				for(int from=1; from<=N-i; from++) {
					int to = from+i;
					dp[from][to] = Integer.MAX_VALUE;
					for(int j=from; j<to; j++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][j] + dp[j+1][to] + sums[to] - sums[from-1]);
					}
				}
			}
			bw.write(dp[1][N]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
