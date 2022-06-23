package bj_collection.G1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13460 {
	
	static class Board{
		int rx, ry, bx, by, cnt;

		public Board(int rx, int ry, int bx, int by, int cnt) {
			super();
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.cnt = cnt;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M;
	static char[][] map;
	static boolean[][][][] visited;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		int[] init = new int[4];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j]=='R') {
					init[0] = i;
					init[1] = j;
				}else if(map[i][j]=='B') {
					init[2] = i;
					init[3] = j;
				}
			}
		}
		
		System.out.println(bfs(init));
	}
	
	public static int bfs(int[] init) {
		int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<Board> q = new LinkedList<Board>();
		q.add(new Board(init[0], init[1], init[2], init[3], 1));
		visited[init[0]][init[1]][init[2]][init[3]] = true;
		
		while(!q.isEmpty()) {
			Board poll = q.poll();
			
			int rx = poll.rx;
			int ry = poll.ry;
			int bx = poll.bx;
			int by = poll.by;
			int cnt = poll.cnt;

			if(cnt>10) return -1;
			
			for(int d=0; d<4; d++) {
				int nrx = rx;
				int nry = ry;
				int nbx = bx;
				int nby = by;
				
				boolean redHole = false;
				boolean blueHole = false;
				
				while(map[nrx+deltas[d][0]][nry+deltas[d][1]]!='#') {
					nrx += deltas[d][0];
					nry += deltas[d][1];
					
					if(map[nrx][nry]=='O') {
						redHole = true;
						break;
					}
				}
				
				while(map[nbx+deltas[d][0]][nby+deltas[d][1]]!='#') {
					nbx += deltas[d][0];
					nby += deltas[d][1];
					
					if(map[nbx][nby]=='O') {
						blueHole = true;
						break;
					}
				}
				
				if(blueHole) continue;
				
				if(redHole) return cnt;
				
				if(nrx==nbx && nry==nby) {
					switch(d) {
					case 0:
						if(ry>by) nby--;
						else nry--;
						break;	
					case 1:
						if(rx>bx) nbx--;
						else nrx--;
						break;
					case 2:
						if(ry>by) nry++;
						else nby++;
						break;
					case 3:
						if(rx>bx) nrx++;
						else nbx++;
						break;
					}
				}
				
				if(!visited[nrx][nry][nbx][nby]) {
					visited[nrx][nry][nbx][nby] = true;
					q.add(new Board(nrx, nry, nbx, nby, cnt+1));
				}
			}
		}
		
		return -1;
	}
}
