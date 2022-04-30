package bj_collection.G3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_1414 {
	static class Edge implements Comparable<Edge>{
		int node, cost;

		public Edge(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, sum;
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				if(s.charAt(j)=='0') continue;
				int num = (int)(s.charAt(j)-96);
				if(num<0) {
					num = num+58;
				}
				graph[i][j] = num;
				sum += num;
			}
		}
		
		System.out.println(sum - prim());
	}
	
	public static int prim() {
		int result = 0;
		int cnt = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(visited[edge.node]) continue;
			visited[edge.node] = true;
			
			result += edge.cost;
			for(int i=0; i<N; i++) {
				if(!visited[i] && graph[edge.node][i]!=0 || graph[i][edge.node]!=0) {
					if(graph[edge.node][i]!=0) pq.add(new Edge(i, graph[edge.node][i]));
					if(graph[i][edge.node]!=0) pq.add(new Edge(i, graph[i][edge.node]));
				}
			}
			if(++cnt==N) break;
		}
		if(cnt!=N) return sum+1;
		return result;
	}
}
