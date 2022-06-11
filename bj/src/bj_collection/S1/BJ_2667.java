package bj_collection.S1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2667 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N, map[][], deltas[] = {-1,0,1,0,-1};
	static ArrayList<Integer> count;

	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		count = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				int x = (int)(s.charAt(j)-'0');
				map[i][j] = x;
			}
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(count);
		for(int i: count) {
			System.out.println(i);
		}
	}
	
	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {r, c});
		int cnt = 1;
		map[r][c] = -1;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d];
				int ny = y + deltas[d+1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]==1) {
					q.offer(new int[] {nx, ny});
					map[nx][ny] = -1;
					cnt++;
				}
			}
		}
		
		count.add(cnt);
	}
}
