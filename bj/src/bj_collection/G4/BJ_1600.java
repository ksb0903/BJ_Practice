package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {
	static int K, W, H;
	static int[][] map;
	
	static class Monkey{
		int x, y, k;

		public Monkey(int x, int y, int k) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		if(W==1 && H==1) return 0;
		
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int[][] horse = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,-2},{2,-1},{1,2},{2,1}};
		
		boolean[][][] visited = new boolean[K+1][H][W];
		Queue<Monkey> q = new LinkedList<Monkey>();
		q.offer(new Monkey(0, 0, K));
		visited[K][0][0] = true;
		int size = 0;
		int dist = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			++dist;
			
			while(size>0) {
				Monkey monkey = q.poll();
				int x = monkey.x;
				int y = monkey.y;
				int k = monkey.k;
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>=0 && ny>=0 && nx<H && ny<W && !visited[k][nx][ny] && map[nx][ny]==0) {
						if(nx==H-1 && ny==W-1) return dist;
						
						visited[k][nx][ny] = true;
						q.offer(new Monkey(nx, ny, k));
					}
				}
				
				if(k>0) {
					for(int h=0; h<8; h++) {
						int hx = x + horse[h][0];
						int hy = y + horse[h][1];
						
						if(hx>=0 && hy>=0 && hx<H && hy<W && !visited[k-1][hx][hy] && map[hx][hy]==0) {
							if(hx==H-1 && hy==W-1) return dist;
							
							visited[k-1][hx][hy] = true;
							q.offer(new Monkey(hx, hy, k-1));
						}
					}
				}
				
				--size;
			}
		}
		
		return -1;
	}
}
