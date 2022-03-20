package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			String s = br.readLine();
			for(int j=1; j<=M; j++) {
				map[i][j] = s.charAt(j-1)-'0';
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		boolean[][] visited = new boolean[N+1][M+1];
		visited[1][1] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		int cnt = 1;
		q.offer(new int[] {1,1});
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			
			for(int s=0; s<size; s++) {
				int[] poll = q.poll();
				
				for(int d=0; d<4; d++) {
					int x = poll[0] + deltas[d][0];
					int y = poll[1] + deltas[d][1];
					
					if(x==N && y==M) return cnt;
					
					if(x>=1 && y>=1 && x<=N && y<=M && map[x][y]==1 && !visited[x][y]) {
						q.offer(new int[] {x, y});
						visited[x][y] = true;
					}
				}
			}
		}
		
		return cnt;
	}
}
