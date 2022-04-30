package bj_collection.S1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205 {
	static int N;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			dist = new int[N+2][2];
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				dist[i][0] = Integer.parseInt(st.nextToken());
				dist[i][1] = Integer.parseInt(st.nextToken());
			}
			
			if(solve()) {
				bw.write("happy\n");
			}else {
				bw.write("sad\n");
			}
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean solve() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+2];
		q.offer(0);
		
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			if(visited[poll]) continue;
			visited[poll] = true;
			
			int x = dist[poll][0];
			int y = dist[poll][1];
			
			for(int i=1; i<N+2; i++) {
				if(visited[i]) continue;
				
				if((Math.abs(dist[i][0]-x) + Math.abs(dist[i][1]-y))<=1000) {
					if(i==N+1) return true;
					q.offer(i);
				}
			}
		}
		
		return false;
	}
}
