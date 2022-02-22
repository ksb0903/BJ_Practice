package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int V, E;
	static int[] p;
	static Edge[] eList;
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		eList = new Edge[E];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			eList[i] = new Edge(start, end, weight);
		}
		
		Arrays.sort(eList);
		makeSet();
		getWeight();
	}
	
	public static void getWeight() {
		int cnt = 0;
		int result = 0;
		
		for(Edge e: eList) {
			if(unionSet(e.start, e.end)) {
				result += e.weight;
				if(++cnt==V-1) break;
			}
		}
		System.out.println(result);
	}
	
	public static void makeSet() {
		p = new int[V+1];
		for(int i=1; i<=V; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a==p[a]) return a;
		return p[a] = findSet(p[a]);
	}
	
	public static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		p[bRoot] = aRoot;
		return true;
	}
}
