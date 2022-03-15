package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21610 {
	static int N, M;
	static int map[][][], cmd[][];
	static Queue<int[]> q, magicq;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[2][N+1][N+1];
		cmd = new int[M][2];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			cmd[i][0] = Integer.parseInt(st.nextToken());
			cmd[i][1] = Integer.parseInt(st.nextToken());
		}
		
		solve();
	}
	
	public static void solve() {
		q = new LinkedList<int[]>();
		magicq = new LinkedList<int[]>();
		q.offer(new int[] {N-1,1});
		q.offer(new int[] {N-1,2});
		q.offer(new int[] {N,1});
		q.offer(new int[] {N,2});
		
		for(int i=0; i<M; i++) {
			moveCloud(cmd[i], i+1);
			magic();
			makeCloud(i+1);
		}
		
		System.out.println(getWater());
	}
	
	public static void moveCloud(int[] cmd, int idx) {
		int d = cmd[0];
		int s = cmd[1];
		int deltas[][] = {{0,0},{0,s*-1},{s*-1,s*-1},{s*-1,0},{s*-1,s},{0,s},{s,s},{s,0},{s,s*-1}};
				
		while(!q.isEmpty()) {
			int[] cloud = q.poll();
			int x = cloud[0] + deltas[d][0];
			int y = cloud[1] + deltas[d][1]; 
			
			if(x>N) {
				while(x>N) x -= N;
			}else if(x<=0) {
				while(x<=0) x += N;
			}
			if(y>N) {
				while(y>N) y -= N;
			}else if(y<=0) {
				while(y<=0) y += N;
			}
			
			map[0][x][y]++;
			map[1][x][y] = idx;
			magicq.offer(new int[] {x, y});
		}
	}
	
	public static void magic() {
		int deltas[][] = {{1,1},{1,-1},{-1,1},{-1,-1}};
		int check[][] = new int[N+1][N+1];
		
		while(!magicq.isEmpty()) {
			int[] poll = magicq.poll();
			int x = poll[0];
			int y = poll[1];
			int cnt = 0;
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=1 && ny>=1 && nx<=N && ny<=N) {
					if(map[0][nx][ny] != 0) cnt++;
				}
			}
			
			check[x][y] += cnt;
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[0][i][j] += check[i][j];
			}
		}
	}
	
	public static void makeCloud(int idx) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(map[0][i][j]>=2 && map[1][i][j]!=idx) {
					map[0][i][j] -= 2;
					q.offer(new int[] {i,j});
				}
			}
		}
	}
	
	public static int getWater() {
		int res = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				res += map[0][i][j];
			}
		}
		return res;
	}
}
