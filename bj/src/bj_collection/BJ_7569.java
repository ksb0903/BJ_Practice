package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {
	static Queue<Integer> queue_row = new LinkedList<Integer>();
	static Queue<Integer> queue_col = new LinkedList<Integer>();
	static Queue<Integer> queue_depth = new LinkedList<Integer>();
	static int[][] deltas = {{0,1,0},{1,0,0},{0,-1,0},{-1,0,0},{0,0,-1},{0,0,1}};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int M, N, H;
	static int[][][] arr;
	
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		arr = new int[H][N][M];
		
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					arr[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		int day = getDay();
		
		outer: for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					if(arr[h][n][m]==0) {
						day=-1;
						break outer;
					}
				}
			}
		}
		bw.write(day+"");
		bw.flush();
		bw.close();
	}
	
	public static int getDay() {
		int day=0;
		
		for(int d=0; d<H; d++) {
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(arr[d][r][c]==1) {
						queue_row.offer(r);
						queue_col.offer(c);
						queue_depth.offer(d);
					}
				}
			}
		}
		
		queue_row.offer(-1);
		
		
		while(true) {
			if(queue_row.peek()==-1) {
				queue_row.poll();
			
			
				if(queue_row.isEmpty()) {
					return day;
				}
			
				queue_row.offer(-1);
				day++;
			}else {
				search(queue_row.poll(), queue_col.poll(), queue_depth.poll());
			}
		}
	}
	
	public static void search(int r, int c, int d) {
		for(int i=0; i<6; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			int nd = d+deltas[i][2];
		
			if(nr>=0 && nc>=0 && nd>=0 && nr<N && nc<M && nd<H && arr[nd][nr][nc]==0) {
				arr[nd][nr][nc] = 1;
				queue_row.offer(nr);
				queue_col.offer(nc);
				queue_depth.offer(nd);
			}
		}
	}
}
