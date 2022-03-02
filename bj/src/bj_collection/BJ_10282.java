package bj_collection;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10282 {
	
	static class Edge implements Comparable<Edge>{
		int v, s;

		public Edge(int v, int s) {
			super();
			this.v = v;
			this.s = s;
		}

		@Override
		public int compareTo(Edge o) {
			return this.s - o.s;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, D, C, distance[], INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> list;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			distance = new int[N+1];
			list = new ArrayList<>();
			
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<Edge>());
				distance[i] = INF;
			}
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				
				list.get(b).add(new Edge(a, s));
			}
			
			dijkstra(C);
			int last = 0;
			int cnt = N;
			for(int i=1; i<=N; i++) {
				if(distance[i]==INF) cnt--;
				else {
					last = Math.max(last, distance[i]);
				}
			}
			bw.write(cnt + " " + last + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start) {
		boolean visited[] = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.v]) continue;
			visited[edge.v] = true;
			
			for(Edge e: list.get(edge.v)) {
				if(!visited[e.v] && distance[e.v]>distance[edge.v]+e.s) {
					distance[e.v] = distance[edge.v] + e.s;
					pq.offer(new Edge(e.v, distance[e.v]));
				}
			}
		}
	}
}
