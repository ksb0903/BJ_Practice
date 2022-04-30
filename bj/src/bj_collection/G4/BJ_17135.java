package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135 {
	/*1. 궁수의 위치를 정한다.
	2. 공격한다.
	3. 적들이 이동한다.
	4. 2~3 반복*/
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D, killCnt, max;
	static int[][] map;
	static int[] select;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		select = new int[3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0);
		System.out.println(max);
	}
	
	public static void solve(int cnt, int start) {
		if(cnt==3) {
			int[][] clone = new int[N][M];
			for(int i=0; i<N; i++) {
				clone[i] = map[i].clone(); 
			}
			
			killCnt = 0;
			while(getEnemy(clone)!=0) {
				for(int i=0; i<3; i++) {
					clone = attack(clone, N-1, select[i]);
				}
				clone = moveEnemy(clone);
			}
			max = Math.max(killCnt, max);
			return;
		}
		
		for(int i=start; i<M; i++) {
			select[cnt] = i;
			solve(cnt+1, i+1);
		}
	}
	
	public static int[][] moveEnemy(int[][] arr){
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<M; j++) {
				arr[i][j] = arr[i-1][j];
				if(arr[i][j]==-1) arr[i][j]=0;
			}
		}
		
		for(int j=0; j<M; j++) {
			arr[0][j] = 0;
		}
		
		return arr;
	}
	
	public static int[][] attack(int[][] arr, int row, int col){
		if(arr[row][col]==1) {
			arr[row][col] = -1;
			killCnt++;
			return arr;
		}else if(arr[row][col]==-1) {
			return arr;
		}
		
		int[][] deltas = {{0,-1},{-1,0},{0,1}}; 
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		xq.offer(row);
		yq.offer(col);
		int range = 1;
		
		while(!xq.isEmpty() && range<D) {
			int qSize = xq.size();
			
			for(int s=0; s<qSize; s++) {
				int x = xq.poll();
				int y = yq.poll();
				for(int d=0; d<3; d++) {
					int nx = x + deltas[d][0];
					int ny = y + deltas[d][1];
					
					if(nx>=0 && ny>=0 && ny<M) {
						if(arr[nx][ny]==1) {
							killCnt++;
							arr[nx][ny] = -1;
							return arr;
						}else if(arr[nx][ny]==-1) {
							return arr;
						}else {
							xq.offer(nx);
							yq.offer(ny);
						}
					}
				}
			}
			range++;
		}
		
		return arr;
	}
	
	public static int getEnemy(int[][] arr) {
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) cnt++;
			}
		}
		
		return cnt;
	}
}
