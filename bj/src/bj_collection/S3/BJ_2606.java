package bj_collection.S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2606 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		V = Integer.parseInt(br.readLine());
		E = Integer.parseInt(br.readLine());
		for(int i=0; i<=V; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		boolean visited[] = new boolean[V+1];
		visited[1] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(1);
		while(!q.isEmpty()) {
			int poll = q.poll();
			
			for(int link: list.get(poll)) {
				if(!visited[link]) {
					visited[link] = true;
					q.offer(link);
				}
			}
		}
		
		int cnt=0;
		for(boolean b: visited) {
			if(b) cnt++;
		}
		
		return cnt-1;
	}
}
