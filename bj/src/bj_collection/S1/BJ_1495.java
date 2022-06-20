package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1495 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, S, M;
	static boolean dp[][];
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new boolean[N+1][M+1];
		dp[0][S] = true;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<=M; j++) {
				if(dp[i-1][j]) {
					int nv = j + v;
					if(nv<=M) dp[i][nv] = true;
					
					nv = j-v;
					if(nv>=0) dp[i][nv] = true;
				}
			}
		}
		
		int max = -1;
		for(int i=0; i<=M; i++) {
			if(dp[N][i]) {
				max = i;
			}
		}
		
		System.out.println(max);
	}
}
