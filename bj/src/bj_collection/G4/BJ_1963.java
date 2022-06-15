package bj_collection.G4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1963 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static boolean prime[] = new boolean[10000];
	
	public static void main(String[] args) throws IOException{
		findPrime();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(from==to) {
				bw.write("0\n");
			}else {
				int res = bfs(from, to);
				
				if(res==-1) {
					bw.write("Impossible\n");
				}else {
					bw.write(res + "\n");
				}
			}
		}
		bw.flush();
		bw.close();
	}
	
	static int bfs(int from, int to) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[10000];
		q.offer(from);
		visited[from] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while(size>0) {
				int x = q.poll();
				
				for(int i=0; i<4; i++) {
					char[] c = String.valueOf(x).toCharArray();
					
					for(int j=0; j<=9; j++) {
						c[i] = (char)(j + '0');
						int nx = Integer.parseInt(String.valueOf(c));
						
						if(nx>=1000 && nx<10000 && !visited[nx] && !prime[nx]) {
							if(nx==to) {
								return cnt;
							}
							
							q.offer(nx);
							visited[nx] = true;
						}
					}
				}
				
				size--;
			}
		}
		
		return -1;
	}
	
	static void findPrime() {
		prime[0] = prime[1] = true;
		
		for(int i=2; i*i<=9999; i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=9999; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
}
