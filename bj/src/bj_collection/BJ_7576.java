package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_7576 {
	static Queue<Integer> queue_row = new LinkedList<>();  
	static Queue<Integer> queue_col = new LinkedList<>(); 
	static int[][] deltas = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	
	public static int solve(int[][] arr) {
		int day=0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==1) {
					queue_row.offer(i);
					queue_col.offer(j);
				}
			}
		}
		queue_row.offer(-1);
		queue_col.offer(-1);
		
		while(true) {
			if(queue_row.peek()==-1) {
				queue_row.poll();
				queue_col.poll();
				
				if(queue_row.isEmpty()) {
					return day;
				}
				
				queue_row.offer(-1);
				queue_col.offer(-1);
				day++;
			}else {
				search(arr, queue_row.poll(), queue_col.poll());
			}
		}
	}
	
	public static void search(int[][] arr, int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r+deltas[i][0];
			int nc = c+deltas[i][1];
			
			if(nr>=0 && nc>=0 && nr<arr.length && nc<arr[0].length && arr[nr][nc]==0) {
				arr[nr][nc]=1;
				queue_row.offer(nr);
				queue_col.offer(nc);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int m, n;
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		int[][] arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			s = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int day = solve(arr);
		outer: for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
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

