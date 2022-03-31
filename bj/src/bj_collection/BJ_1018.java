package bj_collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018 {
	static int N, M, min = Integer.MAX_VALUE;
	static char[][] board;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for(int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int fw_cnt = 0;
				int fb_cnt = 0;
				
				for(int r=i; r<i+8; r++) {
					for(int c=j; c<j+8; c++) {
						if((r+c)%2==0) {
							if(board[r][c]=='W') {
								fb_cnt++;
							}else {
								fw_cnt++;
							}
						}else {
							if(board[r][c]=='W') {
								fw_cnt++;
							}else {
								fb_cnt++;
							}
						}
					}
				}
				min = Math.min(min, fw_cnt);
				min = Math.min(min, fb_cnt);
			}
		}
		System.out.println(min);
	}
}
