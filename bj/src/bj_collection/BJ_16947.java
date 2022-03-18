package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16947 {
	static boolean[] visited, cycle;
	static int N, dist[];
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		cycle = new boolean[N+1];
		for(int i=1; i<=N; i++) {
			visited = new boolean[N+1];
			if(isCycle(i, -1, i)) break;
		}
		
		dist = new int[N+1];
		bfs();
		
		for(int i=1; i<=N; i++) {
			bw.write(String.format("%d ", dist[i]));
		}
		bw.flush();
		bw.close();
	}
	
	public static void bfs() {
		visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1; i<=N; i++) {
			if(cycle[i]) {
				visited[i] = true;
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int poll = queue.poll();
			for(int v: list.get(poll)) {
				if(visited[v]) continue;
				
				queue.offer(v);
				visited[v] = true;
				dist[v] = dist[poll]+1;
			}
		}
	}
	
	public static boolean isCycle(int v, int pre, int start) {
		visited[v] = true;
		for(int i: list.get(v)) {
			if(!visited[i]) {
				if(isCycle(i, v, start)) {
					cycle[i] = true;
					return true;
				}
			}else if(i!=pre && i==start) {
				cycle[i] = true;
				return true;
			}
		}
		return false;
	}
}
