package bj_collection.G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_11437 {
	
	static int N, M, depth[], parent[];
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		depth = new int[N+1];
		parent = new int[N+1];
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(1, 1);
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(find(a, b) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int num, int d) {
		depth[num] = d;
		
		for(int i: list.get(num)) {
			if(depth[i]==0) {
				dfs(i, d+1);
				parent[i] = num;
			}
		}
	}
	
	public static int find(int a, int b) {
		while(true) {
			if(a==b) return a;
			
			if(depth[a] > depth[b]) {
				a = parent[a];
			}else if(depth[a] < depth[b]) {
				b = parent[b];
			}else {
				a = parent[a];
				b = parent[b];
			}
		}
	}
}
