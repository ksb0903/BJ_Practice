package bj_collection.G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2252 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N, M, indegree[];
	static LinkedList<LinkedList<Integer>> list = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			list.add(new LinkedList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			indegree[b]++;
		}
		
		solve();
		bw.flush();
		bw.close();
	}
	
	public static void solve() throws IOException{
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> res = new LinkedList<>();
		
		for(int i=1; i<=N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.poll();
			res.offer(x);
			
			for(int i: list.get(x)) {
				indegree[i]--;
				
				if(indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		for(int i: res) {
			bw.write(i + " ");
		}
	}
}
