package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1967 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, p[];
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		makeSet();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x==1) unionSet(i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int start = findSet(Integer.parseInt(st.nextToken()));
		for(int i=1; i<M; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(start !=findSet(next)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
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
	
	public static void unionSet(int a, int b) {
		int fa = findSet(a);
		int fb = findSet(b);
		if(fa==fb) return;
		else p[fb] = fa;
	}
}
