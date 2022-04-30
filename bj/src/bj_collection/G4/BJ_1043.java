package bj_collection.G4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1043 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, ans;
	static int[][] parties;
	static boolean[] people;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new boolean[N+1];
		parties = new int[M][];
		
		st = new StringTokenizer(br.readLine());
		int knowCnt = Integer.parseInt(st.nextToken());
		if(knowCnt!=0) {
			for(int i=0; i<knowCnt; i++) {
				people[Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			parties[i] = new int[Integer.parseInt(st.nextToken())];
			
			for(int j=0; j<parties[i].length; j++) {
				parties[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getKnow();
		
		for(int i=0; i<M; i++) {
			boolean flag = false;
			for(int j=0; j<parties[i].length; j++) {
				if(people[parties[i][j]]) {
					flag = true;
					break;
				}
			}
			if(!flag) ans++;
		}
		
		System.out.println(ans);
	}
	
	public static void getKnow() {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			if(people[i]) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			for(int i=0; i<M; i++) {
				for(int j=0; j<parties[i].length; j++) {
					if(people[parties[i][j]]) {
						for(int k=0; k<parties[i].length; k++) {
							if(people[parties[i][k]]==false) {
								queue.offer(parties[i][j]);
								people[parties[i][k]] = true;
							}
						}
						break;
					}
				}
			}
			queue.poll();
		}
	}
}
