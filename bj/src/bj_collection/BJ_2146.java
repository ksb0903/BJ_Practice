package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2146 {
	
	static int N, map[][];
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve());
	}
	
	public static int solve() {
		int idx = -1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					findIsland(i, j, idx);
					idx--;
				}
			}
		}
		
		int islandCnt = -(idx+1);
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=islandCnt; i++) {
			min = Math.min(min, makeBridge(-i));
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]>0) map[r][c]=0;
				}
			}
		}
		
		return min;
	}
	
	public static int makeBridge(int idx) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q= new LinkedList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==idx) {
					q.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		int size = 0;
		int dist = 0;
		while(!q.isEmpty()) {
			size = q.size();
			dist++;
			while(size>0) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
						if(map[nx][ny]==0) {
							map[nx][ny] = dist;
							visited[nx][ny] = true;
							q.offer(new int[] {nx, ny});
						}else {
							return map[x][y];
						}
					}
				}
				--size;
			}
		}
		
		return -1;
	}
	
	public static void findIsland(int r, int c, int idx) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});
		visited[r][c] = true;
		map[r][c] = idx;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny] && map[nx][ny]==1) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					map[nx][ny] = idx;
				}
			}
		}
	}
}
