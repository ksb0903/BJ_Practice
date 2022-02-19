package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, maxH, minH, ans;
	static int[][] map, deltas = {{0,1},{1,0},{0,-1},{-1,0}};;
	static int[][] flood;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		flood = new int[N][N];
		maxH = Integer.MIN_VALUE;
		minH = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
				minH = Math.min(minH, map[i][j]);
			}
		}
		
		getMax();
		System.out.println(ans);
	}
	
	public static void getMax() {
		int idx = 0;
		
		for(int k=0; k<=maxH; k++) {
			int count = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]<=k) {
						flood[i][j] = -1;
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(flood[i][j]==idx) {
						getSafeArea(i, j, idx);
						count++;
					}
				}
			}
			ans = Math.max(ans, count);
			idx++;
		}
	}
	
	public static void getSafeArea(int i, int j, int idx) {
		flood[i][j] = idx+1;
		
		for(int d=0; d<4; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			
			if(ni>=0 && nj>=0 && ni<N && nj<N && flood[ni][nj]==idx) {
				getSafeArea(ni, nj, idx);
			}
		}
	}
}
