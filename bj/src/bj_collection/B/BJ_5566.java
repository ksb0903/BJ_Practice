package bj_collection.B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5566 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, M, board[], pos;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N];
		pos = 0;
		
		for(int i=0; i<N; i++) {
			board[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt = 0;
		for(int i=0; i<M; i++) {
			cnt++;
			int x = Integer.parseInt(br.readLine());
			if(process(x)) {
				System.out.println(cnt);
				break;
			}
		}
	}
	
	public static boolean process(int x) {
		pos += x;
		if(pos>=N-1) return true;
		
		pos += board[pos];
		if(pos>=N-1) return true;
		return false;
	}
}
