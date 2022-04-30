package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17070 {
	static int N, map[][][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[4][N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.println(map[1][N-1][N-1] + map[2][N-1][N-1] + map[3][N-1][N-1]);
	}
	
	public static void solve() {
		map[1][0][1] = 1;
		
		for(int r=0; r<N; r++) {
			for(int c=1; c<N; c++) {
				if(map[1][r][c]>0) {
					if(c+1<N && map[0][r][c+1]==0) {
						map[1][r][c+1] += map[1][r][c];
					}
					if(r+1<N && c+1<N && map[0][r+1][c+1]==0 && map[0][r][c+1]==0 && map[0][r+1][c]==0) {
						map[3][r+1][c+1] += map[1][r][c];
					}
				}
				if(map[2][r][c]>0) {
					if(r+1<N && map[0][r+1][c]==0) {
						map[2][r+1][c] += map[2][r][c];
					}
					if(r+1<N && c+1<N && map[0][r+1][c+1]==0 && map[0][r][c+1]==0 && map[0][r+1][c]==0) {
						map[3][r+1][c+1] += map[2][r][c];
					}
				}
				if(map[3][r][c]>0) {
					if(c+1<N && map[0][r][c+1]==0) {
						map[1][r][c+1] += map[3][r][c];
					}
					if(r+1<N && map[0][r+1][c]==0) {
						map[2][r+1][c] += map[3][r][c];
					}
					if(r+1<N && c+1<N && map[0][r+1][c+1]==0 && map[0][r][c+1]==0 && map[0][r+1][c]==0) {
						map[3][r+1][c+1] += map[3][r][c];
					}
				}
			}
		}
	}
}
