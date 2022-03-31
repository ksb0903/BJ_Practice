package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238 {
	static class Taxi{
		int x, y, fuel, move;

		public Taxi(int x, int y, int fuel, int move) {
			super();
			this.x = x;
			this.y = y;
			this.fuel = fuel;
			this.move = move;
		}
	}
	
	static class Passanger implements Comparable<Passanger>{
		int num, x, y, r, c; // x,y 에서 r,c로 가려고 함

		public Passanger(int num, int x, int y, int r, int c) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Passanger o) {
			if(this.x==o.x) {
				return this.y-o.y;
			}
			return this.x-o.x;
		}
	}
	
	static int[][] map, deltas = {{-1,0},{0,-1},{0,1},{1,0}};
	static int N, M;
	static Passanger psg[];
	static Taxi taxi;
	
	public static void main(String[] args) throws IOException {
		inputProcess();
		mainProcess();
	}

	public static void mainProcess() {
		for(int i=0; i<M; i++) {
			int[] passInfo = findPassanger(taxi);
			int passNum = passInfo[0];
			int dist = passInfo[1];
			
			if(passNum==-1 || dist==-1) {
				System.out.println(-1);
				return;
			}
			taxi.x = psg[passNum].x;
			taxi.y = psg[passNum].y;
			taxi.fuel -= dist;
			if(taxi.fuel<=0) {
				System.out.println(-1);
				return;
			}
			dist = move(passNum);
			if(dist==-1 || taxi.fuel<0) {
				System.out.println(-1);
				return;
			}
			taxi.fuel += dist*2;
		}
		
		System.out.println(taxi.fuel);
	}
	
	public static int move(int n) {
		boolean visited[][] = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {psg[n].x, psg[n].y});
		visited[psg[n].x][psg[n].y] = true;
		int dist = 0;
		int size = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			++dist;
			while(size>0) {
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>0 && ny>0 && nx<=N && ny<=N && !visited[nx][ny]) {
						if(map[nx][ny]==1) continue;
						
						if(nx==psg[n].r && ny==psg[n].c) {
							taxi.x = psg[n].r;
							taxi.y = psg[n].c;
							taxi.fuel -= dist;
							return dist;
						}
						
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
					}
				}
				--size;
			}
		}
		return -1;
	}
	
	public static int[] findPassanger(Taxi taxi) {
		if(map[taxi.x][taxi.y]!=0) {
			int idx = map[taxi.x][taxi.y] * -1;
			map[taxi.x][taxi.y] = 0;
			return new int[] {idx, 0};
		}
		PriorityQueue<Passanger> pq = new PriorityQueue<>();
		boolean visited[][] = new boolean[N+1][N+1];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {taxi.x, taxi.y});
		visited[taxi.x][taxi.y] = true;
		int dist = 0;
		int size = 0;
		boolean find = false;
		
		while(!q.isEmpty()) {
			if(find) break;
			size = q.size();
			++dist;
			while(size>0) {
			
				int[] poll = q.poll();
				int x = poll[0];
				int y = poll[1];
				
				for(int d=0; d<4; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>0 && ny>0 && nx<=N && ny<=N && !visited[nx][ny]) {
						if(map[nx][ny]==1) continue;
						
						if(map[nx][ny]==0) {
							visited[nx][ny] = true;
							q.offer(new int[] {nx, ny});
						}
						
						if(map[nx][ny]<0) {
							int idx = map[nx][ny]*-1;
							pq.add(psg[idx]);
							find = true;
						}
					}
				}
				
				--size;
			}
		}
		if(pq.size()==0) return new int[] {-1, -1};
		else {
			Passanger p = pq.poll();
			map[p.x][p.y] = 0;
			return new int[] {p.num, dist};
		}
	}

	public static void inputProcess() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		taxi = new Taxi(x, y, fuel, 0);
		
		psg = new Passanger[M+1];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			psg[i] = new Passanger(i, x, y, r, c);
			map[x][y] = i*-1;
		}
	}
}
