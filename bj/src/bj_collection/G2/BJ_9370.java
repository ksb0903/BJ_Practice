package bj_collection.G2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_9370 {
	static class Edge implements Comparable<Edge>{
		int num, dist;

		public Edge(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N, M, T, S, G, H, INF = Integer.MAX_VALUE;
	// N 정점 개수, M 간선 개수, T 목적지 후보 개수, S 출발지, G-H 지나간 간선
	static ArrayList<ArrayList<Edge>> list;
	static int[] distance, destination;
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws IOException{
		int Tc = Integer.parseInt(br.readLine());
		for(int tc=0; tc<Tc; tc++) {
			inputProcess();
			dijkstra(S);
			
			for(int i=0; i<T; i++) {
				if(distance[destination[i]]%2==1 && distance[destination[i]]!=INF) result.add(destination[i]);
			}
			
			Collections.sort(result);
			for(int i=0; i<result.size(); i++) {
				bw.write(result.get(i) + " ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dijkstra(int start) {
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.num]) continue;
			visited[edge.num] = true;
			
			for(Edge e: list.get(edge.num)) {
				if(!visited[e.num] && e.dist!=0 && distance[e.num]>distance[edge.num]+e.dist) {
					distance[e.num] = distance[edge.num] + e.dist;
					pq.offer(new Edge(e.num, distance[e.num]));
				}
			}
		}
		
	}
	
	public static void inputProcess() throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		distance = new int[N+1];
		destination = new int[T];
		result = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
			distance[i] = INF;
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(a==G && b==H || a==H && b==G) {
				list.get(a).add(new Edge(b, 2*d-1));
				list.get(b).add(new Edge(a, 2*d-1));
			}else {
				list.get(a).add(new Edge(b, 2*d));
				list.get(b).add(new Edge(a, 2*d));
			}
		}
		
		for(int i=0; i<T; i++) {
			destination[i] = Integer.parseInt(br.readLine());
		}
	}
}
