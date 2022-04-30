package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16948 {
	
	static int N, res = -1, del[][] = {{-2,-1},{-2,1},{0,-2},{0,2},{2,-1},{2,1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		bfs(r1, c1, r2, c2);
		System.out.println(res);
	}
	
	public static void bfs(int r1, int c1, int r2, int c2) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r1, c1});
		visited[r1][c1] = true;
		
		int size = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			cnt++;
			while(size>0) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				
				for(int d=0; d<6; d++) {
					int nx = x + del[d][0];
					int ny = y + del[d][1];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N && !visited[nx][ny]) {
						if(nx==r2 && ny==c2) {
							res = cnt;
							return;
						}
						
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
					}
				}
				size--;
			}
		}
	}
}
