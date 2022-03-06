package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11724 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, p[];
	static boolean[] found;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		found = new boolean[N+1];
		makeSet();
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			unionSet(a, b);
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++) {
			int j = findSet(i);
			if(!found[j]) {
				found[j] = true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void makeSet() {
		p = new int[N+1];
		for(int i=1; i<=N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x==p[x]) return x;
		else return p[x] = findSet(p[x]);
	}
	
	public static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px==py) return;
		
		p[py] = px;
	}
}
