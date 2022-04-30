package bj_collection.S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1260 {
	static BufferedReader br;
	static BufferedWriter bw;
	static int[][] map;
	static boolean[] visited;
	static StringTokenizer st;
	static int N, M, V, start, end;
	
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		dfs(V);
		bw.write("\n");
		Arrays.fill(visited, false);
		bfs(V);
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int point) throws IOException{
		Stack<Integer> stack = new Stack<>();
		stack.push(point);
		visited[point] = true;
		bw.write(point + " ");
		
		while(!stack.isEmpty()) {
			for(int i=1; i<=N; i++) {
				if(map[point][i]==1 && visited[i]==false) {
					stack.push(i);
					visited[i]=true;
					dfs(i);
				}
			}
			stack.pop();
		}
	}
	
	public static void bfs(int point) throws IOException{
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(point);
		visited[point]=true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			bw.write(x + " ");
			for(int i=1; i<=N; i++) {
				if(map[x][i]==1 && visited[i]==false) {
					queue.offer(i);
					visited[i]=true;
				}
			}

		}
	}
}
