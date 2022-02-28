package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
	static Queue<Integer> queue_row = new LinkedList<>();  
	static Queue<Integer> queue_col = new LinkedList<>(); 
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	static int M, N;
	
	public static int solve(int[][] arr) {
		int day=-1;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1) {
					queue_row.offer(i);
					queue_col.offer(j);
				}
			}
		}
		
		while(!queue_row.isEmpty()) {
			int qSize = queue_row.size();
			while(qSize>0) {
				search(arr, queue_row.poll(), queue_col.poll());
				qSize--;
			}
			day++;
		}
		return day;
	}
	
	public static void search(int[][] arr, int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			
			if(nr>=0 && nc>=0 && nr<N && nc<M && arr[nr][nc]==0) {
				arr[nr][nc]=1;
				queue_row.offer(nr);
				queue_col.offer(nc);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = solve(arr);
		outer: for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					day=-1;
					break outer;
				}
			}
		}
		
		bw.write(String.valueOf(day));
		
		bw.flush();
		br.close();
		bw.close();
	}
}

