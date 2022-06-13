package bj_collection.G5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M;
	static int board[];
	static int ladders[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[101];
		ladders = new int[100];
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			ladders[from] = to;
		}

		System.out.println(bfs(1));
	}

	public static int bfs(int start) {
		int cnt = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[101];
		q.offer(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			while (size > 0) {

				int now = q.poll();

				for (int i = 1; i <= 6; i++) {
					int next = now + i;
					if(visited[next]) continue;
					
					if(next>=100) return cnt+1;
					if(ladders[next]!=0) {
						visited[next] = true;
						next = ladders[next];
					}
					q.offer(next);
					visited[next] = true;
				}
				
				size--;
			}
			
			cnt++;
		}
		
		return -1;
	}
}
