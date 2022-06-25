package bj_collection.G2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10775 {
	
	static int G, P;
	static int gate[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		make();
		
		int cnt = 0;
		for(int i=0; i<P; i++) {
			int g = Integer.parseInt(br.readLine());
			
			int empty = find(g);
			if(empty==0) break;
			cnt++;
			union(empty, empty-1);
		}
		
		System.out.println(cnt);
	}
	
	public static void make() {
		gate = new int[G+1];
		for(int i=1; i<=G; i++) {
			gate[i] = i;
		}
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) gate[aRoot] = bRoot;
	}
	
	public static int find(int a) {
		if(a == gate[a]) return a;
		
		return gate[a] = find(gate[a]);
	}
}
