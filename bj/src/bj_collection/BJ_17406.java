package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_17406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, K;
	static int min = Integer.MAX_VALUE;
	static int[][] arr, arr2, rcs, copy;
	static boolean[] visited;
	static int[] select;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1];
		arr2 = new int[N+1][M+1];
		copy = new int[N+1][M+1];
		rcs = new int[K][3]; // 회전 연산 r, c, s
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				rcs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	
	public static void solve() {
		visited = new boolean[K];
		select = new int[K];
		perm(0); // kPk 순열
	}
	
	public static void perm(int cnt) {
		if(cnt==K) {
			// idx 배열 받고 해당 순서대로 연산
			for(int i=1; i<=N; i++) {
				System.arraycopy(arr[i], 0, arr2[i], 0, arr[0].length);
			}
			
			
			for(int i=0; i<K; i++) {
				operation(rcs[select[i]]);
			}
			getMin();
			return;
		}
		
		for(int i=0; i<K; i++) {
			if(visited[i]) continue;
			
			select[cnt] = i;
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void operation(int[] cmd) {
		// 회전 연산
		int r = cmd[0];
		int c = cmd[1];
		int s = cmd[2];
		int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
		for(int i=1; i<=N; i++) {
			System.arraycopy(arr2[i], 0, copy[i], 0, arr2[0].length);
		}
		
		for(int i=0; i<s; i++) {
			int idx=0;
			int x = r-s+i;
			int y = c-s+i;
			
			while(idx<4) {
				int nx = x+deltas[idx][0];
				int ny = y+deltas[idx][1];
				
				if(nx<=r+s-i && ny<=c+s-i && nx>=r-s+i && ny>=c-s+i) {
					copy[nx][ny] = arr2[x][y];
					x = nx;
					y = ny;
				}else idx++;
			}
		}
		
		for(int i=1; i<=N; i++) {
			System.arraycopy(copy[i], 0, arr2[i], 0, copy[0].length);
		}
	}
	
	public static void getMin() {
		for(int i=1; i<=N; i++) {
			int sum=0;
			for(int j: arr2[i]) {
				sum+=j;
			}
			
			min = sum<min? sum: min;
		}
	}
}
