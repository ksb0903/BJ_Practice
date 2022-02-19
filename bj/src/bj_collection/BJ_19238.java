package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, fuel;
	static int[][] map;
	static boolean[][] visited;
	static Passenger[] psg;
	static Taxi taxi;
	static Queue<Passenger> queue;
	static int[][] deltas = {{-1,0},{0,-1},{1,0},{0,1}};
	
	/*	1. 택시에서 가장 가까운 승객 찾기(bfs, 거리가 같으면 0,0에 가까운 승객)
		2. 목적지까지 거리 계산(bfs)
		3. 연료가 거리보다 많으면 택시를 목적지로 이동, 거리*2 만큼 연료 추가
		4. 1~3 반복
		5. 남은 연료 출력
		6. 연료가 거리보다 적으면 -1 출력, 종료
	*/ 
	
	static class Taxi{
		private int x;
		private int y;
		private int fuel;
		
		public Taxi(int x, int y, int fuel) {
			this.x = x;
			this.y = y;
			this.fuel = fuel;
		}
	}
	
	static class Passenger implements Comparable<Passenger>{
		private int x;
		private int y;
		private int endX;
		private int endY;
		private int distance;
		
		public Passenger(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		public Passenger(int x, int y, int endX, int endY, int distance) {
			this.x = x;
			this.y = y;
			this.endX = endX;
			this.endY = endY;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Passenger p) {
			if(this.x>p.x) {
				return 1;
			}else if(this.x==p.x) {
				if(this.y>p.y) {
					return 1;
				}
			}
			return -1;
		}
	}
	
	public static void main(String[] args) throws IOException{
		inputProcess();
		mainProcess();
	}
	
	public static void mainProcess() {
		Arrays.sort(psg);
		for(int i=0; i<M; i++) {
			int[] tp = findPassenger(taxi.x, taxi.y, 0);
			//int[] tp = findPassenger(psg);
			if(tp[0]==-1) {
				taxi.fuel = -1;
				break;
			}
			taxi.fuel -= tp[0];
			Passenger p = psg[tp[1]];
			int useFuel = bfs(p.x, p.y, p.endX, p.endY, p.distance);
			taxi.fuel -= useFuel;
			if(taxi.fuel<0) {
				taxi.fuel = -1;
				break;
			}
			psg[tp[1]].x = -1;
			psg[tp[1]].y = -1;
			taxi.x = p.endX;
			taxi.y = p.endY;
			taxi.fuel += useFuel*2;
		}
		System.out.println(taxi.fuel);
	}
	
	public static int[] findPassenger(int x, int y, int d) {
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited[i], false);
		}
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		visited[x][y] = true;
		queue = new LinkedList<>();
		queue.offer(new Passenger(x, y, d));
		
		while(!queue.isEmpty()) {
			Passenger t = queue.poll();
			for(int i=0; i<M; i++) {
				if(t.x==psg[i].x && t.y==psg[i].y) {
					if(min>t.distance) {
						min = t.distance;
						minIdx = i;
					}else if(min==t.distance) {
						minIdx = Math.min(i, minIdx);
					}
				}
			}
			
			for(int i=0; i<4; i++) {
				int nx = t.x + deltas[i][0];
				int ny = t.y + deltas[i][1];
				
				if(nx>0 && ny>0 && nx<=N && ny<=N) {
					if(map[nx][ny]==0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Passenger(nx, ny, t.distance+1));
					}
				}
			}
		}
		
			
		if(minIdx==-1) return new int[] {-1, -1};
		else return new int[] {min, minIdx};
		
		/*int min = Integer.MAX_VALUE;
		int minIdx = 0;
		for(int i=0; i<M; i++) {
			if(p[i].x==-1) continue;
			int dist = bfs(taxi.x, taxi.y, p[i].x, p[i].y, 0);
			if(dist==-1) return new int[] {-1, -1};
			if(min>dist) {
				min = dist;
				minIdx = i;
			}
		}
		
		return new int[] {min, minIdx};*/
	}
	
	public static int bfs(int x, int y, int ex, int ey, int d) {
		for(int i=1; i<=N; i++) {
			Arrays.fill(visited[i], false);
		}
		visited[x][y]=true;
		queue = new LinkedList<Passenger>();
		queue.offer(new Passenger(x, y, ex, ey, d));
		
		while(!queue.isEmpty()) {
			Passenger p = queue.poll();
			if(p.x==p.endX && p.y==p.endY) {
				return p.distance;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				
				if(nx>0 && ny>0 && nx<=N && ny<=N) {
					if(map[nx][ny]==0 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.offer(new Passenger(nx, ny, ex, ey, p.distance+1));
					}
				}
			}
		}
		return -1;
	}
	
	public static void inputProcess() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1][N+1];
		psg = new Passenger[M];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		taxi = new Taxi(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), fuel);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			psg[i] = new Passenger(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		}
	}
}
