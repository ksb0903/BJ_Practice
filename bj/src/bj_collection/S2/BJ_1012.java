package bj_collection.S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K;
	static int[][] map;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			q = new LinkedList<>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y] = 1;
				q.offer(new int[] {x, y});
			}
			
			bw.write(solve() + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static int solve() {
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			if(bfs(point)) cnt++;
		}
			
		return cnt;
	}
	
	public static boolean bfs(int[] point) {
		if(map[point[0]][point[1]]==-1) return false;
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		Queue<int[]> qq = new LinkedList<>();
		qq.offer(point);
		
		while(!qq.isEmpty()) {
			int[] p = qq.poll();
			for(int d=0; d<4; d++) {
				int x = p[0] + deltas[d][0];
				int y = p[1] + deltas[d][1];
				
				if(x>=0 && y>=0 && x<N && y<M && map[x][y]==1) {
					map[x][y]=-1;
					qq.offer(new int[] {x, y});
				}
			}
		}
		
		return true;
	}
}
