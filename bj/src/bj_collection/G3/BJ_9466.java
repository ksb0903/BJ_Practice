package bj_collection.G3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_9466 {
	
	static int N, student[], cnt;
	static boolean finish[], visited[];

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			N = Integer.parseInt(br.readLine());
			student = new int[N+1];
			finish = new boolean[N+1];
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			for(int i=1; i<=N; i++) {
				dfs(i);
			}
			
			bw.write((N-cnt) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void dfs(int cur) {
		if(visited[cur]) return;
		
		visited[cur] = true;
		int next = student[cur];
		
		if(!visited[next]) dfs(next);
		else {
			if(!finish[next]) {
				cnt++;
				for(int i=next; i!=cur; i=student[i]) {
					cnt++;
				}
			}
		}
		
		finish[cur] = true;
	}
}
