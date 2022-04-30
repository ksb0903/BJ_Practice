package bj_collection.G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1707 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int V, E;
	static ArrayList<ArrayList<Integer>> list;
	static int[] vertexSet;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList<>();
			vertexSet = new int[V+1];
			visited = new boolean[V+1];
			
			for(int i=0; i<=V; i++) {
				list.add(new ArrayList<>());
			}
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			
			boolean flag = true;
			for(int i=1; i<=V; i++) {
				if(visited[i]) continue;
				
				if(!bfs(i)) {
					flag = false;
					break;
				}
			}
			
			if(flag) bw.write("YES\n");
			else bw.write("NO\n");
			
		}
		bw.flush();
		bw.close();
	}
	
	public static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		vertexSet[start] = 1;
		
		while(!q.isEmpty()) {
			int x = q.poll();
			visited[x] = true;
			
			for(int num: list.get(x)) {
				if(!visited[num]) {
					q.offer(num);
					vertexSet[num] = (vertexSet[x]==1)? 2: 1;
				}else {
					if(vertexSet[num]==vertexSet[x]) return false;
				}
			}
		}
		
		return true;
	}
}
