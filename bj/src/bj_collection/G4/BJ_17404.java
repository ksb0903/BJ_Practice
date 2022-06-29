package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17404 {
	
	static int N, house[][], dp[][];
	static final int INF = 10000000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		house = new int[N][3];
		dp = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			house[i][0] = r;
			house[i][1] = g;
			house[i][2] = b;
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int min = INF;
		
		for(int j=0; j<3; j++) {
			for(int i=0; i<3; i++) {
				if(i==j) dp[0][i] = house[0][i];
				else dp[0][i] = INF;
			}
		
			for(int i=1; i<N; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0];
				dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2];
			}
			
			for(int i=0; i<3; i++) {
				if(i!=j) min = Math.min(min, dp[N-1][i]);
			}
		}
		
		
		return min;
	}
}