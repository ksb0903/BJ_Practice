package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static boolean[][][] visited;
	static int[][] deltas = {{0,1},{0,-1},{1,0},{-1,0}};
	
	static class Player {
		int r, c, depth;
		boolean flag;
		
		public Player(int r, int c, int depth, boolean flag) {
			super();
			this.r = r;
			this.c = c;
			this.depth = depth;
			this.flag = flag;
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = line[j]-'0';
			}
		}
		bw.write(bfs(0, 0, 1, true)+"");
		bw.flush();
		bw.close();
	}
	
	public static int bfs(int r, int c, int d, boolean b) {
		Queue<Player> queue = new LinkedList<Player>();
		queue.offer(new Player(r, c, d, b));
		
		while(!queue.isEmpty()) {
			Player p = queue.poll();
			if(p.r==N-1 && p.c==M-1) {
				return p.depth;
			}
			
			for(int i=0; i<4; i++) {
				int nr = p.r + deltas[i][0];
				int nc = p.c + deltas[i][1];
				
				if(nr>=0 && nc>=0 && nr<N && nc<M) {
					if(map[nr][nc]==0) {
						if(p.flag && !visited[nr][nc][0]) {
							queue.offer(new Player(nr, nc, p.depth+1, true));
							visited[nr][nc][0]=true;
						}else if(!p.flag && !visited[nr][nc][1]) {
							queue.offer(new Player(nr, nc, p.depth+1, false));
							visited[nr][nc][1]=true;
						}
					}else {
						if(p.flag) {
							queue.add(new Player(nr, nc, p.depth+1, false));
							visited[nr][nc][1]=true;
						}
					}
				}
			}
		}
		return -1;
	}
}
