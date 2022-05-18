package bj_collection.S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3184 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int R, C, sCnt, wCnt, deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	static char map[][];
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String s = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j]=='v') wCnt++;
				if(map[i][j]=='o') sCnt++;
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]!='#') {
					solve(i, j);
				}
			}
		}
		
		System.out.print(sCnt + " " + wCnt);
	}
	
	public static void solve(int r, int c) {
		int sCntLocal = 0;
		int wCntLocal = 0;
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});
		if(map[r][c]=='v') {
			wCntLocal++;
		}else if(map[r][c]=='o') {
			sCntLocal++;
		}
		map[r][c] = '#';
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<R && ny<C && map[nx][ny]!='#') {
					if(map[nx][ny]=='.') {
						map[nx][ny]='#';
						q.offer(new int[] {nx, ny});
					}else if(map[nx][ny]=='v') {
						map[nx][ny]='#';
						q.offer(new int[] {nx, ny});
						wCntLocal++;
					}else if(map[nx][ny]=='o') {
						map[nx][ny]='#';
						q.offer(new int[] {nx, ny});
						sCntLocal++;
					}
				}
			}
		}
		
		if(wCntLocal>=sCntLocal) {
			sCnt -= sCntLocal;
		}else {
			wCnt -= wCntLocal;
		}
	}
}
