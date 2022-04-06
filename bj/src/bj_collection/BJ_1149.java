package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int house[][] = new int[N][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			house[i][0] = r;
			house[i][1] = g;
			house[i][2] = b;
		}
		
		System.out.println(solve(N, house));
	}
	
	public static int solve(int N, int[][] house) {
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<N; i++) {
			house[i][0] = Math.min(house[i-1][1], house[i-1][2]) + house[i][0];
			house[i][1] = Math.min(house[i-1][0], house[i-1][2]) + house[i][1];
			house[i][2] = Math.min(house[i-1][0], house[i-1][1]) + house[i][2];
		}
		
		min = Math.min(house[N-1][0], house[N-1][1]);
		return Math.min(min, house[N-1][2]);
	}
}
