package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Point implements Comparable<Point>{
		int x, y, d;

		public Point(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Point o) {
			if(d==o.d) {
				if(x==o.x) {
					return Integer.compare(y, o.y);
				}
				return Integer.compare(x, o.x);
			}
			return Integer.compare(d, o.d);
		}
	}
	static int [][] map;
	static boolean[][] visited;
	static int N, bi, bj, minD, bSize;
	static int[][] dir = {
			{-1, 0},
			{0, -1},
			{0, 1},
			{1, 0}
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==9) {
					bi = i; //아기 상어 초기 위치
					bj = j;
					bSize = 2; // 아기 상어 초기 크기
				}
				map[i][j] = a; // map 저장
			}
		}
		
		int result = 0;
		int exp = 0;
		PriorityQueue<Point> pq;
		while(true) {
			
			// 먹을 수 있는 먹이들과의 거리 탐색
			pq = new PriorityQueue<>();
			minD = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			visited[bi][bj] = true;
			boolean flag = false;
			
			pq.offer(new Point(bi,bj, 0));
			
			while(!pq.isEmpty()) {
				Point p = pq.poll();
				
				visited[p.x][p.y] = true;
				
				if(map[p.x][p.y]!=0&&map[p.x][p.y]<bSize) { // 가장 가까운 먹이 발견
					//먹이를 먹으러 이동함
					map[bi][bj] = 0;
					map[p.x][p.y] = 9;
					result+=p.d; 
					bi = p.x;
					bj = p.y;
					flag = true; // 먹이를 먹음
					if(++exp==bSize) { //크기만큼 물고기 먹으면 사이즈 업
						bSize++;
						exp = 0;
					}
					break;
				}
				
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dir[d][0];
					int ny = p.y + dir[d][1];
					
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]&& map[nx][ny] <= bSize) { // 이동할 곳 물고기가 상어보다 크면 안됨
						int nd = p.d+1;
						visited[nx][ny] = true;
						pq.offer(new Point(nx, ny, nd));
					}

				}
			}
			
			// 먹을 수 있는 물고기가 없음
			if(!flag)break;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}