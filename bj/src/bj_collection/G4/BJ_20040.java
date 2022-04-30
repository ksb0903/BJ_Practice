package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20040 {
	static int N, M, p[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		makeSet();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(unionSet(a, b)) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(0);
	}
	
	public static boolean unionSet(int a, int b) {
		int x = findSet(a);
		int y = findSet(b);
		if(x==y) return true;
		
		p[y] = x;
		return false;
	}
	
	public static int findSet(int x) {
		if(p[x]==x) return x;
		return p[x]=findSet(p[x]);
	}
	
	public static void makeSet() {
		p = new int[N];
		for(int i=0; i<N; i++) {
			p[i] = i;
		}
	}
}
