package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1194 {
	static int N, M;
	static char[][] map;
	static boolean[][][] visited;
	
	static class Minsik{
		int x, y;
		int key;
		
		public Minsik(int x, int y, int key) {
			super();
			this.x = x;
			this.y = y;
			this.key = key;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		Queue<Minsik> q = new LinkedList<Minsik>();
		visited = new boolean[1<<6][N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='0') {
					q.offer(new Minsik(i, j, 0));
					map[i][j] = '.';
					visited[0][i][j] = true;
				}
			}
		}
		
		System.out.println(solve(q));
	}
	
	public static int solve(Queue<Minsik> q) {
		int deltas[][] = {{0,1},{1,0},{-1,0},{0,-1}};
		int size = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			++cnt;
			
			while(size>0) {
				Minsik now = q.poll();
				int x = now.x;
				int y = now.y;
				int key = now.key;
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[key][nx][ny] && map[nx][ny]!='#') {
						if(map[nx][ny]=='1') {
							return cnt;
						}else if(map[nx][ny]=='.'){
							q.offer(new Minsik(nx, ny, key));
							visited[key][nx][ny] = true;
						}else if(map[nx][ny]>='A' && map[nx][ny]<='F') {
							if(checkKey(key, map[nx][ny])) {
								q.offer(new Minsik(nx, ny, key));
								visited[key][nx][ny] = true;
							}
						}else if(map[nx][ny]>='a' && map[nx][ny]<='f') {
							int newKey = getKey(key, map[nx][ny]);
							q.offer(new Minsik(nx, ny, newKey));
							visited[newKey][nx][ny] = true;
						}
					}
				}
				--size;
			}
		}
		
		return -1;
	}
	
	public static int getKey(int key, char c) {
		int n = 1<<(int)(c - 'a');
		
		return key|n;
	}
	
	public static boolean checkKey(int key, char c) {
		int n = 1<<(int)(c - 'A');
		
		return ((key&n) == 0)? false: true;
	}
}
