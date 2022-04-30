package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1520 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int M, N;
	static int[][] map, dp, deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(getRoute(0, 0));
	}
	
	public static int getRoute(int x, int y) {
		if(x==M-1 && y==N-1) return 1;
		dp[x][y] = 0;
		
		for(int d=0; d<4; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx>=0 && ny>=0 && nx<M && ny<N && map[x][y]>map[nx][ny]) {
				if(dp[nx][ny]==-1) {
					dp[x][y] += getRoute(nx, ny);
				}else {
					dp[x][y] += dp[nx][ny];
				}
			}
		}
		
		return dp[x][y];
	}
}
