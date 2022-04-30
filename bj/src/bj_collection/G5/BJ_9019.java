package bj_collection.G5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9019 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int T, A, B;
	static boolean[] visited;
	
	static class Pair{
		int value;
		String cmd;
		
		public Pair(int value, String cmd) {
			super();
			this.value = value;
			this.cmd = cmd;
		}
	}
	
	public static void main(String[] args) throws IOException{
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			bw.write(bfs(A, B)+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static String bfs(int a, int b) {
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(a, ""));
		visited[a] = true;
		
		while(true) {
			Pair poll = queue.poll(); 
			
			if(poll.value==b) {
				return poll.cmd;
			}else {
				int D = opD(poll.value);
				int S = opS(poll.value);
				int L = opL(poll.value);
				int R = opR(poll.value);
				
				if(!visited[D]) {
					queue.offer(new Pair(D, poll.cmd+"D"));
					visited[D] = true;
				}
				if(!visited[S]) {
					queue.offer(new Pair(S, poll.cmd+"S"));
					visited[S] = true;
				}
				if(!visited[L]) {
					queue.offer(new Pair(L, poll.cmd+"L"));
					visited[L] = true;
				}
				if(!visited[R]) {
					queue.offer(new Pair(R, poll.cmd+"R"));
					visited[R] = true;
				}
			}
		}
	}
	
	public static int opD(int register) {
		return (register*2)%10000;
	}
	
	public static int opS(int register) {
		if(register==0) return 9999;
		else return register-1;
	}
	
	public static int opL(int register) {
		return (register%1000)*10 + register/1000;
	}
	
	public static int opR(int register) {
		return (register%10)*1000 + register/10;
	}
}
