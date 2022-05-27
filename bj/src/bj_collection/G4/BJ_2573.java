package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, map[][];
	static int deltas[][] = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
	}

	public static void solve() {
		int year = 0;
		
		while(true) {
			if(check()==1) {
				System.out.println(year);
				break;
			}else if(check()==-1) {
				System.out.println(0);
				break;
			}
			
			melt();
			
			year++;
		}
	}
	
	public static void melt() {
		int degree[][] = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]!=0) {
					for(int d=0; d<4; d++) {
						int ni = i + deltas[d][0];
						int nj = j + deltas[d][1];
						
						if(ni>=0 && nj>=0 && ni<N && nj<M && map[ni][nj]==0) {
							degree[i][j]++;
						}
					}
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = Math.max(0, map[i][j] - degree[i][j]);
			}
		}
	}
	
	public static int check() {
		// 한 덩어리면 0, 두 덩어리 이상이면 1, 전부 녹았으면 -1 리턴
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] > 0){
					return bfs(i, j);
				}
			}
		}
		
		return -1;
	}
	
	public static int bfs(int i, int j) {
		boolean isLump[][] = new boolean[N][M];
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {i, j});
		isLump[i][j] = true;
		
		while(!q.isEmpty()) {
			int[] poll = q.poll();
			int x = poll[0];
			int y = poll[1];
			
			for(int d=0; d<4; d++) {
				int nx = x + deltas[d][0];
				int ny = y + deltas[d][1];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]>0 && !isLump[nx][ny]) {
					q.offer(new int[] {nx, ny});
					isLump[nx][ny] = true;
				}
			}
		}
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<M; y++) {
				if(map[x][y]>0) {
					if(!isLump[x][y]) return 1;
				}
			}
		}
		
		return 0;
	}
}
