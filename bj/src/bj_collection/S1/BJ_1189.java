package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1189 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, K, res, deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static char map[][];
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		map[R-1][0] = 'T';
		solve(R-1, 0, 1);
		System.out.println(res);
	}
	
	public static void solve(int r, int c, int dist) {
		if(r==0 && c==C-1) {
			if(dist==K) res++;
			
			return;
		}
		
		if(dist==K) return;
		
		for(int d=0; d<4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]!='T') {
				map[nr][nc] = 'T';
				solve(nr, nc, dist+1);
				map[nr][nc] = '.';
			}
		}
	}
}
